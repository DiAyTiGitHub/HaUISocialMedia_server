package com.group4.HaUISocialMedia_server.dto;

import com.group4.HaUISocialMedia_server.entity.Course;
import com.group4.HaUISocialMedia_server.entity.CourseResult;
import com.group4.HaUISocialMedia_server.entity.User;
import com.group4.HaUISocialMedia_server.entity.UserCourse;
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
    private UserDto userDto;
    private CourseDto courseDto;
    private CourseResultDto courseResultDto;

    public UserCourseDto(UserCourse userCourse){
        this.id = userCourse.getId();
        if(userCourse.getUser() != null)
            this.userDto = new UserDto(userCourse.getUser());
        if(userCourse.getCourse() != null)
            this.courseDto = new CourseDto(userCourse.getCourse());
        if(userCourse.getCourseResult() != null)
            this.courseResultDto = new CourseResultDto(userCourse.getCourseResult());

    }
}
