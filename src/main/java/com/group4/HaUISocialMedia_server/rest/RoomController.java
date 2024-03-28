package com.group4.HaUISocialMedia_server.rest;

import com.group4.HaUISocialMedia_server.dto.NewGroupChat;
import com.group4.HaUISocialMedia_server.dto.RoomDto;
import com.group4.HaUISocialMedia_server.dto.SearchObject;
import com.group4.HaUISocialMedia_server.dto.UserDto;
import com.group4.HaUISocialMedia_server.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/api/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/{roomId}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<RoomDto> getRoomById(@PathVariable UUID roomId) {
        RoomDto res = roomService.getRoomById(roomId);
        if (res == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<RoomDto>(res, HttpStatus.OK);
    }

    @PutMapping
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<RoomDto> updateRoom(@RequestBody RoomDto dto) {
        RoomDto res = roomService.updateRoom(dto);
        if (res == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<RoomDto>(res, HttpStatus.OK);
    }

    @DeleteMapping("/{roomId}")
    @CrossOrigin(origins = "http://localhost:5173")
    public void deleteRoom(@PathVariable UUID roomId) {
        roomService.deleteRoom(roomId);
    }

    @PostMapping("/search")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<List<RoomDto>> searchJoinedRooms(@RequestBody SearchObject seachObject) {
        if (seachObject == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        List<RoomDto> res = roomService.searchRoom(seachObject);
        if (res == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<List<RoomDto>>(res, HttpStatus.OK);
    }

    @PostMapping("/avatar/{roomId}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<String> updloadRoomAvatar(@RequestParam("fileUpload") MultipartFile fileUpload,
                                                    @PathVariable UUID roomId) {
        String res = roomService.uploadRoomAvatar(fileUpload, roomId);
        if (res != null)
            return new ResponseEntity<String>(res, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/group")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<RoomDto> createGroupChat(@RequestBody NewGroupChat newGroupChat) {
        if (newGroupChat == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        if (newGroupChat.getJoinUserIds().length < 2)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        RoomDto createdRoom = roomService.createGroupChat(newGroupChat);
        if (createdRoom != null)
            return new ResponseEntity<RoomDto>(createdRoom, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/group/{roomId}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<RoomDto> unjoinAnGroupChat(@PathVariable UUID roomId) {
        RoomDto res = roomService.unjoinGroupChat(roomId);
        if (res != null)
            return new ResponseEntity<RoomDto>(res, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/group/{userId}/{roomId}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<RoomDto> addSingleUserIntoGroupChat(@PathVariable UUID userId, @PathVariable UUID roomId) {
        RoomDto res = roomService.addUserIntoGroupChat(userId, roomId);
        if (res != null)
            return new ResponseEntity<RoomDto>(res, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/group/{roomId}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<RoomDto> addUsersIntoGroupChat(@PathVariable UUID roomId, @RequestBody UUID[] userIds) {
        RoomDto res = roomService.addMultipleUsersIntoGroupChat(userIds, roomId);
        if (res != null)
            return new ResponseEntity<RoomDto>(res, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/group/not-in/{roomId}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<Set<UserDto>> getListFriendNotInRoom(@PathVariable UUID roomId) {
        Set<UserDto> res = roomService.getListFriendNotInRoom(roomId);
        if (res != null)
            return new ResponseEntity<>(res, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}
