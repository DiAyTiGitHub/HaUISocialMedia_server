package com.group4.HaUISocialMedia_server.service;

import com.group4.HaUISocialMedia_server.dto.MessageDto;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface MessageService {
    public List<MessageDto> findTop10PreviousByMileStone(MessageDto mileStone);

    public Set<MessageDto> getAllMessagesByRoomId(UUID roomId);

    public List<MessageDto> get20LatestMessagesByRoomId(UUID roomId);

    public MessageDto sendMessage(MessageDto messageDTO);

    public boolean isInRoomChat(MessageDto dto);
}
