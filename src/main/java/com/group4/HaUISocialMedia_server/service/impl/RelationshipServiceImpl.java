package com.group4.HaUISocialMedia_server.service.impl;

import com.group4.HaUISocialMedia_server.dto.RelationshipDto;
import com.group4.HaUISocialMedia_server.dto.SearchObject;
import com.group4.HaUISocialMedia_server.dto.UserDto;
import com.group4.HaUISocialMedia_server.entity.*;
import com.group4.HaUISocialMedia_server.repository.*;
import com.group4.HaUISocialMedia_server.service.RelationshipService;
import com.group4.HaUISocialMedia_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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

        return new RelationshipDto(savedRelationship);
    }

    @Override
    public Set<RelationshipDto> getPendingFriendRequests(SearchObject searchObject) {
        User currentUser = userService.getCurrentLoginUserEntity();
        if (currentUser == null) return null;

        List<Relationship> response = relationshipRepository.findAllPendingRelationship(currentUser.getId(), PageRequest.of(searchObject.getPageIndex(), 10));
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

        List<Relationship> response = relationshipRepository.findAllSentFriendRequestRelationship(currentUser.getId(), PageRequest.of(searchObject.getPageIndex(), 10));
        Set<RelationshipDto> res = new HashSet<>();
        for (Relationship relationship : response) {
            res.add(new RelationshipDto(relationship));
        }

        return res;
    }

    @Override
    public Set<UserDto> getCurrentFriends(SearchObject searchObject) {

        User currentUser = userService.getCurrentLoginUserEntity();
        if (currentUser == null) return null;

        List<User> response = userRepository.findAllCurentFriend(currentUser.getId(), PageRequest.of(searchObject.getPageIndex(), 10));
        Set<UserDto> res = new HashSet<>();
        for (User user : response) {
            res.add(new UserDto(user));
        }

        return res;
    }
}
