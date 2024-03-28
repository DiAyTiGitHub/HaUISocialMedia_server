package com.group4.HaUISocialMedia_server.service.impl;

import com.group4.HaUISocialMedia_server.dto.CommentDto;
import com.group4.HaUISocialMedia_server.entity.Comment;
import com.group4.HaUISocialMedia_server.entity.Post;
import com.group4.HaUISocialMedia_server.entity.User;
import com.group4.HaUISocialMedia_server.repository.CommentRepository;
import com.group4.HaUISocialMedia_server.repository.PostRepository;
import com.group4.HaUISocialMedia_server.repository.UserRepository;
import com.group4.HaUISocialMedia_server.service.CommentService;
import com.group4.HaUISocialMedia_server.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
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

    @Autowired
    private UserRepository userRepository;

    @Override
    public Set<CommentDto> getParentCommentsOfPost(UUID postId) {
        Post post = postRepository.findById(postId).orElse(null);
        if(post == null)
            return null;
        Set<CommentDto> res = new HashSet<>();
        List<Comment> li = commentRepository.findAllByPost(post);
        li.stream().map(CommentDto::new).forEach(res::add);
        return res;
    }

    @Override
    public Set<CommentDto> getSubCommentOfComment(UUID commentId) {
        Comment comment = commentRepository.findById(commentId).orElse(null);
        if(comment == null)
            return null;
        Set<CommentDto> res = new HashSet<>();
        Set<Comment> re =  comment.getSubComments();
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
        if(dto == null)
            return null;
        Comment comment = new Comment();
        comment.setContent(dto.getContent());
        comment.setCreateDate(dto.getCreateDate());

        User user = userRepository.findById(dto.getCommenter().getId()).orElse(null);
        if(user == null){
            return null;
        }
        comment.setOwner(user);


        Post post = postRepository.findById(dto.getPost().getId()).orElse(null);
        if(post == null)
            return null;
        comment.setPost(post);

        Comment commentParent = commentRepository.findById(dto.getRepliedComment().getId()).orElse(null);
        if(commentParent != null)
        comment.setRepliedComment(commentParent);
        Comment comment1 = commentRepository.save(comment);
        return new CommentDto(comment1);
    }

    @Override
    @Transactional
    public CommentDto updateComment(CommentDto dto) {
        Comment comment = commentRepository.findById(dto.getId()).orElse(null);

        if(comment == null)
            return null;
        comment.setContent(dto.getContent());
        comment.setCreateDate(dto.getCreateDate());

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
        if(comment == null)
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
}
