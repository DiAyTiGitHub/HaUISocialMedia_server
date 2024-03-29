package com.group4.HaUISocialMedia_server.rest;

import com.group4.HaUISocialMedia_server.dto.CourseDto;
import com.group4.HaUISocialMedia_server.dto.RelationshipDto;
import com.group4.HaUISocialMedia_server.dto.SearchObject;
import com.group4.HaUISocialMedia_server.dto.UserDto;
import com.group4.HaUISocialMedia_server.service.RelationshipService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/relationship")
public class RelationshipController {
    @Autowired
    private RelationshipService relationshipService;

    @PostMapping("/friendRequest/{receiverId}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<RelationshipDto> sendAddFriendRequest(@PathVariable UUID receiverId) {
        RelationshipDto se = relationshipService.sendAddFriendRequest(receiverId);
        if (se == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(se, HttpStatus.OK);
    }

    @PostMapping("/acceptRequest/{relationshipId}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<RelationshipDto> acceptFriendRequest(@PathVariable UUID relationshipId) {
        RelationshipDto se = relationshipService.acceptFriendRequest(relationshipId);
        if (se == null)
            return new ResponseEntity<>(se, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(se, HttpStatus.OK);
    }

    @GetMapping("/friendRequest/pending")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<Set<RelationshipDto>> getPendingFriendRequests(@RequestBody SearchObject searchObject) {
        Set<RelationshipDto> se = relationshipService.getPendingFriendRequests(searchObject);
        if (se == null)
            return new ResponseEntity<>(se, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(se, HttpStatus.OK);
    }

    @GetMapping("/friendRequest/sent")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<Set<RelationshipDto>> getSentAddFriendRequests(@RequestBody SearchObject searchObject) {
        Set<RelationshipDto> res = relationshipService.getSentAddFriendRequests(searchObject);
        if (res == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/currentFriends")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<Set<UserDto>> getCurrentFriends(@RequestBody SearchObject searchObject) {
        Set<UserDto> res = relationshipService.getCurrentFriends(searchObject);
        if (res == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/friends/{userId}")
    public ResponseEntity<Set<UserDto>> pagingFriendsOfUser(@PathVariable UUID userId, @RequestBody SearchObject searchObject) {
        Set<UserDto> res = relationshipService.getFriendsOfUser(userId, searchObject);
        if (res == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
