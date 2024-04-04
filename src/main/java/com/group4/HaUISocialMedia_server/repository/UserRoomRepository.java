package com.group4.HaUISocialMedia_server.repository;

import com.group4.HaUISocialMedia_server.entity.Course;
import com.group4.HaUISocialMedia_server.entity.Room;
import com.group4.HaUISocialMedia_server.entity.UserRoom;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRoomRepository extends JpaRepository<UserRoom, UUID> {
    @Modifying
    @Transactional
    public UserRoom deleteUserRoomByRoom(Room room);
}

