package com.group4.HaUISocialMedia_server.repository;

import com.group4.HaUISocialMedia_server.dto.MessageDto;
import com.group4.HaUISocialMedia_server.entity.Message;
import com.group4.HaUISocialMedia_server.entity.Room;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface RoomRepository extends JpaRepository<Room, UUID> {
}
