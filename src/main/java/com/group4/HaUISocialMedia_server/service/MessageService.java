package com.group4.HaUISocialMedia_server.service;

import com.group4.HaUISocialMedia_server.dto.MessageDto;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface MessageService {
    public MessageDto createMessage(MessageDto dto);

    public MessageDto createMessageAttachedUser(MessageDto dto);

    public List<MessageDto> findTop10PreviousByMileStone(MessageDto mileStone);

    public Set<MessageDto> getAllMessagesByRoomId(UUID roomId);

    public List<MessageDto> get20LatestMessagesByRoomId(UUID roomId);

    public MessageDto handlerForNotification(MessageDto dto);

    public void sendMessageTo(String destination, MessageDto dto);

    public MessageDto sendPrivateMessage(MessageDto messageDTO);

    public boolean isInRoomChat(MessageDto dto);
}
