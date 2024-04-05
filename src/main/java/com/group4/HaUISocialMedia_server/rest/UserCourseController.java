package com.group4.HaUISocialMedia_server.rest;

import com.group4.HaUISocialMedia_server.dto.ClassroomDto;
import com.group4.HaUISocialMedia_server.dto.SearchObject;
import com.group4.HaUISocialMedia_server.dto.UserCourseDto;
import com.group4.HaUISocialMedia_server.service.ClassroomService;
import com.group4.HaUISocialMedia_server.service.UserCourseService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/userCourse")
public class UserCourseController {

    @Autowired
    private UserCourseService userCourseService;

    @GetMapping("/{userCourseId}")
    private ResponseEntity<UserCourseDto> getUserCourseById(@PathVariable UUID userCourseId) {
        UserCourseDto res = userCourseService.getUserCourseById(userCourseId);
        if (res == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("")
    private ResponseEntity<UserCourseDto> createUserCourse(@RequestBody UserCourseDto dto) {
        UserCourseDto res = userCourseService.createUserCourse(dto);
        if (res == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping("")
    private ResponseEntity<UserCourseDto> updateUserCourse(@RequestBody UserCourseDto dto) {
        UserCourseDto res = userCourseService.updateUserCourse(dto);
        if (res == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @DeleteMapping("/{userCourseId}")
    private ResponseEntity<Boolean> deleteUserCourseById(@PathVariable UUID userCourseId) {
        Boolean res = userCourseService.deleteUserCourseById(userCourseId);
        if (res == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/total/{userId}")
    private ResponseEntity<List<UserCourseDto>> getUserCourseOfUser(@PathVariable UUID userId) {
        List<UserCourseDto> res = userCourseService.getUserCourseOfUser(userId);
        if (res == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/coursesByResult/{userId}/{courseId}")
    private ResponseEntity<List<UserCourseDto>> getUserCourseOfUser(@PathVariable UUID userId, @PathVariable UUID courseId) {
        List<UserCourseDto> res = userCourseService.getUserCourseByResult(userId, courseId);
        if (res == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
