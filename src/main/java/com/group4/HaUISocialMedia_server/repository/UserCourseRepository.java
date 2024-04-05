package com.group4.HaUISocialMedia_server.repository;

import com.group4.HaUISocialMedia_server.entity.Classroom;
import com.group4.HaUISocialMedia_server.entity.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface UserCourseRepository extends JpaRepository<UserCourse, UUID> {
    @Query(value = "select uc from UserCourse uc where uc.user.id = :userId order by uc.courseResult.name, uc.course.name")
    List<UserCourse> getUserCourseOfUser(@Param("userId") UUID userId);

    @Query(value = "select uc from UserCourse uc where uc.user.id = :userId and uc.courseResult.id = :courseResultId " +
            "order by uc.course.name")
    List<UserCourse> getUserCourseByResult(@Param("userId") UUID userId, @Param("courseResultId") UUID courseResultId);
}
