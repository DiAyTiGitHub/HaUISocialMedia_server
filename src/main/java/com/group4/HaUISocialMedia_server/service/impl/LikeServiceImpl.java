package com.group4.HaUISocialMedia_server.service.impl;

import com.group4.HaUISocialMedia_server.dto.LikeDto;
import com.group4.HaUISocialMedia_server.repository.LikeRepository;
import com.group4.HaUISocialMedia_server.service.LikeService;
import com.group4.HaUISocialMedia_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class LikeServiceImpl implements LikeService {
    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private UserService userService;

    @Override
    public LikeDto likeAPost(UUID postId) {
        return null;
    }

    @Override
    public Set<LikeDto> getListLikesOfPost(UUID postId) {
        return null;
    }

    @Override
    public void dislikeAPost(UUID postId) {

    }
}
