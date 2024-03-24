package com.group4.HaUISocialMedia_server.repository;

import com.group4.HaUISocialMedia_server.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, UUID> {

}
