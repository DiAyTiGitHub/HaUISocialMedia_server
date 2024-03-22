package com.group4.HaUISocialMedia_server.controller;

import com.group4.HaUISocialMedia_server.dto.UserDto;
import com.group4.HaUISocialMedia_server.service.UserService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<Set<UserDto>> getAll() {
        Set<UserDto> rooms = userService.getAllUsers();
        if (rooms == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable("id") UUID id) {
        if (userService.getById(id) == null) new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/username/{name}")
    public ResponseEntity<UserDto> getByName(@PathVariable("name") String name) {
        if (userService.getByUserName(name) == null) new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(userService.getByUserName(name), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") UUID id) {
        UserDto userDto = userService.getById(id);
        if (userDto == null) return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        userService.deleteById(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<UserDto> updateUserProfile(@RequestBody UserDto dto) {
        UserDto responseDto = userService.updateUser(dto);
        if (responseDto == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
