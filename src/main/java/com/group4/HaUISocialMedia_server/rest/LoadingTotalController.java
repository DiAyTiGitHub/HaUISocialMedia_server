package com.group4.HaUISocialMedia_server.rest;

import com.group4.HaUISocialMedia_server.dto.PostDto;
import com.group4.HaUISocialMedia_server.dto.SearchObject;
import com.group4.HaUISocialMedia_server.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/loadingTotal")
public class LoadingTotalController {
    @Autowired
    private PostService postService;

    //search post of current login user
    @PostMapping("/search-post")
    public ResponseEntity<List<PostDto>> pagingPostByKeyword(@RequestBody SearchObject searchObject){
        List<PostDto> res = postService.pagingByKeyword(searchObject);
        if (res == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
