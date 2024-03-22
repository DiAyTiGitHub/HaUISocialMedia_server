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

    public void deleteRoom(UUID roomId);

    public Set<MessageDto> pagingLatestMessage(UUID earliestMessageId);

    public RoomDto getRoomById(UUID roomId);

    public Room createRoomEntity(RoomDto dto);

    public RoomDto handleAddJoinedUserIntoRoomDTO(Room room);

    public List<RoomDto> searchRoom(SearchObject seachObject);

    public String uploadRoomAvatar(MultipartFile fileUpload, UUID roomId);

    public RoomDto createGroupChat(NewGroupChat newGroupChat);

    public RoomDto unjoinGroupChat(UUID groupChatId);

    public RoomDto addUserIntoGroupChat(UUID userId, UUID roomId);

    public boolean isInRoomChat(UUID roomId);

    public Set<UserDto> getListFriendNotInRoom(UUID roomId);

    public RoomDto addMultipleUsersIntoGroupChat(UUID[] userIds, UUID roomId);
}
