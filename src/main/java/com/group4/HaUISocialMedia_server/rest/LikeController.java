package com.group4.HaUISocialMedia_server.rest;

import com.group4.HaUISocialMedia_server.dto.CommentDto;
import com.group4.HaUISocialMedia_server.dto.LikeDto;
import com.group4.HaUISocialMedia_server.repository.LikeRepository;
import com.group4.HaUISocialMedia_server.service.LikeService;
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
public class LikeController {
    @Autowired
    private LikeService likeService;

    @PostMapping("/{postId}")
    public ResponseEntity<LikeDto> likeAPost(@PathVariable UUID postId) {
        LikeDto res = likeService.likeAPost(postId);
        if (res == null) return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Set<LikeDto>> getListLikesOfPost(@PathVariable UUID postId) {
        Set<LikeDto> res = likeService.getListLikesOfPost(postId);
        if (res == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public void dislikeAPost(@PathVariable UUID postId) {
        likeService.dislikeAPost(postId);
    }

}
