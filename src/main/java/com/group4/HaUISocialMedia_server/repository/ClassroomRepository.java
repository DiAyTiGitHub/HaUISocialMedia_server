package com.group4.HaUISocialMedia_server.repository;

import com.group4.HaUISocialMedia_server.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClassroomRepository extends JpaRepository<Classroom, UUID> {
}
