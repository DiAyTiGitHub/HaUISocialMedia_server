package com.group4.HaUISocialMedia_server.repository;

import com.group4.HaUISocialMedia_server.entity.Comment;
import com.group4.HaUISocialMedia_server.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
}
