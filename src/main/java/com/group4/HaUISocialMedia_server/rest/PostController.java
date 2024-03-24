package com.group4.HaUISocialMedia_server.rest;

import com.group4.HaUISocialMedia_server.dto.MessageTypeDto;
import com.group4.HaUISocialMedia_server.dto.PostDto;
import com.group4.HaUISocialMedia_server.dto.SearchObject;
import com.group4.HaUISocialMedia_server.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/newsfeed")
    public ResponseEntity<Set<PostDto>> getNewsFeed(@RequestBody SearchObject searchObject) {
        Set<PostDto> res = postService.getNewsFeed(searchObject);
        if (res == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/newsfeed/{userId}")
    public ResponseEntity<Set<PostDto>> getPostsOfUser(@PathVariable UUID userId, @RequestBody SearchObject searchObject) {
        Set<PostDto> res = postService.getPostsOfUser(userId, searchObject);
        if (res == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getById(@PathVariable UUID postId) {
        PostDto res = postService.getById(postId);
        if (res == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto dto) {
        PostDto res = postService.createPost(dto);
        if (res == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<PostDto>(res, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto dto) {
        if (!postService.hasAuthorityToChange(dto.getId())) return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);

        PostDto res = postService.updatePost(dto);

        if (res == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<PostDto>(res, HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable UUID postId) {
        if (!postService.hasAuthorityToChange(postId)) return;

        postService.deletePost(postId);
    }
}
