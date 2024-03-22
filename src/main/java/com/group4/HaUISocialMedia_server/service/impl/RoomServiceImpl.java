package com.group4.HaUISocialMedia_server.service.impl;


import com.group4.HaUISocialMedia_server.dto.*;
import com.group4.HaUISocialMedia_server.entity.Room;
import com.group4.HaUISocialMedia_server.service.RoomService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class RoomServiceImpl implements RoomService {
    @Override
    public Set<UserDto> getAllJoinedUsersByRoomId(UUID roomId) {
        return null;
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
    public void deleteRoom(UUID roomId) {

    }

    @Override
    public Set<MessageDto> pagingLatestMessage(UUID earliestMessageId) {
        return null;
    }

    @Override
    public RoomDto getRoomById(UUID roomId) {
        return null;
    }

    @Override
    public Room createRoomEntity(RoomDto dto) {
        return null;
    }

    @Override
    public RoomDto handleAddJoinedUserIntoRoomDTO(Room room) {
        return null;
    }

    @Override
    public List<RoomDto> searchRoom(SearchObject seachObject) {
        return null;
    }

    @Override
    public String uploadRoomAvatar(MultipartFile fileUpload, UUID roomId) {
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
}
