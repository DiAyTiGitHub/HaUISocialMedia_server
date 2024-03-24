package com.group4.HaUISocialMedia_server.dto;

import com.group4.HaUISocialMedia_server.entity.Course;
import com.group4.HaUISocialMedia_server.entity.CourseResult;
import com.group4.HaUISocialMedia_server.entity.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCourseDto {
    private UUID id;
    private User user;
    private CourseDto courseDto;
   // private CourseResultDto courseResult;
}
