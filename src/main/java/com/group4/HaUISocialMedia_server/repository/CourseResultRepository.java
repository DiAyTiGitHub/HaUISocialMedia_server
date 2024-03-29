package com.group4.HaUISocialMedia_server.repository;

import com.group4.HaUISocialMedia_server.entity.CourseResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseResultRepository extends JpaRepository<CourseResult, UUID> {
    //public CourseResult findById(UUID id);


}
