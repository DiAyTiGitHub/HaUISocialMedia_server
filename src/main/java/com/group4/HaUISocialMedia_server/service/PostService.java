package com.group4.HaUISocialMedia_server.service;

import com.group4.HaUISocialMedia_server.dto.PostDto;
import com.group4.HaUISocialMedia_server.dto.SearchObject;
import com.group4.HaUISocialMedia_server.entity.Post;

import java.util.Set;
import java.util.UUID;

public interface PostService {
    public Set<PostDto> getNewsFeed(SearchObject searchObject);

    public PostDto getById(UUID postId);

    public PostDto createPost(PostDto dto);

    //public PostDto createPostInGroup(PostDto dto, UUID groupId);

    public PostDto updatePost(PostDto dto);

    public boolean deletePost(UUID postId);

    public Set<PostDto> getPostsOfUser(UUID userId, SearchObject searchObject);

    public boolean hasAuthorityToChange(UUID postId);

    public PostDto updateBackgroundImage(String image);

    public PostDto updateProfileImage(String image);
}
