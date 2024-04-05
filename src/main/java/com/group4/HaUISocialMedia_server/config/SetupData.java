package com.group4.HaUISocialMedia_server.config;

import com.group4.HaUISocialMedia_server.dto.CourseResultDto;
import com.group4.HaUISocialMedia_server.dto.MessageTypeDto;
import com.group4.HaUISocialMedia_server.dto.NotificationTypeDto;
import com.group4.HaUISocialMedia_server.dto.RoomTypeDto;
import com.group4.HaUISocialMedia_server.entity.*;
import com.group4.HaUISocialMedia_server.repository.CourseResultRepository;
import com.group4.HaUISocialMedia_server.repository.RoomTypeRepository;
import com.group4.HaUISocialMedia_server.repository.UserRepository;
import com.group4.HaUISocialMedia_server.service.CourseResultService;
import com.group4.HaUISocialMedia_server.service.MessageTypeService;
import com.group4.HaUISocialMedia_server.service.NotificationTypeService;
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
        initializeNotificationType();
        initializeCourseResult();
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
    private CourseResultRepository courseResultRepository;

    private void initializeCourseResult() {
        CourseResult A = courseResultRepository.findByName("Xuất sắc");
        if (A == null) {
            A.setCode("A");
            A.setName("Xuất sắc");
            A.setDescription("Học sinh đạt thành tích xuất sắc");
            courseResultRepository.save(A);
        }

        CourseResult B_plus = courseResultRepository.findByName("Giỏi");
        if (B_plus == null) {
            B_plus.setCode("B+");
            B_plus.setName("Giỏi");
            B_plus.setDescription("Học sinh đạt thành tích giỏi");
            courseResultRepository.save(B_plus);
        }

        CourseResult B = courseResultRepository.findByName("Khá giỏi");
        if (B == null) {
            B.setCode("B");
            B.setName("Khá giỏi");
            B.setDescription("Học sinh đạt thành tích khá giỏi");
            courseResultRepository.save(B);
        }

        CourseResult C_plus = courseResultRepository.findByName("Khá");
        if (C_plus == null) {
            C_plus.setCode("C+");
            C_plus.setName("Khá");
            C_plus.setDescription("Học sinh đạt thành tích khá");
            courseResultRepository.save(C_plus);
        }

        CourseResult C = courseResultRepository.findByName("Trung bình khá");
        if (C == null) {
            C.setCode("C");
            C.setName("Trung bình khá");
            C.setDescription("Học sinh đạt thành tích trung bình khá");
            courseResultRepository.save(C);
        }

        CourseResult D_plus = courseResultRepository.findByName("Trung bình");
        if (D_plus == null) {
            D_plus.setCode("D+");
            D_plus.setName("Trung bình");
            D_plus.setDescription("Học sinh đạt thành tích trung bình");
            courseResultRepository.save(D_plus);
        }

        CourseResult D = courseResultRepository.findByName("Trung bình kém");
        if (D == null) {
            D.setCode("D");
            D.setName("Trung bình kém");
            D.setDescription("Học sinh đạt thành tích trung bình kém");
            courseResultRepository.save(D);
        }

        CourseResult F = courseResultRepository.findByName("Kém");
        if (F == null) {
            F.setCode("F");
            F.setName("Kém");
            F.setDescription("Học sinh đạt thành tích kém");
            courseResultRepository.save(F);
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

        MessageType recall = messageTypeService.getMessageTypeEntityByName("recall");
        if (notification == null) {
            MessageTypeDto dto = new MessageTypeDto();
            dto.setCode("006");
            dto.setName("recall");
            dto.setDescription("a message which is recalled by creator");
            messageTypeService.createMessageType(dto);
        }
    }

    @Autowired
    private NotificationTypeService notificationTypeService;

    private void initializeNotificationType() {
//        NotificationType tym1 = notificationTypeService.getNotificationTypeEntityByName("Liked");
//        if (tym1 == null) {
//            NotificationTypeDto tym = new NotificationTypeDto();
//            tym.setCode("001");
//            tym.setName("Liked");
//            tym.setDescription("a person liked your post");
//            notificationTypeService.save(tym);
//        }
//
//        NotificationType accept1 = notificationTypeService.getNotificationTypeEntityByName("Accepted");
//        if (accept1 == null) {
//            NotificationTypeDto accept = new NotificationTypeDto();
//            accept.setCode("002");
//            accept.setName("Accepted");
//            accept.setDescription("a person accepted your request friend");
//            notificationTypeService.save(accept);
//        }
//
//        NotificationType request1 = notificationTypeService.getNotificationTypeEntityByName("Requested");
//        if (request1 == null) {
//            NotificationTypeDto request = new NotificationTypeDto();
//            request.setCode("003");
//            request.setName("Requested");
//            request.setDescription("a person requested add friend with you");
//            notificationTypeService.save(request);
//        }

        NotificationType post = notificationTypeService.getNotificationTypeEntityByName("Post");
        if (post == null) {
            NotificationTypeDto postDto = new NotificationTypeDto();
            postDto.setCode("001");
            postDto.setName("Post");
            postDto.setDescription("Tym, Comment, Reply Comment");
            notificationTypeService.save(postDto);
        }

        NotificationType friend = notificationTypeService.getNotificationTypeEntityByName("Friend");
        if (friend == null) {
            NotificationTypeDto friendDto =new NotificationTypeDto();
            friendDto.setCode("002");
            friendDto.setName("Friend");
            friendDto.setDescription("add friend, accept friend");
            notificationTypeService.save(friendDto);
        }
    }


}