package com.group4.HaUISocialMedia_server.rest;

import com.group4.HaUISocialMedia_server.dto.CommentDto;
import com.group4.HaUISocialMedia_server.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/children/{commentId}")
    public ResponseEntity<Set<CommentDto>> getSubComments(@PathVariable UUID commentId) {
        Set<CommentDto> res = commentService.getSubCommentOfComment(commentId);
        if (res == null) return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/forPost/{postId}")
    public ResponseEntity<Set<CommentDto>> getParentCommentOfPost(@PathVariable UUID postId) {
        Set<CommentDto> res = commentService.getParentCommentsOfPost(postId);
        if (res == null) return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<CommentDto> getById(@RequestBody CommentDto dto) {
        return null;
    }

    @PostMapping()
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto dto) {
        return null;
    }

    @PutMapping()
    public ResponseEntity<CommentDto> updateComment(@RequestBody CommentDto dto) {
        return null;
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable UUID commentId) {

    }
}
