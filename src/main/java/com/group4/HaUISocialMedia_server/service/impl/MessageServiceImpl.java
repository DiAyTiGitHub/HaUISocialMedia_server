package com.group4.HaUISocialMedia_server.service.impl;

import com.group4.HaUISocialMedia_server.dto.MessageDto;
import com.group4.HaUISocialMedia_server.entity.*;
import com.group4.HaUISocialMedia_server.repository.MessageRepository;
import com.group4.HaUISocialMedia_server.repository.RoomRepository;
import com.group4.HaUISocialMedia_server.service.MessageService;
import com.group4.HaUISocialMedia_server.service.MessageTypeService;
import com.group4.HaUISocialMedia_server.service.RoomService;
import com.group4.HaUISocialMedia_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.security.interfaces.RSAKey;
import java.util.*;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private MessageTypeService messageTypeService;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private RoomService roomService;

    @Override
    public List<MessageDto> findTop10PreviousByMileStone(MessageDto mileStone) {
        List<MessageDto> data = messageRepository.findTop10ByRoomAndSendDateBeforeOrderBySendDateDesc(mileStone.getRoom().getId(), mileStone.getSendDate(), PageRequest.of(0, 10));
        List<MessageDto> res = new ArrayList<>();
        for (int i = data.size() - 1; i >= 0; i--) {
            res.add(data.get(i));
        }
        return res;
    }

    @Override
    public Set<MessageDto> getAllMessagesByRoomId(UUID roomId) {
        return messageRepository.getAllMessagesByRoomId(roomId);
    }

    @Override
    public List<MessageDto> get20LatestMessagesByRoomId(UUID roomId) {
        List<MessageDto> data = messageRepository.get20LatestMessagesByRoomId(roomId, PageRequest.of(0, 20));
        List<MessageDto> res = new ArrayList<>();
        for (int i = data.size() - 1; i >= 0; i--) {
            res.add(data.get(i));
        }
        return res;
    }

    @Override
    public boolean isInRoomChat(MessageDto messageDTO) {
        if (messageDTO.getUser() == null) return false;
        User currentUser = userService.getUserEntityById(messageDTO.getUser().getId());

        Room roomEntity = roomRepository.findById(messageDTO.getRoom().getId()).orElse(null);
        if (roomEntity == null) return false;

        for (UserRoom userRoom : roomEntity.getUserRooms()) {
            if (userRoom.getUser().getId().equals(currentUser.getId())) return true;
        }

        return false;
    }

    @Override
    public MessageDto sendMessage(MessageDto messageDTO) {
        if (!isInRoomChat(messageDTO)) return null;

//        simpMessagingTemplate.convertAndSendToUser(user.getId().toString(), "/privateMessage", resDto);

        return null;
    }
}
