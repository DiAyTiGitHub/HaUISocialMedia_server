package com.group4.HaUISocialMedia_server.dto;

import com.group4.HaUISocialMedia_server.entity.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {
    private UUID id;
    private String content;
    private Date sendDate;
    private UserDto user;
    private RoomDto room;
    private MessageTypeDto messageType;

    public MessageDto(Message entity) {
        this.id = entity.getId();
        this.content = entity.getContent();
        this.sendDate = entity.getSendDate();
        if (entity.getRoom() != null)
            this.room = new RoomDto(entity.getRoom());
        if (entity.getUser() != null)
            this.user = new UserDto(entity.getUser());
        if (entity.getMessageType() != null)
            this.messageType = new MessageTypeDto(entity.getMessageType());
    }

    public MessageDto(MessageDto dto) {
        this.id = dto.getId();
        this.content = dto.getContent();
        this.sendDate = dto.getSendDate();
//        if (dto.getRoom() != null)
//            this.room = dto.getRoom();
        if (dto.getUser() != null)
            this.user = dto.getUser();
        if (dto.getMessageType() != null)
            this.messageType = dto.getMessageType();
    }

}
