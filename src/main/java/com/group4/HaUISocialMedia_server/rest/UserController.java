package com.group4.HaUISocialMedia_server.rest;

import com.group4.HaUISocialMedia_server.dto.SearchObject;
import com.group4.HaUISocialMedia_server.dto.UserDto;
import com.group4.HaUISocialMedia_server.entity.User;
import com.group4.HaUISocialMedia_server.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;
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
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<Set<UserDto>> getAll() {
        Set<UserDto> students = userService.getAllUsers();
        if (students == null) return new ResponseEntity<>(students, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable("id")UUID id){
        if(userService.getById(id) == null) new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/username/{name}")
    public ResponseEntity<UserDto> getByName(@PathVariable("name")String name){
        if(userService.getByUserName(name) == null) new ResponseEntity<>(null, HttpStatus.NOT_FOUND );
        return new ResponseEntity<>(userService.getByUserName(name), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id")UUID id){
        UserDto userDto = userService.getById(id);
        if(userDto == null) return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        userService.deleteById(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto){
        UserDto userDto1 = userService.getById(userDto.getId());
        if(userDto1 == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        userService.updateUser(userDto);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Set<UserDto>> getByUsername(@RequestBody SearchObject searchObject){
        Set<UserDto> li = userService.searchByUsername(searchObject);
        if(li == null) return new ResponseEntity<>(li, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(li, HttpStatus.OK);
    }
}
