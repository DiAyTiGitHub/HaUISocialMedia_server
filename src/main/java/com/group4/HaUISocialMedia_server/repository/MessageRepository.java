package com.group4.HaUISocialMedia_server.repository;

import com.group4.HaUISocialMedia_server.dto.MessageDto;
import com.group4.HaUISocialMedia_server.entity.Classroom;
import com.group4.HaUISocialMedia_server.entity.Message;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface MessageRepository extends JpaRepository<Message, UUID> {
    @Query(value = "select new com.group4.HaUISocialMedia_server.dto.MessageDto(m) from Message m where m.room.id = ?1 and m.sendDate < ?2 order by m.sendDate desc ")
    List<MessageDto> findTop10ByRoomAndSendDateBeforeOrderBySendDateDesc(UUID roomId, Date sendDate, Pageable pageable);

    @Query("select new com.group4.HaUISocialMedia_server.dto.MessageDto(m) from Message m where m.room.id = ?1 order by m.sendDate desc ")
    public Set<MessageDto> getAllMessagesByRoomId(UUID roomId);

    @Query(value = "select new com.group4.HaUISocialMedia_server.dto.MessageDto(m) from Message m where m.room.id = ?1 order by m.sendDate desc ")
    List<MessageDto> get20LatestMessagesByRoomId(UUID roomId, Pageable pageable);

    @Query(value = "select new com.group4.HaUISocialMedia_server.dto.MessageDto(m) from Message m where m.user.id = ?1 and m.messageType.name like 'notification' order by m.sendDate desc ")
    List<MessageDto> getTop20LatestNotifications(UUID userId, Pageable pageable);

    @Query(value = "select new com.group4.HaUISocialMedia_server.dto.MessageDto(m) from Message m where m.user.id = ?1 and m.messageType.name like 'notification' order by m.sendDate desc ")
    List<MessageDto> getAllNotificationsByUserId(UUID userId);
}
