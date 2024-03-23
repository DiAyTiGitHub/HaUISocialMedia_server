package com.group4.HaUISocialMedia_server.service.impl;

import com.group4.HaUISocialMedia_server.dto.PostDto;
import com.group4.HaUISocialMedia_server.dto.SearchObject;
import com.group4.HaUISocialMedia_server.entity.Post;
import com.group4.HaUISocialMedia_server.repository.PostRepository;
import com.group4.HaUISocialMedia_server.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public Set<PostDto> getNewsFeed(SearchObject searchObject) {
        Post entity = postRepository.findById(searchObject.getMileStoneId()).orElse(null);
        Date mileStoneDate = new Date();
        if (entity != null) mileStoneDate = entity.getCreateDate();
//        User
        return null;
    }

    @Override
    public PostDto createPost(PostDto dto) {
        return null;
    }

    @Override
    public PostDto updatePost(PostDto dto) {
        return null;
    }

    @Override
    public void deletePost(UUID postId) {

    }

    @Override
    public Set<PostDto> getPostsOfUser(UUID userId, SearchObject searchObject) {
        return null;
    }
}
