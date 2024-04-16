package com.group4.HaUISocialMedia_server.service.impl;

import com.group4.HaUISocialMedia_server.dto.*;
import com.group4.HaUISocialMedia_server.entity.*;
import com.group4.HaUISocialMedia_server.repository.*;
import com.group4.HaUISocialMedia_server.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostImageRepository postImageRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private RelationshipRepository relationshipRepository;

    @Autowired
    private PostImageService postImageService;

    @Autowired
    private UserService userService;

    @Autowired
    private RelationshipService relationshipService;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private NotificationTypeRepository notificationTypeRepository;

    @Autowired
    private LikeService likeService;

    @Autowired
    private CommentService commentService;

    @Override
    public Set<PostDto> getNewsFeed(SearchObject searchObject) {
        User currentUser = userService.getCurrentLoginUserEntity();

        if (currentUser == null || searchObject == null) return null;

        Post entity = null;
        if (searchObject.getMileStoneId() != null)
            entity = postRepository.findById(searchObject.getMileStoneId()).orElse(null);

        Date mileStoneDate = new Date();
        if (entity != null) mileStoneDate = entity.getCreateDate();

        Set<UUID> userIds = new HashSet<>();
        userIds.add(currentUser.getId());
        List<Relationship> acceptedRelationships = relationshipRepository.findAllAcceptedRelationship(currentUser.getId());
        for (Relationship relationship : acceptedRelationships) {
            userIds.add(relationship.getReceiver().getId());
            userIds.add(relationship.getRequestSender().getId());
        }

        List<PostDto> newsFeed = postRepository.findNext5PostFromMileStone(new ArrayList<>(userIds), mileStoneDate, PageRequest.of(searchObject.getPageIndex(), searchObject.getPageSize()));

        //Cách 2: Truyền tham so
        // List<PostDto> newsFeed = postRepository.findNext5PostFromMileStone(new ArrayList<>(userIds), mileStoneDate, PageRequest.of(searchObject.getPageIndex(), searchObject.getPageSize()));

        //Vì khi đưa List vào Set thì thứ tự sắp xếp từ trước nó đã bị thay đổi ví dụ 9 8 7 6 -> set sẽ thành 9 7 6 8
        //Nên chúng ta cần dùng Lamda collection để có thể sắp xếp nó
        Set<PostDto> res = new TreeSet<>((post1, post2) -> post2.getCreateDate().compareTo(post1.getCreateDate()));
        res.addAll(newsFeed);

        for (PostDto postDto : res) {
            postDto.setLikes(likeService.getListLikesOfPost(postDto.getId()));
            postDto.setComments(commentService.getParentCommentsOfPost(postDto.getId()));
        }

        return res;
    }

    @Override
    public boolean hasAuthorityToChange(UUID postId) {
        Post entity = postRepository.findById(postId).orElse(null);
        if (entity == null) return false;

        User currentUser = userService.getCurrentLoginUserEntity();
        if (!entity.getOwner().getId().equals(currentUser.getId())) return false;

        return true;
    }

    @Override
    public PostDto createPost(PostDto dto) {
        User currentUser = userService.getCurrentLoginUserEntity();
        if (currentUser == null || dto == null) return null;

        Post entity = new Post();
        entity.setCreateDate(new Date());
        entity.setContent(dto.getContent());
        entity.setOwner(currentUser);


        Post savedEntity = postRepository.save(entity);
        if (!dto.getImages().isEmpty()) {
            entity.setPostImages(dto.getImages().stream().map(x -> {
                PostImage postImage = new PostImage();
                // postImage.setId(x.getId());
                 if(x.getPost() != null)
                     postImage.setPost(postRepository.findById(savedEntity.getId()).orElse(null));
                postImage.setDescription(x.getDescription());
                postImage.setImage(x.getImage());
                postImage.setCreateDate(new Date());
                postImageRepository.save(postImage);
                return postImage;
            }).collect(Collectors.toSet()));
        }
        //alert all friends that this user has created new post
        SearchObject so = new SearchObject();
        so.setPageIndex(1);
        so.setPageSize(5000);
        List<UserDto> listFriends = relationshipService.getCurrentFriends(so);
        for (UserDto friend : listFriends) {
            Notification noti = new Notification();
            noti.setActor(currentUser);
            noti.setCreateDate(new Date());
            noti.setContent(currentUser.getUsername() + " đã tạo một bài viết mới: " + savedEntity.getContent());
            noti.setOwner(userService.getUserEntityById(friend.getId()));
            noti.setNotificationType(notificationTypeRepository.findByName("Post"));

            //postId now is referenceId in notification
            noti.setPost(savedEntity);
            Notification savedNoti = notificationRepository.save(noti);

            //send this noti via socket
            simpMessagingTemplate.convertAndSendToUser(friend.getId().toString(), "/notification", new NotificationDto(savedNoti));
        }

        PostDto responseDto = new PostDto(savedEntity);
        responseDto.setImages(savedEntity.getPostImages().stream().map(PostImageDTO::new).collect(Collectors.toSet()));
        return responseDto;
    }


    @Override
    public PostDto updatePost(PostDto dto) {
        if (dto == null) return null;

        Post entity = postRepository.findById(dto.getId()).orElse(null);
        if (entity == null) return null;

        entity.setContent(dto.getContent());

        Post savedEntity = postRepository.save(entity);

        PostDto responseDto = new PostDto(savedEntity);
        responseDto.setLikes(likeService.getListLikesOfPost(responseDto.getId()));
        responseDto.setComments(commentService.getParentCommentsOfPost(responseDto.getId()));
        return responseDto;
    }

    @Override
    @Transactional
    public boolean deletePost(UUID postId) {
        Post entity = postRepository.findById(postId).orElse(null);
        if (entity == null) return false;
        postRepository.delete(entity);

        //Delete all comment, like by id
        //commentService.deleteAllByIdPost(postId);
        // likeService.deleteByAllByPost(postId);
        notificationRepository.deleteNotificationByIdPost(postId);
        return true;
    }

    @Override
    public Set<PostDto> getPostsOfUser(UUID userId, SearchObject searchObject) {
        User currentUser = userService.getCurrentLoginUserEntity();

        if (currentUser == null || searchObject == null) return null;

        Post entity = null;
        if (searchObject.getMileStoneId() != null)
            entity = postRepository.findById(searchObject.getMileStoneId()).orElse(null);

        Date mileStoneDate = new Date();
        if (entity != null) mileStoneDate = entity.getCreateDate();

        Set<UUID> userIds = new HashSet<>();
        userIds.add(userId);

        //List<PostDto> newsFeed = postRepository.findNext5PostFromMileStone(new ArrayList<>(userIds), mileStoneDate, PageRequest.of(searchObject.getPageIndex(), searchObject.getPageSize(), Sort.by("createDate")));
//        List<PostDto> newsFeed = postRepository.findNext5PostFromMileStone(new ArrayList<>(userIds), mileStoneDate, searchObject.getPageSize(), (searchObject.getPageIndex() - 1)*searchObject.getPageSize());
        List<PostDto> newsFeed = postRepository.findNext5PostFromMileStone(new ArrayList<>(userIds), mileStoneDate, PageRequest.of(searchObject.getPageIndex(), searchObject.getPageSize()));

        Set<PostDto> res = new TreeSet<>((post1, post2) -> post2.getCreateDate().compareTo(post1.getCreateDate()));
        res.addAll(newsFeed);
        for (PostDto postDto : res) {
            postDto.setLikes(likeService.getListLikesOfPost(postDto.getId()));
            postDto.setComments(commentService.getParentCommentsOfPost(postDto.getId()));
        }

        return res;
    }

    @Override
    public PostDto getById(UUID postId) {
        Post entity = postRepository.findById(postId).orElse(null);
        if (entity == null) return null;

        PostDto responseDto = new PostDto(entity);
        responseDto.setLikes(likeService.getListLikesOfPost(responseDto.getId()));
        responseDto.setComments(commentService.getParentCommentsOfPost(responseDto.getId()));
//        responseDto.setImages(entity.getPostImages().stream().map(PostImageDTO::new).collect(Collectors.toSet()));
        responseDto.setImages(postImageService.sortImage(entity.getId()));
        return responseDto;
    }
}
