package com.group4.HaUISocialMedia_server.controller;

import com.group4.HaUISocialMedia_server.dto.MessageDto;
import com.group4.HaUISocialMedia_server.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

@Controller
public class MessengerModuleController {
    @Autowired
    private MessageService messageService;

//    @MessageMapping("/notification")
//    public ResponseEntity<MessageDto> receiveNotification(@Payload MessageDto message) {
//        if (message == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        message = messageService.handlerForNotification(message);
//        messageService.sendMessageTo("/notification", message);
//        return new ResponseEntity<MessageDto>(message, HttpStatus.OK);
//    }
//
//    @MessageMapping("/privateMessage")
//    public ResponseEntity<MessageDto> spreadMessageToRoomId(@Payload MessageDto message) {
//        MessageDto res = messageService.sendPrivateMessage(message);
//        if (res == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        return new ResponseEntity<MessageDto>(res, HttpStatus.OK);
//    }
}
