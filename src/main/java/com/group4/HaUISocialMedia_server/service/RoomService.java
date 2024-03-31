package com.group4.HaUISocialMedia_server.service;

import com.group4.HaUISocialMedia_server.dto.*;
import com.group4.HaUISocialMedia_server.entity.Room;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface RoomService {
    public Set<UserDto> getAllJoinedUsersByRoomId(UUID roomId);

    public RoomDto createRoom(RoomDto dto);

    public RoomDto updateRoom(RoomDto dto);

    public boolean deleteRoom(UUID roomId);

    public RoomDto getRoomById(UUID roomId);

    public List<RoomDto> searchRoom(SearchObject seachObject);

    public RoomDto createGroupChat(NewGroupChat newGroupChat);

    public RoomDto unjoinGroupChat(UUID groupChatId);

    public RoomDto addUserIntoGroupChat(UUID userId, UUID roomId);

    public boolean isInRoomChat(UUID roomId);

    public Set<UserDto> getListFriendNotInRoom(UUID roomId);

    public RoomDto addMultipleUsersIntoGroupChat(UUID[] userIds, UUID roomId);

    public Set<RoomDto> getAllJoinedRooms();

    public Set<RoomDto> getAllGroupRooms();

    public Set<RoomDto> getAllPrivateRooms();

}
