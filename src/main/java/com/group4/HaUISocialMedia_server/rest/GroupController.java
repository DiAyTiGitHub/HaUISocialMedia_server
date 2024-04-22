package com.group4.HaUISocialMedia_server.rest;

import com.group4.HaUISocialMedia_server.dto.GroupDto;
import com.group4.HaUISocialMedia_server.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping("")
    public ResponseEntity<GroupDto> createNewGroup(@RequestBody GroupDto newGroup){
        GroupDto groupDto = groupService.createGroup(newGroup);
        if(groupDto == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(groupDto, HttpStatus.OK);
    }


}
