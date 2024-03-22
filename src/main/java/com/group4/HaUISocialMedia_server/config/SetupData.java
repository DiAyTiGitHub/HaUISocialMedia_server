package com.group4.HaUISocialMedia_server.config;

import com.group4.HaUISocialMedia_server.dto.MessageTypeDto;
import com.group4.HaUISocialMedia_server.dto.RoomTypeDto;
import com.group4.HaUISocialMedia_server.entity.MessageType;
import com.group4.HaUISocialMedia_server.entity.Role;
import com.group4.HaUISocialMedia_server.entity.RoomType;
import com.group4.HaUISocialMedia_server.entity.User;
import com.group4.HaUISocialMedia_server.repository.RoomTypeRepository;
import com.group4.HaUISocialMedia_server.repository.UserRepository;
import com.group4.HaUISocialMedia_server.service.MessageTypeService;
import com.group4.HaUISocialMedia_server.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SetupData implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        setupData();

        System.out.println("Application started with diayti's initial config!");
    }

    private void setupData() {
        initializeBaseUser();
        initializeRoomType();
        initializeMessageType();
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private void initializeBaseUser() {
        //initialize user admin
        User admin = userRepository.findByUsername("admin");
        if (admin == null) {
            admin = new User();
            admin.setRole(Role.ADMIN.name());
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin"));

            userRepository.save(admin);
        }
    }

    @Autowired
    private RoomTypeService roomTypeService;

    private void initializeRoomType() {
        RoomType privates = roomTypeService.getRoomTypeEntityByName("private");
        if (privates == null) {
            RoomTypeDto dto = new RoomTypeDto();
            dto.setCode("001");
            dto.setName("private");
            dto.setDescription("private room is for 2 people chatting");
            roomTypeService.createRoomType(dto);
        }

        RoomType pub = roomTypeService.getRoomTypeEntityByName("public");
        if (pub == null) {
            RoomTypeDto dto = new RoomTypeDto();
            dto.setCode("002");
            dto.setName("public");
            dto.setDescription("public room is for multiple people chatting");
            roomTypeService.createRoomType(dto);
        }

        RoomType group = roomTypeService.getRoomTypeEntityByName("group");
        if (group == null) {
            RoomTypeDto dto = new RoomTypeDto();
            dto.setCode("003");
            dto.setName("group");
            dto.setDescription("is private room chat for at least 3 people");
            roomTypeService.createRoomType(dto);
        }
    }

    @Autowired
    private MessageTypeService messageTypeService;

    private void initializeMessageType() {
        MessageType joined = messageTypeService.getMessageTypeEntityByName("join");
        if (joined == null) {
            MessageTypeDto dto = new MessageTypeDto();
            dto.setCode("001");
            dto.setName("join");
            dto.setDescription("new user joined conversation");
            messageTypeService.createMessageType(dto);
        }

        MessageType left = messageTypeService.getMessageTypeEntityByName("left");
        if (left == null) {
            MessageTypeDto dto = new MessageTypeDto();
            dto.setCode("002");
            dto.setName("left");
            dto.setDescription("an user had left the conversation");
            messageTypeService.createMessageType(dto);
        }

        MessageType chat = messageTypeService.getMessageTypeEntityByName("chat");
        if (chat == null) {
            MessageTypeDto dto = new MessageTypeDto();
            dto.setCode("003");
            dto.setName("chat");
            dto.setDescription("a common message in the conversation");
            messageTypeService.createMessageType(dto);
        }

        MessageType notification = messageTypeService.getMessageTypeEntityByName("notification");
        if (notification == null) {
            MessageTypeDto dto = new MessageTypeDto();
            dto.setCode("004");
            dto.setName("notification");
            dto.setDescription("is a notification");
            messageTypeService.createMessageType(dto);
        }
    }


}