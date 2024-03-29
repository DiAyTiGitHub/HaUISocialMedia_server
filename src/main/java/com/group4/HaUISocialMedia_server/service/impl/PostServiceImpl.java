package com.group4.HaUISocialMedia_server.service.impl;

import com.group4.HaUISocialMedia_server.dto.PostDto;
import com.group4.HaUISocialMedia_server.dto.SearchObject;
import com.group4.HaUISocialMedia_server.entity.Post;
import com.group4.HaUISocialMedia_server.entity.Relationship;
import com.group4.HaUISocialMedia_server.entity.User;
import com.group4.HaUISocialMedia_server.repository.PostRepository;
import com.group4.HaUISocialMedia_server.repository.RelationshipRepository;
import com.group4.HaUISocialMedia_server.repository.UserRepository;
import com.group4.HaUISocialMedia_server.service.PostService;
import com.group4.HaUISocialMedia_server.service.RelationshipService;
import com.group4.HaUISocialMedia_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private RelationshipRepository relationshipRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private RelationshipService relationshipService;

    @Override
    public Set<PostDto> getNewsFeed(SearchObject searchObject) {
        User currentUser = userService.getCurrentLoginUserEntity();

        if (currentUser == null || searchObject == null) return null;

        Post entity = postRepository.findById(searchObject.getMileStoneId()).orElse(null);
        Date mileStoneDate = new Date();
        if (entity != null) mileStoneDate = entity.getCreateDate();

        Set<UUID> userIds = new HashSet<>();
        List<Relationship> acceptedRelationships = relationshipRepository.findAllAcceptedRelationship(currentUser.getId());
        for (Relationship relationship : acceptedRelationships) {
            userIds.add(relationship.getReceiver().getId());
            userIds.add(relationship.getRequestSender().getId());
        }

        List<PostDto> newsFeed = postRepository.findNext5PostFromMileStone(new ArrayList<>(userIds), mileStoneDate, PageRequest.of(0, 5));

        return new HashSet<>(newsFeed);
    }

    @Override
    public boolean hasAuthorityToChange(UUID postId) {
        Post entity = postRepository.findById(postId).orElse(null);
        if (entity == null) return false;

        User currentUser = userService.getCurrentLoginUserEntity();
        if (entity.getOwner().getId() != currentUser.getId()) return false;

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

        //alert all friends that this user has created new post


        return new PostDto(savedEntity);
    }

    @Override
    public PostDto updatePost(PostDto dto) {
        if (dto == null) return null;

        Post entity = postRepository.findById(dto.getId()).orElse(null);
        if (entity == null) return null;

        entity.setContent(dto.getContent());

        Post savedEntity = postRepository.save(entity);

        return new PostDto(savedEntity);
    }

    @Override
    @Transactional
    public void deletePost(UUID postId) {
        Post entity = postRepository.findById(postId).orElse(null);
        if (entity == null) return;

        postRepository.delete(entity);
    }

    @Override
    public Set<PostDto> getPostsOfUser(UUID userId, SearchObject searchObject) {
        User currentUser = userService.getCurrentLoginUserEntity();

        if (currentUser == null || searchObject == null) return null;

        Post entity = postRepository.findById(searchObject.getMileStoneId()).orElse(null);
        Date mileStoneDate = new Date();
        if (entity != null) mileStoneDate = entity.getCreateDate();

        Set<UUID> userIds = new HashSet<>();
        userIds.add(userId);

        List<PostDto> newsFeed = postRepository.findNext5PostFromMileStone(new ArrayList<>(userIds), mileStoneDate, PageRequest.of(0, 5));

        return new HashSet<>(newsFeed);
    }

    @Override
    public PostDto getById(UUID postId) {
        Post entity = postRepository.findById(postId).orElse(null);
        if (entity == null) return null;
        return new PostDto(entity);
    }
}
