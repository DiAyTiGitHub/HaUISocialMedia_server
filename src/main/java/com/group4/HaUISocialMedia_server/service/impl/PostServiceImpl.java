package com.group4.HaUISocialMedia_server.service.impl;

import com.group4.HaUISocialMedia_server.dto.PostDto;
import com.group4.HaUISocialMedia_server.dto.SearchObject;
import com.group4.HaUISocialMedia_server.service.PostService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {
    @Override
    public Set<PostDto> getNewsFeed(SearchObject searchObject) {
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
