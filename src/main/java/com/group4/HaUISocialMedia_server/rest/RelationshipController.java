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

import java.util.List;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/relationship")
public class RelationshipController {
    @Autowired
    private RelationshipService relationshipService;

    @PostMapping("/friendRequest/{receiverId}")
    public ResponseEntity<RelationshipDto> sendAddFriendRequest(@PathVariable UUID receiverId) {
        RelationshipDto se = relationshipService.sendAddFriendRequest(receiverId);
        if (se == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(se, HttpStatus.OK);
    }

    @PostMapping("/acceptRequest/{relationshipId}")
    public ResponseEntity<RelationshipDto> acceptFriendRequest(@PathVariable UUID relationshipId) {
        RelationshipDto se = relationshipService.acceptFriendRequest(relationshipId);
        if (se == null)
            return new ResponseEntity<>(se, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(se, HttpStatus.OK);
    }

    @PostMapping("/friendRequest/pending")
    public ResponseEntity<Set<RelationshipDto>> pagingPendingFriendRequests(@RequestBody SearchObject searchObject) {
        Set<RelationshipDto> se = relationshipService.getPendingFriendRequests(searchObject);
        if (se == null)
            return new ResponseEntity<>(se, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(se, HttpStatus.OK);
    }

    @PostMapping("/friendRequest/sent")
    public ResponseEntity<Set<RelationshipDto>> pagingSentAddFriendRequests(@RequestBody SearchObject searchObject) {
        Set<RelationshipDto> res = relationshipService.getSentAddFriendRequests(searchObject);
        if (res == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/currentFriends")
    public ResponseEntity<List<UserDto>> pagingCurrentFriends(@RequestBody SearchObject searchObject) {
        List<UserDto> res = relationshipService.getCurrentFriends(searchObject);
        if (res == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/pagingNewUser")
    public ResponseEntity<List<UserDto>> pagingNewUser(@RequestBody SearchObject searchObject){
        List<UserDto> res = relationshipService.pagingNewUser(searchObject);
        if(res == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/friends/{userId}")
    public ResponseEntity<Set<UserDto>> pagingFriendsOfUser(@PathVariable("userId") UUID userId, @RequestBody SearchObject searchObject) {
            Set<UserDto> res = relationshipService.getFriendsOfUser(userId, searchObject);
        if (res == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @DeleteMapping("/unFriend/{relationshipId}")
    public ResponseEntity<Boolean> unFriend(@PathVariable("relationshipId") UUID relationshipId) {
        RelationshipDto res = relationshipService.unFriend(relationshipId);
        if (res == null)
            return new ResponseEntity<>(true, HttpStatus.OK);
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/unacceptFriend/{relationshipId}")
    public ResponseEntity<Boolean> unAcceptFriendRequest(@PathVariable("relationshipId") UUID relationshipId){
        RelationshipDto res = relationshipService.unAcceptFriendRequest(relationshipId);
        if(res == null)
            return new ResponseEntity<>(true, HttpStatus.OK);
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
