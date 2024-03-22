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
    public MessageDto createMessage(MessageDto dto) {
        if (dto == null) return null;
        Room roomEntity = roomRepository.findById(dto.getRoom().getId()).orElse(null);
        if (roomEntity == null) return null;
        User currentUser = userService.getCurrentLoginUserEntity();
        if (currentUser == null) return null;

        MessageType messageType = null;
        if (dto.getMessageType() != null)
            messageType = messageTypeService.getMessageTypeEntityByName(dto.getMessageType().getName());

        Message messageEntity = new Message();
        messageEntity.setMessageType(messageType);
        messageEntity.setContent(dto.getContent());
        messageEntity.setRoom(roomEntity);
        messageEntity.setUser(currentUser);
        messageEntity.setSendDate(new Date());

        return new MessageDto(messageRepository.saveAndFlush(messageEntity));
    }

    @Override
    public MessageDto createMessageAttachedUser(MessageDto dto) {
        if (dto == null) return null;
        if (dto.getRoom() == null) return null;
        Room roomEntity = roomRepository.findById(dto.getRoom().getId()).orElse(null);
        if (roomEntity == null) return null;
        if (dto.getUser() == null) return null;
        User currentUser = userService.getUserEntityById(dto.getUser().getId());
        if (currentUser == null) return null;

        MessageType messageType = null;
        if (dto.getMessageType() != null)
            messageType = messageTypeService.getMessageTypeEntityByName(dto.getMessageType().getName());

        Message messageEntity = new Message();
        messageEntity.setMessageType(messageType);
        messageEntity.setContent(dto.getContent());
        messageEntity.setRoom(roomEntity);
        messageEntity.setUser(currentUser);
        messageEntity.setSendDate(new Date());

        return new MessageDto(messageRepository.saveAndFlush(messageEntity));
    }

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
    public MessageDto handlerForNotification(MessageDto dto) {
        MessageType typeEntity = messageTypeService.getMessageTypeEntityByName("notification");

        User userEntity = userService.getUserEntityById(dto.getUser().getId());
        if (userEntity == null) return null;

        Message message = new Message();
        message.setSendDate(new Date());
        message.setUser(userEntity);
        message.setMessageType(typeEntity);
        message.setContent(dto.getContent());

        if (dto.getRoom() != null) {
            Room roomEntity = roomRepository.findById(dto.getRoom().getId()).orElse(null);
            if (roomEntity != null) {
                message.setRoom(roomEntity);
            }
        }

        Message res = messageRepository.saveAndFlush(message);

        return new MessageDto(res);
    }

    @Override
    public void sendMessageTo(String destination, MessageDto dto) {
        simpMessagingTemplate.convertAndSendToUser(dto.getUser().getId().toString(), destination, dto);
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
    public MessageDto sendPrivateMessage(MessageDto messageDTO) {
        if (!isInRoomChat(messageDTO)) return null;

        if (messageDTO == null) return null;
        if (messageDTO.getUser() == null) return null;
        User currentUser = userService.getUserEntityById(messageDTO.getUser().getId());
        if (currentUser == null) return null;
        Room roomEntity = roomRepository.findById(messageDTO.getRoom().getId()).orElse(null);
        if (roomEntity == null) return null;

//        String decryptedContent = messageDTO.getContent();
//        // content is decrypted by room public key if this message is private for chat
//        if (messageDTO.getMessageType() == null) return null;
//        if (messageDTO.getMessageType().getName().equals("chat")) {
//            RSAKey privateKey = roomEntity.getPrivateKey();
//            decryptedContent = handleDecryptMessage(messageDTO.getContent(), new RSAKeyDTO(privateKey));
//        }
//
//        Message messageEntity = new Message();
//        messageEntity.setRoom(roomEntity);
//        messageEntity.setContent(decryptedContent);
//        MessageType messageTypeEntity = messageTypeService.getMessageTypeEntityByName(messageDTO.getMessageType().getName());
//        if (messageTypeEntity == null) {
//            setupDataService.setupData();
//        }
//        messageTypeEntity = messageTypeService.getMessageTypeEntityByName(messageDTO.getMessageType().getName());
//        if (messageTypeEntity == null) return null;
//        messageEntity.setMessageType(messageTypeEntity);
//        messageEntity.setSendDate(new Date());
//        messageEntity.setUser(currentUser);
//        Message res = messageRepository.saveAndFlush(messageEntity);
//
//        List<MessageDto> latestMessages = get20LatestMessagesByRoomId(res.getRoom().getId());
//
//        MessageDto resDto = new MessageDto(res);
//        if (resDto == null) return null;
//        resDto.getRoom().setMessages(latestMessages);
//        resDto.getRoom().setParticipants(roomService.getAllJoinedUsersByRoomId(resDto.getRoom().getId()));
//
//        Set<UserRoom> userRooms = roomEntity.getUserRooms();
//        List<User> users = new ArrayList<>();
//        Set<UUID> userIdSet = new HashSet<>();
//        for (UserRoom ur : userRooms) {
//            User loopingUser = ur.getUser();
//            if (userIdSet.contains(loopingUser.getId())) continue;
//            users.add(loopingUser);
//            userIdSet.add(loopingUser.getId());
//        }
//
//        String intactContent = resDto.getContent();
//        for (User user : users) {
//            if (currentUser.getId() != user.getId()) {
//                RSAKey publicKey = user.getPublicKey();
//
//                String encryptedMessage = intactContent;
//                if (resDto.getMessageType().getName().equals("chat"))
//                    encryptedMessage = handleEncryptMessage(intactContent, new RSAKeyDTO(publicKey));
//
//                resDto.setContent(encryptedMessage);
//                for (MessageDto messageToUser : resDto.getRoom().getMessages()) {
//                    if (messageToUser.getMessageType().getName().equals("chat"))
//                        messageToUser.setContent(handleEncryptMessage(messageToUser.getContent(), new RSAKeyDTO(publicKey)));
//                }
//                simpMessagingTemplate.convertAndSendToUser(user.getId().toString(), "/privateMessage", resDto);
//            }
//        }

        return null;
    }
}
