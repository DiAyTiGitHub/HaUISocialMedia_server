package com.group4.HaUISocialMedia_server.service.impl;

import com.group4.HaUISocialMedia_server.dto.NotificationDto;
import com.group4.HaUISocialMedia_server.dto.RelationshipDto;
import com.group4.HaUISocialMedia_server.dto.SearchObject;
import com.group4.HaUISocialMedia_server.dto.UserDto;
import com.group4.HaUISocialMedia_server.entity.*;
import com.group4.HaUISocialMedia_server.repository.*;
import com.group4.HaUISocialMedia_server.service.NotificationService;
import com.group4.HaUISocialMedia_server.service.NotificationTypeService;
import com.group4.HaUISocialMedia_server.service.RelationshipService;
import com.group4.HaUISocialMedia_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RelationshipServiceImpl implements RelationshipService {
    @Autowired
    private UserService userService;

    @Autowired
    private RelationshipRepository relationshipRepository;

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRoomRepository userRoomRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NotificationTypeService notificationTypeService;

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public RelationshipDto sendAddFriendRequest(UUID receiverId) {
        Relationship entity = new Relationship();

        User receiver = userService.getUserEntityById(receiverId);
        entity.setReceiver(receiver);

        User requestSender = userService.getCurrentLoginUserEntity();
        entity.setRequestSender(requestSender);

        if (receiver.getId() == requestSender.getId()) return null;

        entity.setState(false);
        entity.setLastModifyDate(new Date());

        Relationship savedEntity = relationshipRepository.save(entity);

        //set Relationship
//        UserDto recieverDto = new UserDto(receiver);
//        RelationshipDto relationshipDto = new RelationshipDto(entity);
//        recieverDto.setRelationshipDto(relationshipDto);

        //
        NotificationType notificationType = notificationTypeService.getNotificationTypeEntityByName("Friend");

        Notification notification = new Notification();
        notification.setCreateDate(new Date());
        notification.setContent(requestSender.getUsername() + " đã gửi lời mời kết bạn");
        notification.setOwner(receiver);
        notification.setActor(requestSender);
        notification.setNotificationType(notificationType);

        Notification savedNoti = notificationRepository.save(notification);
        NotificationDto willSendNoti = new NotificationDto(savedNoti);

        //send this noti via socket (do later)
        simpMessagingTemplate.convertAndSendToUser(receiver.getId().toString(), "/notification", willSendNoti);
        return new RelationshipDto(savedEntity);
    }

    @Override
    public RelationshipDto acceptFriendRequest(UUID relationshipId) {
        Relationship entity = relationshipRepository.findById(relationshipId).orElse(null);
        if (entity == null) return null;

        entity.setState(true);
        Relationship savedRelationship = relationshipRepository.save(entity);

        Room chatRoom = new Room();
        RoomType roomType = roomTypeRepository.findByName("private");
        chatRoom.setRoomType(roomType);
        chatRoom.setRelationship(entity);
        chatRoom.setCreateDate(new Date());

        //save room to db, now room is existed
        Room savedRoom = roomRepository.save(chatRoom);
        savedRelationship.setRoom(savedRoom);
        savedRelationship = relationshipRepository.save(savedRelationship);

        //add requestSender to room
        User requestSender = savedRelationship.getRequestSender();
        UserRoom userRoom1 = new UserRoom();
        userRoom1.setUser(requestSender);
        userRoom1.setRoom(savedRoom);
        userRoom1.setRole("user");

        userRoomRepository.save(userRoom1);

        //add receiver to room
        User receiver = savedRelationship.getReceiver();
        UserRoom userRoom2 = new UserRoom();
        userRoom2.setUser(receiver);
        userRoom2.setRoom(savedRoom);
        userRoom2.setRole("user");

        userRoomRepository.save(userRoom2);

        NotificationType notificationType = notificationTypeService.getNotificationTypeEntityByName("Friend");

        Notification notification = new Notification();
        notification.setCreateDate(new Date());
        notification.setActor(receiver);
        notification.setContent(receiver.getUsername() + " đã chấp nhận lời mời kết bạn");
        notification.setOwner(requestSender);
        notification.setNotificationType(notificationType);

        Notification savedNoti = notificationRepository.save(notification);
        NotificationDto willSendNoti = new NotificationDto(savedNoti);

        //send this noti via socket (do later)
        simpMessagingTemplate.convertAndSendToUser(requestSender.getId().toString(), "/notification", willSendNoti);

        //set Relationship
//        UserDto recieverDto = new UserDto(requestSender);
//        RelationshipDto relationshipDto = new RelationshipDto(entity);
//        recieverDto.setRelationshipDto(relationshipDto);

        return new RelationshipDto(savedRelationship);
    }

    @Override
    public Set<RelationshipDto> getPendingFriendRequests(SearchObject searchObject) {
        User currentUser = userService.getCurrentLoginUserEntity();
        if (currentUser == null) return null;

        List<Relationship> response = relationshipRepository.findAllPendingRelationship(currentUser.getId(), PageRequest.of(searchObject.getPageIndex(), searchObject.getPageSize()));
        Set<RelationshipDto> res = new HashSet<>();
        for (Relationship relationship : response) {
            res.add(new RelationshipDto(relationship));
        }

        return res;
    }

    @Override
    public Set<RelationshipDto> getSentAddFriendRequests(SearchObject searchObject) {
        User currentUser = userService.getCurrentLoginUserEntity();
        if (currentUser == null) return null;

        List<Relationship> response = relationshipRepository.findAllSentFriendRequestRelationship(currentUser.getId(), PageRequest.of(searchObject.getPageIndex(), searchObject.getPageSize()));
        Set<RelationshipDto> res = new HashSet<>();
        for (Relationship relationship : response) {
            res.add(new RelationshipDto(relationship));
        }

        return res;
    }

    @Override
    public List<UserDto> getCurrentFriends(SearchObject searchObject) {

        User currentUser = userService.getCurrentLoginUserEntity();
        if (currentUser == null) return null;

        List<User> response = userRepository.findAllCurentFriend(currentUser.getId(), PageRequest.of(searchObject.getPageIndex(), searchObject.getPageSize()));
        List<UserDto> res = new ArrayList<>();
        for (User user : response) {
            if (searchObject.getKeyWord() != null && searchObject.getKeyWord().length() > 0) {
                if (containsKeyword(searchObject.getKeyWord(), user)) res.add(new UserDto(user));
            } else
                res.add(new UserDto(user));
        }
        return res;
    }

    @Override
    public List<UserDto> pagingNewUser(SearchObject searchObject) {
        User currentUser = userService.getCurrentLoginUserEntity();
        if (currentUser == null) return null;

        List<User> response = userRepository.findNewFriend(currentUser.getId(), PageRequest.of(searchObject.getPageIndex(), searchObject.getPageSize()));
        List<UserDto> res = new ArrayList<>();
        for (User user : response) {
            if (searchObject.getKeyWord() != null && searchObject.getKeyWord().length() > 0) {
                if (containsKeyword(searchObject.getKeyWord(), user)) res.add(new UserDto(user));
            } else
                res.add(new UserDto(user));
        }
        return res;
    }

    public boolean containsKeyword(String keyword, User user) {
        if (user.getAddress().contains(keyword)) return true;
        if (user.getUsername().contains(keyword)) return true;
        if (user.getEmail().contains(keyword)) return true;
        if (user.getFirstName().contains(keyword)) return true;
        if (user.getLastName().contains(keyword)) return true;
        return false;
    }

    @Override
    public Set<UserDto> getFriendsOfUser(UUID userId, SearchObject searchObject) {
        User currentUser = userService.getUserEntityById(userId);
        if (currentUser == null) return null;

        List<User> response = userRepository.findAllCurentFriend(currentUser.getId(), PageRequest.of(searchObject.getPageIndex(), searchObject.getPageSize()));
        Set<UserDto> res = new HashSet<>();
        for (User user : response) {
            if (searchObject.getKeyWord() != null && searchObject.getKeyWord().length() > 0) {
                if (containsKeyword(searchObject.getKeyWord(), user)) res.add(new UserDto(user));
            } else
                res.add(new UserDto(user));
        }

        return res;
    }

    @Override
    public RelationshipDto unFriend(UUID relationshipId) {
        Relationship entity = relationshipRepository.findById(relationshipId).orElse(null);
        if (entity == null) return null;
        //delete notification
        notificationRepository.deleteNotificationAddFriendByIdUser(entity.getRequestSender().getId(), entity.getReceiver().getId());
        notificationRepository.deleteNotificationAcceptFriendByIdUser(entity.getRequestSender().getId(), entity.getReceiver().getId());
        //delete message
        messageRepository.deleteMessageByRoomId(entity.getRoom().getId());
        //delete room user
        UserRoom userRoom = new UserRoom();
        userRoom = userRoomRepository.deleteUserRoomByRoom(entity.getRoom());
        //set room
//        Room room = roomRepository.findById(entity.getRoom().getId()).orElse(null);
//        room.
        //delete room
        roomRepository.deleteById(entity.getRoom().getId());
        Room room = roomRepository.findById(entity.getRoom().getId()).orElse(null);
        entity.setRoom(room);
        relationshipRepository.save(entity);
        //delete relationship
        relationshipRepository.deleteById(relationshipId);
        Relationship relationship = relationshipRepository.findById(relationshipId).orElse(null);
        RelationshipDto relationshipDto = new RelationshipDto(relationship);
        return null;
    }

    @Override
    public RelationshipDto unAcceptFriendRequest(UUID relationshipId) {
        Relationship entity = relationshipRepository.findById(relationshipId).orElse(null);
        if (entity == null) return null;
        if(entity.getRequestSender() == null) return null;
        //delete notification
        notificationRepository.deleteNotificationAddFriendByIdUser(entity.getRequestSender().getId(), entity.getReceiver().getId());
        //delete relationship
        relationshipRepository.deleteById(relationshipId);
        Relationship relationship = relationshipRepository.findById(relationshipId).orElse(null);
        return null;
    }


    @Override
    public List<UserDto> getAllFiends() {
        User currentUser = userService.getCurrentLoginUserEntity();

        Set<User> friends = new HashSet<User>();

//        for (Relationship relationship : currentUser.getFriendFromRequest()) {
//            if (relationship.getState()) {
//                User requestReceiver = relationship.getReceiver();
//                friends.add(requestReceiver);
//            }
//        }
//        for (Relationship relationship : currentUser.getFriendFromReceive()) {
//            if (relationship.getState()) {
//                User requestSender = relationship.getRequestSender();
//                friends.add(requestSender);
//            }
//        }

        List<UserDto> friendList = new ArrayList<>();
        for (User friend : friends) {
            friendList.add(new UserDto(friend));
        }

        return friendList;
    }
}
