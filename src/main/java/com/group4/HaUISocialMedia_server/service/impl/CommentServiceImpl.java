package com.group4.HaUISocialMedia_server.service.impl;

import com.group4.HaUISocialMedia_server.dto.CommentDto;
import com.group4.HaUISocialMedia_server.dto.NotificationDto;
import com.group4.HaUISocialMedia_server.entity.*;
import com.group4.HaUISocialMedia_server.repository.CommentRepository;
import com.group4.HaUISocialMedia_server.repository.PostRepository;
import com.group4.HaUISocialMedia_server.repository.UserRepository;
import com.group4.HaUISocialMedia_server.service.CommentService;
import com.group4.HaUISocialMedia_server.service.NotificationService;
import com.group4.HaUISocialMedia_server.service.NotificationTypeService;
import com.group4.HaUISocialMedia_server.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private NotificationTypeService notificationTypeService;

    @Override
    public Set<CommentDto> getParentCommentsOfPost(UUID postId) {
        Post post = postRepository.findById(postId).orElse(null);
        if (post == null)
            return null;
        Set<CommentDto> res = new HashSet<>();
        List<Comment> li = commentRepository.findAllByPost(postId);
        li.stream().map(CommentDto::new).forEach(res::add);
        return res;
    }

    @Override
    public Set<CommentDto> getSubCommentOfComment(UUID commentId) {
        Comment comment = commentRepository.findById(commentId).orElse(null);
        if (comment == null)
            return null;
        Set<CommentDto> res = new HashSet<>();
        Set<Comment> re = comment.getSubComments();
        re.stream().map(CommentDto::new).forEach(res::add);
        return res;
    }

    @Override
    public CommentDto getById(UUID commentId) {
        return new CommentDto(commentRepository.findById(commentId).orElse(null));
    }

    @Override
    @Transactional
    public CommentDto createComment(CommentDto dto) {
        if (dto == null)
            return null;
        Comment comment = new Comment();
        comment.setContent(dto.getContent());
        comment.setCreateDate(new Date());

        // User user = userRepository.findById(dto.getCommenter().getId()).orElse(null);
        User user = userService.getCurrentLoginUserEntity();
//        if(user == null){
//            return null;
//        }
        comment.setOwner(user);


        Post post = postRepository.findById(dto.getPost().getId()).orElse(null);
        if (post == null)
            return null;
        comment.setPost(post);

        if (dto.getRepliedComment() != null) {
            Comment commentParent = commentRepository.findById(dto.getRepliedComment().getId()).orElse(null);
            if (commentParent != null) {
                comment.setRepliedComment(commentParent);
                //create notification
                User receiverUser = commentParent.getOwner();
                NotificationType notificationType = notificationTypeService.getNotificationTypeEntityByName("Post");

                Notification notification = new Notification();
                notification.setCreateDate(new Date());
                notification.setContent(user.getUsername() + " đã trả lời bình luận của bạn trong một bài viết");
                notification.setPost(post);
                notification.setOwner(receiverUser);
                notification.setNotificationType(notificationType);

                notificationService.save(new NotificationDto(notification));
            }
        }
        Comment comment1 = commentRepository.save(comment);

        //create notification
        User receiverUser = post.getOwner();

        if (!receiverUser.getId().equals(user.getId())) {
            NotificationType notificationType = notificationTypeService.getNotificationTypeEntityByName("Post");

            Notification notification = new Notification();
            notification.setCreateDate(new Date());
            notification.setContent(user.getUsername() + " đã bình luận một bài đăng của bạn");
            notification.setPost(post);
            notification.setOwner(receiverUser);
            notification.setActor(user);
            notification.setNotificationType(notificationType);

            notificationService.save(new NotificationDto(notification));
        }


        return new CommentDto(comment1);
    }

    @Override
    @Transactional
    public CommentDto updateComment(CommentDto dto) {
        Comment comment = commentRepository.findById(dto.getId()).orElse(null);

        if (comment == null)
            return null;
        comment.setContent(dto.getContent());
        comment.setCreateDate(new Date());

//        User user = userRepository.findById(dto.getId()).orElse(null);
//        if(user != null)
//            comment.setOwner(user);

//        Post post = postRepository.findById(dto.getId()).orElse(null);
//        comment.setPost(post);

        //       Comment commentParent = commentRepository.findById(dto.getRepliedComment().getId()).orElse(null);
//        if(commentParent != null)
//        comment.setRepliedComment(commentParent);

        return new CommentDto(commentRepository.saveAndFlush(comment));
    }

    @Override
    @Transactional
    public CommentDto deleteComment(UUID commentId) {
        Comment comment = commentRepository.findById(commentId).orElse(null);
        if (comment == null)
            return null;
        //Use to delete children of comment
        commentRepository.deleteAllByRepliedComment(comment.getId());
        commentRepository.delete(comment);

        return new CommentDto(comment);
    }

    @Override
    public boolean hasAuthorityToChange(UUID commentId) {
        Comment entity = commentRepository.findById(commentId).orElse(null);
        if (entity == null) return false;

        User currentUser = userService.getCurrentLoginUserEntity();
        if (currentUser.getId() != entity.getOwner().getId()) return false;
        return true;
    }

    @Override
    public void deleteAllByIdPost(UUID idPost) {
        commentRepository.getReferenceById(idPost);
    }
}
