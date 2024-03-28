package com.group4.HaUISocialMedia_server.rest;

import com.group4.HaUISocialMedia_server.dto.MessageTypeDto;
import com.group4.HaUISocialMedia_server.service.MessageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/api/messageType")
public class MessageTypeController {
    @Autowired
    private MessageTypeService messageTypeService;

    @GetMapping("/{messageTypeId}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<MessageTypeDto> getMessageTypeById(@PathVariable UUID messageTypeId) {
        MessageTypeDto res = messageTypeService.getMessageTypeById(messageTypeId);
        if (res == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<MessageTypeDto>(res, HttpStatus.OK);
    }

    @GetMapping("/all")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<Set<MessageTypeDto>> getAllMessageType() {
        Set<MessageTypeDto> res = messageTypeService.getAllMessageTypes();
        if (res == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<Set<MessageTypeDto>>(res, HttpStatus.OK);
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<MessageTypeDto> createMessageType(@RequestBody MessageTypeDto dto) {
        MessageTypeDto res = messageTypeService.createMessageType(dto);
        if (res == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<MessageTypeDto>(res, HttpStatus.OK);
    }

    @PutMapping
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<MessageTypeDto> updateMessageType(@RequestBody MessageTypeDto dto) {
        MessageTypeDto res = messageTypeService.updateMessageType(dto);
        if (res == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<MessageTypeDto>(res, HttpStatus.OK);
    }

    @DeleteMapping("/{messageTypeId}")
    @CrossOrigin(origins = "http://localhost:5173")
    public void deleteMessageType(@PathVariable UUID messageTypeId) {
        messageTypeService.deleteMessageType(messageTypeId);
    }
}
