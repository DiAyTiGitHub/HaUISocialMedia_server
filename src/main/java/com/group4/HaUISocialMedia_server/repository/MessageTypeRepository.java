package com.group4.HaUISocialMedia_server.repository;

import com.group4.HaUISocialMedia_server.entity.Classroom;
import com.group4.HaUISocialMedia_server.entity.MessageType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MessageTypeRepository extends JpaRepository<MessageType, UUID> {
    public MessageType findByName(String name);
}
