package com.group4.HaUISocialMedia_server.rest;

import com.group4.HaUISocialMedia_server.dto.NotificationDto;
import com.group4.HaUISocialMedia_server.dto.SearchObject;
import com.group4.HaUISocialMedia_server.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/api/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/all")
    public ResponseEntity<Set<NotificationDto>> getAll(){
        Set<NotificationDto> res = notificationService.getAllNotifications();
        if(res == null)
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<NotificationDto> save(@RequestBody NotificationDto notificationDto){
        NotificationDto notificationDto1 = notificationService.save(notificationDto);
        if(notificationDto1 == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(notificationDto1, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<NotificationDto> upate(@RequestBody NotificationDto notificationDto){
        NotificationDto notificationDto1 = notificationService.update(notificationDto);
        if(notificationDto1 == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(notificationDto1, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id")UUID id){
        if(notificationService.deleteById(id))
            return new ResponseEntity<>(true, HttpStatus.OK);
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/paging")
    public ResponseEntity<Set<NotificationDto>> pagingNotification(@RequestBody SearchObject searchObject){
        Set<NotificationDto> res = notificationService.getAnyNotification(searchObject);
        if(res == null)
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
