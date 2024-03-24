package com.group4.HaUISocialMedia_server.service.impl;

import com.group4.HaUISocialMedia_server.dto.CommentDto;
import com.group4.HaUISocialMedia_server.entity.Comment;
import com.group4.HaUISocialMedia_server.entity.User;
import com.group4.HaUISocialMedia_server.repository.CommentRepository;
import com.group4.HaUISocialMedia_server.repository.PostRepository;
import com.group4.HaUISocialMedia_server.service.CommentService;
import com.group4.HaUISocialMedia_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserService userService;

    @Override
    public Set<CommentDto> getParentCommentsOfPost(UUID postId) {
        return null;
    }

    @Override
    public Set<CommentDto> getSubCommentOfComment(UUID commentId) {
        return null;
    }

    @Override
    public CommentDto getById(UUID commentId) {
        return null;
    }

    @Override
    public CommentDto createComment(CommentDto dto) {
        return null;
    }

    @Override
    public CommentDto updateComment(CommentDto dto) {
        return null;
    }

    @Override
    public CommentDto deleteComment(UUID commentId) {
        return null;
    }

    @Override
    public boolean hasAuthorityToChange(UUID commentId) {
        Comment entity = commentRepository.findById(commentId).orElse(null);
        if (entity == null) return false;

        User currentUser = userService.getCurrentLoginUserEntity();
        if (currentUser.getId() != entity.getOwner().getId()) return false;
        return true;
    }
}
