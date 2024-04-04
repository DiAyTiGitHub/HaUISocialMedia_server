package com.group4.HaUISocialMedia_server.service.impl;

import com.group4.HaUISocialMedia_server.dto.UserCourseDto;
import com.group4.HaUISocialMedia_server.entity.Course;
import com.group4.HaUISocialMedia_server.entity.CourseResult;
import com.group4.HaUISocialMedia_server.entity.User;
import com.group4.HaUISocialMedia_server.entity.UserCourse;
import com.group4.HaUISocialMedia_server.repository.CourseRepository;
import com.group4.HaUISocialMedia_server.repository.CourseResultRepository;
import com.group4.HaUISocialMedia_server.repository.UserCourseRepository;
import com.group4.HaUISocialMedia_server.service.UserCourseService;
import com.group4.HaUISocialMedia_server.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserCourseServiceImpl implements UserCourseService {
    @Autowired
    private UserCourseRepository userCourseRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseResultRepository courseResultRepository;

    @Override
    public UserCourseDto getUserCourseById(UUID userCourseId) {
        if (userCourseId == null) return null;
        UserCourse entity = userCourseRepository.findById(userCourseId).orElse(null);
        if (entity == null) return null;
        return new UserCourseDto(entity);
    }

    @Override
    public UserCourseDto createUserCourse(UserCourseDto dto) {
        if (dto == null) return null;

        User currentUser = userService.getCurrentLoginUserEntity();
        if (dto.getUser() != null) {
            currentUser = userService.getUserEntityById(dto.getUser().getId());
        }
        if (currentUser == null) return null;

        if (dto.getCourse() == null) return null;
        Course course = courseRepository.findById(dto.getCourse().getId()).orElse(null);
        if (course == null) return null;

        if (dto.getCourseResult() == null) return null;
        CourseResult courseResult = courseResultRepository.findById(dto.getCourseResult().getId()).orElse(null);
        if (courseResult == null) return null;

        UserCourse entity = new UserCourse();
        entity.setCourse(course);
        entity.setCourseResult(courseResult);
        entity.setUser(currentUser);
        entity.setScore(dto.getScore());
        entity.setModifyDate(new Date());

        UserCourse savedEntity = userCourseRepository.save(entity);
        if (savedEntity == null) return null;

        return new UserCourseDto(savedEntity);
    }

    @Override
    public UserCourseDto updateUserCourse(UserCourseDto dto) {
        if (dto == null) return null;
        User currentUser = userService.getCurrentLoginUserEntity();
        if (currentUser == null) return null;

        if (dto.getCourse() == null) return null;
        Course course = courseRepository.findById(dto.getCourse().getId()).orElse(null);
        if (course == null) return null;

        if (dto.getCourseResult() == null) return null;
        CourseResult courseResult = courseResultRepository.findById(dto.getCourseResult().getId()).orElse(null);
        if (courseResult == null) return null;

        UserCourse entity = userCourseRepository.findById(dto.getId()).orElse(null);
        if (entity == null) return null;

        entity.setCourse(course);
        entity.setCourseResult(courseResult);
        entity.setUser(currentUser);
        entity.setScore(dto.getScore());
        entity.setModifyDate(new Date());

        UserCourse savedEntity = userCourseRepository.save(entity);
        if (savedEntity == null) return null;

        return new UserCourseDto(savedEntity);
    }

    @Override
    public boolean deleteUserCourseById(UUID userCourseId) {
        if (userCourseId == null) return false;
        UserCourse entity = userCourseRepository.findById(userCourseId).orElse(null);
        if (entity == null) return false;

        userCourseRepository.delete(entity);

        return true;
    }

    @Override
    public List<UserCourseDto> getUserCourseOfUser(UUID userId) {
        return null;
    }
}
