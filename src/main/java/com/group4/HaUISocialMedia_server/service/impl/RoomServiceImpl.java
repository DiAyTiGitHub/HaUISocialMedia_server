package com.group4.HaUISocialMedia_server.service.impl;


import com.group4.HaUISocialMedia_server.dto.*;
import com.group4.HaUISocialMedia_server.entity.Room;
import com.group4.HaUISocialMedia_server.entity.RoomType;
import com.group4.HaUISocialMedia_server.entity.User;
import com.group4.HaUISocialMedia_server.entity.UserRoom;
import com.group4.HaUISocialMedia_server.repository.RoomRepository;
import com.group4.HaUISocialMedia_server.repository.RoomTypeRepository;
import com.group4.HaUISocialMedia_server.repository.UserRoomRepository;
import com.group4.HaUISocialMedia_server.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.*;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserRoomRepository userRoomRepository;

    @Autowired
    private MessageTypeService messageTypeService;

    @Autowired
    private RoomTypeService roomTypeService;

    @Autowired
    private RoomTypeRepository roomTypeRepository;

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
        if(roomRepository.findById(dto.getId()).orElse(null) != null)
            return null;

        Room room = new Room();
        room.setName(dto.getName());
        room.setAvatar(dto.getAvatar());
        room.setCode(dto.getCode());
        room.setCreateDate(new Date());
        room.setDescription(dto.getDescription());
        room.setColor(dto.getColor());
        RoomType roomType = roomTypeRepository.findByName("public");
        room.setRoomType(roomType);
       // room.setRelationship(dt);
        //room.setRoomType();
        return new RoomDto(roomRepository.save(room));
    }

    @Override
    public RoomDto updateRoom(RoomDto dto) {
        Room room = roomRepository.findById(dto.getId()).orElse(null);
        if(room == null)
            return null;

        room.setName(dto.getName());
        room.setAvatar(dto.getAvatar());
        room.setCode(dto.getCode());
        room.setCreateDate(new Date());
        room.setDescription(dto.getDescription());
        room.setColor(dto.getColor());
        if(room.getUserRooms().size() >= 3){
            RoomType roomType = roomTypeRepository.findByName("group");
            room.setRoomType(roomType);
        }else{
            RoomType roomType = roomTypeRepository.findByName("private");
            room.setRoomType(roomType);
        }
        return new RoomDto(roomRepository.saveAndFlush(room));
    }

    @Override
    public boolean deleteRoom(UUID roomId) {
        if(roomRepository.findById(roomId).orElse(null) == null)
            return false;
        roomRepository.deleteById(roomId);
        return true;
    }

    @Override
    public RoomDto getRoomById(UUID roomId) {
        Room room = roomRepository.findById(roomId).orElse(null);
        if(room == null)
            return null;
        return new RoomDto(room);
    }

    @Override
    public List<RoomDto> searchRoom(SearchObject seachObject) {
        User user = userService.getCurrentLoginUserEntity();
        List<UserRoom> userRooms = userRoomRepository.findAllRoomByUser(user.getId(), (Pageable) PageRequest.of(seachObject.getPageIndex(), seachObject.getPageSize()), seachObject.getKeyWord());
        List<RoomDto> res = new ArrayList<>();
        userRooms.forEach(x -> res.add(new RoomDto(x.getRoom())));
        return res;
    }

    @Override
    public RoomDto createGroupChat(NewGroupChat newGroupChat) {
        if (newGroupChat == null) return null;
        UUID joinUserIds[] = newGroupChat.getJoinUserIds();
        if (joinUserIds == null) return null;
        User currentUser = userService.getCurrentLoginUserEntity();
        if (currentUser == null) return null;

        List<User> joiningUsers = new ArrayList<>();
        joiningUsers.add(currentUser);
        for (UUID joinUserId : joinUserIds) {
            User joinUser = userService.getUserEntityById(joinUserId);
            if (joinUser == null) return null;
            joiningUsers.add(joinUser);
        }

        Room roomChat = new Room();
        Set<UserRoom> userRooms = new HashSet<>();

        UserRoom creator = new UserRoom();
        creator.setRoom(roomChat);
        creator.setUser(currentUser);
        creator.setRole("Admin");
        creator.setJoinDate(new Date());
        UserRoom creatorUserRoom = userRoomRepository.save(creator);
        userRooms.add(creatorUserRoom);

        for (User user : joiningUsers) {
            if (user.getId().equals(currentUser.getId())) continue;
            UserRoom ur = new UserRoom();
            ur.setRoom(roomChat);
            ur.setUser(user);
            ur.setRole("Participant");
            ur.setJoinDate(new Date());
            UserRoom userRoom = userRoomRepository.save(ur);
            userRooms.add(userRoom);
        }

        roomChat.setName("Bạn và  " + joinUserIds.length + " người khác");
        if (newGroupChat.getName() != null && newGroupChat.getName().length() > 0)
            roomChat.setName(newGroupChat.getName());

        roomChat.setUserRooms(userRooms);
        RoomType roomType = roomTypeService.getRoomTypeEntityByName("group");
        roomChat.setRoomType(roomType);

        //chatRoom is finally created done in database
        Room response = roomRepository.save(roomChat);
        if (response == null)
            return null;

        MessageTypeDto messageTypeDTO = messageTypeService.getMessageTypeByName("join");

        RoomDto responseDto = new RoomDto(response);
        responseDto.setParticipants(getAllJoinedUsersByRoomId(responseDto.getId()));

        List<MessageDto> spreadMessages = new ArrayList<>();

        //send message that creator had created this conversation
        MessageDto creatorMessageDto = new MessageDto();
        creatorMessageDto.setMessageType(messageTypeDTO);
        creatorMessageDto.setRoom(responseDto);
        creatorMessageDto.setUser(new UserDto(currentUser));
        creatorMessageDto.setContent(currentUser.getUsername() + " đã tạo cuộc trò chuyện");
//        MessageDto creatorMessageRes = messageService.createMessageAttachedUser(creatorMessageDto);
////        simpMessagingTemplate.convertAndSendToUser(currentUser.getId().toString(), "/privateMessage", creatorMessageRes);
//        spreadMessages.add(creatorMessageRes);
//
//        for (User user : joiningUsers) {
//            if (currentUser.getId().equals(user.getId())) continue;
//            //send message each user had joined this conversation
//            MessageDTO messageDto = new MessageDTO();
//            messageDto.setMessageType(messageTypeDTO);
//            messageDto.setRoom(responseDto);
//            messageDto.setUser(new UserDTO(user));
//            messageDto.setContent(user.getUsername() + " joined");
//            MessageDTO messageRes = messageService.createMessageAttachedUser(messageDto);
////            simpMessagingTemplate.convertAndSendToUser(user.getId().toString(), "/privateMessage", messageRes);
//            spreadMessages.add(messageRes);
//        }
//
//        responseDto.setMessages(spreadMessages);
//        for (MessageDTO messageDTO : spreadMessages) {
//            messageDTO.getRoom().setParticipants(roomService.getAllJoinedUsersByRoomId(messageDTO.getRoom().getId()));
//            for (User userIn : joiningUsers) {
//                simpMessagingTemplate.convertAndSendToUser(userIn.getId().toString(), "/privateMessage", messageDTO);
//            }
//        }

        return responseDto;
    }

    @Override
    public RoomDto unjoinGroupChat(UUID groupChatId) {
//        if (!isInRoomChat(groupChatId)) return null;
//
//        User currentUser = userService.getCurrentLoginUserEntity();
//        if (currentUser == null) return null;
//        Room unjoinRoom = roomRepository.findById(groupChatId).orElse(null);
//        if (unjoinRoom == null) return null;
//        UserRoom userRoom = userRoomRepository.findByUserIdAndRoomId(currentUser.getId(), unjoinRoom.getId());
//        if (userRoom == null) return null;
//
//        unjoinRoom = roomRepository.findById(groupChatId).orElse(null);
//        RoomDto res = new RoomDto(unjoinRoom);
//        res.setParticipants(getAllJoinedUsersByRoomId(res.getId()));
//        //notify other users that an user had left this conversation
//        MessageDto leftMessageDto = new MessageDto();
//        leftMessageDto.setRoom(res);
//        leftMessageDto.setContent(currentUser.getUsername() + " left this conversation");
//        leftMessageDto.setUser(new UserDto(currentUser));
//        leftMessageDto.setMessageType(messageTypeService.getMessageTypeByName("left"));
//        messageService.sendMessage(leftMessageDto);
//
//        userRoomService.deleteUserRoom(userRoom.getId());
//
//        return res;
        return null;
    }

    public RoomDto addUserIntoGroupChat(UUID userId, UUID roomId) {
        if (!isInRoomChat(roomId)) return null;

        if (userId == null || roomId == null) return null;
        UserDto currentLoginUser = new UserDto(userService.getCurrentLoginUserEntity());
        if (currentLoginUser == null) return null;
        User newUser = userService.getUserEntityById(userId);
        if (newUser == null) return null;
        Room addedRoom = roomRepository.findById(roomId).orElse(null);
        if (addedRoom == null) return null;

        //handle add user into room by declare new userroom entity
        UserRoom newUserRoom = new UserRoom();
        newUserRoom.setRole("Member");
        newUserRoom.setNickName(newUser.getUsername());
        newUserRoom.setRoom(addedRoom);
        newUserRoom.setUser(newUser);
        newUserRoom.setJoinDate(new Date());
        UserRoom resEntity = userRoomRepository.save(newUserRoom);

        Room updatedRoom = roomRepository.findById(resEntity.getRoom().getId()).orElse(null);
        if (updatedRoom == null)
            return null;

        RoomDto response = new RoomDto(updatedRoom);

        //notify other users that an user had joined this conversation
        MessageDto joinMessageDto = new MessageDto();
        joinMessageDto.setRoom(response);
        joinMessageDto.setContent(currentLoginUser.getUsername() + " đã thêm " + newUser.getUsername() + " vào cuộc trò chuyện");
        joinMessageDto.setUser(new UserDto(newUser));
        joinMessageDto.setMessageType(messageTypeService.getMessageTypeByName("join"));
        messageService.sendMessage(joinMessageDto);

        response.setParticipants(getAllJoinedUsersByRoomId(updatedRoom.getId()));
        return response;
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
        if (userIds == null) return null;
        for (UUID userId : userIds) {
            addUserIntoGroupChat(userId, roomId);
        }

        Room updatedRoom = roomRepository.findById(roomId).orElse(null);
        if (updatedRoom == null)
            return null;

        RoomDto response = new RoomDto(updatedRoom);
        response.setParticipants(getAllJoinedUsersByRoomId(updatedRoom.getId()));
        return response;
    }

    @Override
    public List<RoomDto> getAllJoinedRooms() {
        User currentUser = userService.getCurrentLoginUserEntity();
        if (currentUser == null)
            return null;
        Set<UserRoom> userRooms = currentUser.getUserRooms();
        if (userRooms == null) return null;
        List<RoomDto> rooms = new ArrayList<>();
        Set<UUID> roomIdSet = new HashSet<>();

        for (UserRoom userRoom : userRooms) {
            Room room = userRoom.getRoom();

            if (roomIdSet.contains(room.getId())) continue;
            roomIdSet.add(room.getId());

            RoomDto roomDto = handleAddJoinedUserIntoRoomDTO(room);
            List<MessageDto> messages = messageService.get20LatestMessagesByRoomId(roomDto.getId());

            roomDto.setMessages(messages);
            rooms.add(roomDto);
        }

        sortRoomDTOInLastestMessagesOrder(rooms);

        return rooms;
    }

    @Override
    public List<RoomDto> getAllGroupRooms() {
        User currentUser = userService.getCurrentLoginUserEntity();
        if (currentUser == null)
            return null;

        Set<UserRoom> userRooms = currentUser.getUserRooms();
        if (userRooms == null) return null;
        List<RoomDto> rooms = new ArrayList<>();
        Set<UUID> roomIdSet = new HashSet<>();

        for (UserRoom userRoom : userRooms) {
            Room room = userRoom.getRoom();

            if (roomIdSet.contains(room.getId())) continue;
            roomIdSet.add(room.getId());

            if (room.getRoomType().getName().trim().toLowerCase().equals("public")) {
                RoomDto roomDto = handleAddJoinedUserIntoRoomDTO(room);
                List<MessageDto> messages = messageService.get20LatestMessagesByRoomId(roomDto.getId());

                roomDto.setMessages(messages);
                rooms.add(roomDto);
            }
        }

        sortRoomDTOInLastestMessagesOrder(rooms);


        return rooms;
    }

    @Override
    public List<RoomDto> getAllPrivateRooms() {
        User currentUser = userService.getCurrentLoginUserEntity();
        if (currentUser == null)
            return null;

        Set<UserRoom> userRooms = currentUser.getUserRooms();
        if (userRooms == null) return null;
        List<RoomDto> rooms = new ArrayList<>();
        Set<UUID> roomIdSet = new HashSet<>();

        for (UserRoom userRoom : userRooms) {
            Room room = userRoom.getRoom();

            if (roomIdSet.contains(room.getId())) continue;
            roomIdSet.add(room.getId());

            if (room.getRoomType().getName().trim().toLowerCase().equals("private")) {
                RoomDto roomDto = this.handleAddJoinedUserIntoRoomDTO(room);
                List<MessageDto> messages = messageService.get20LatestMessagesByRoomId(roomDto.getId());

                roomDto.setMessages(messages);
                rooms.add(roomDto);
            }
        }

        sortRoomDTOInLastestMessagesOrder(rooms);

        return rooms;
    }

    public static void sortRoomDTOInLastestMessagesOrder(List<RoomDto> rooms) {
        Collections.sort(rooms, new Comparator<RoomDto>() {
            @Override
            public int compare(RoomDto o1, RoomDto o2) {
                if (o1.getMessages().size() == 0) return 1;
                if (o2.getMessages().size() == 0) return -1;
                Date lastMessageRoom1 = o1.getMessages().get(o1.getMessages().size() - 1).getSendDate();
                Date lastMessageRoom2 = o2.getMessages().get(o2.getMessages().size() - 1).getSendDate();
                int compareRes = lastMessageRoom1.compareTo(lastMessageRoom2);
                if (compareRes == -1) return 1;
                if (compareRes == 1) return -1;
                return 0;
            }
        });
    }

    private RoomDto handleAddJoinedUserIntoRoomDTO(Room room) {
        RoomDto data = new RoomDto(room);
        data.setParticipants(getAllJoinedUsersByRoomId(data.getId()));
        return data;
    }
}
