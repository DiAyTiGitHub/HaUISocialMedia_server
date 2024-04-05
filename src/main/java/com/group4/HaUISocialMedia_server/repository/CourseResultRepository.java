package com.group4.HaUISocialMedia_server.repository;

import com.group4.HaUISocialMedia_server.entity.CourseResult;
import com.group4.HaUISocialMedia_server.entity.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CourseResultRepository extends JpaRepository<CourseResult, UUID> {
    //public CourseResult findById(UUID id);

    @Query(value = "select cr from CourseResult cr order by cr.name")
    List<CourseResult> findAllResults();
}
