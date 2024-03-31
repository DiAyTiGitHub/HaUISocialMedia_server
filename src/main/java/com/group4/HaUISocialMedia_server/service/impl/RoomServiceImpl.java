package com.group4.HaUISocialMedia_server.service.impl;


import com.group4.HaUISocialMedia_server.dto.*;
import com.group4.HaUISocialMedia_server.entity.Room;
import com.group4.HaUISocialMedia_server.entity.User;
import com.group4.HaUISocialMedia_server.entity.UserRoom;
import com.group4.HaUISocialMedia_server.repository.RoomRepository;
import com.group4.HaUISocialMedia_server.service.RoomService;
import com.group4.HaUISocialMedia_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private UserService userService;

    @Override
    public Set<UserDto> getAllJoinedUsersByRoomId(UUID roomId) {
        if (!isInRoomChat(roomId)) return null;

        Room room = roomRepository.findById(roomId).orElse(null);

        Set<UserDto> res = new HashSet<>();
        for (UserRoom ur : room.getUserRooms()) {
            res.add(new UserDto(ur.getUser()));
        }

        return res;
    }

    @Override
    public RoomDto createRoom(RoomDto dto) {
        return null;
    }

    @Override
    public RoomDto updateRoom(RoomDto dto) {
        return null;
    }

    @Override
    public boolean deleteRoom(UUID roomId) {
        return false;
    }

    @Override
    public RoomDto getRoomById(UUID roomId) {
        return null;
    }

    @Override
    public List<RoomDto> searchRoom(SearchObject seachObject) {
        return null;
    }

    @Override
    public RoomDto createGroupChat(NewGroupChat newGroupChat) {
        return null;
    }

    @Override
    public RoomDto unjoinGroupChat(UUID groupChatId) {
        return null;
    }

    @Override
    public RoomDto addUserIntoGroupChat(UUID userId, UUID roomId) {
        return null;
    }

    @Override
    public boolean isInRoomChat(UUID roomId) {
        User currentUser = userService.getCurrentLoginUserEntity();
        if (currentUser == null) return false;

        Room room = roomRepository.findById(roomId).orElse(null);
        if (room == null) return false;

        for (UserRoom ur : room.getUserRooms()) {
            if (ur.getUser().getId().equals(currentUser.getId())) return true;
        }

        return false;
    }

    @Override
    public Set<UserDto> getListFriendNotInRoom(UUID roomId) {
        return null;
    }

    @Override
    public RoomDto addMultipleUsersIntoGroupChat(UUID[] userIds, UUID roomId) {
        return null;
    }

    @Override
    public Set<RoomDto> getAllJoinedRooms() {
        return null;
    }

    @Override
    public Set<RoomDto> getAllGroupRooms() {
        return null;
    }

    @Override
    public Set<RoomDto> getAllPrivateRooms() {
        return null;
    }
}
