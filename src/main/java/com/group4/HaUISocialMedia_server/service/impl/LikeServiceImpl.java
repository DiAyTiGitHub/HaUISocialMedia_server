package com.group4.HaUISocialMedia_server.service.impl;

import com.group4.HaUISocialMedia_server.dto.LikeDto;
import com.group4.HaUISocialMedia_server.entity.Like;
import com.group4.HaUISocialMedia_server.entity.Post;
import com.group4.HaUISocialMedia_server.entity.User;
import com.group4.HaUISocialMedia_server.repository.LikeRepository;
import com.group4.HaUISocialMedia_server.repository.PostRepository;
import com.group4.HaUISocialMedia_server.service.LikeService;
import com.group4.HaUISocialMedia_server.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.*;

@Service
public class LikeServiceImpl implements LikeService {
    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PostRepository postRepository;

    @Override
    @Transactional
    public LikeDto likeAPost(UUID postId) {

        User user = userService.getCurrentLoginUserEntity();
        Post post = postRepository.getById(postId);
        Like like = new Like();
        like.setCreateDate(new Date());
        like.setUserLike(user);
        like.setPost(post);

        return new LikeDto(likeRepository.save(like));
    }

    @Override
    public Set<LikeDto> getListLikesOfPost(UUID postId) {
        Set<LikeDto> res = new HashSet<>();
        List<Like> li = likeRepository.findByPost(postId);
        li.stream().map(LikeDto::new).forEach(res::add);
        return res;
    }

    @Override
    @Transactional
    public void dislikeAPost(UUID postId) {
        User user = userService.getCurrentLoginUserEntity();
        likeRepository.deleteByIdPost(postId, user.getId());
    }
}
