package com.group4.HaUISocialMedia_server.repository;

import com.group4.HaUISocialMedia_server.entity.Classroom;
import com.group4.HaUISocialMedia_server.entity.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface UserCourseRepository extends JpaRepository<UserCourse, UUID> {
    @Query(value = "SELECT u.id FROM User u WHERE u.role NOT LIKE 'ADMIN'")
    List<UUID> getAllStudentIds();
}
