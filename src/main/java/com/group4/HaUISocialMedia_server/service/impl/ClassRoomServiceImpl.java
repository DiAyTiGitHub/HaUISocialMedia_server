package com.group4.HaUISocialMedia_server.service.impl;

import com.group4.HaUISocialMedia_server.dto.ClassroomDto;
import com.group4.HaUISocialMedia_server.dto.UserDto;
import com.group4.HaUISocialMedia_server.entity.Classroom;
import com.group4.HaUISocialMedia_server.entity.User;
import com.group4.HaUISocialMedia_server.repository.ClassroomRepository;
import com.group4.HaUISocialMedia_server.repository.UserRepository;
import com.group4.HaUISocialMedia_server.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ClassRoomServiceImpl implements ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public Set<ClassroomDto> getAllClassroom() {
        List<Classroom> ds = classroomRepository.findAll();
        return ds.stream()
                .map(ClassroomDto::new)
                .collect(Collectors.toSet());
    }

    @Override
    public ClassroomDto save(ClassroomDto classroomDto) {
        return new ClassroomDto(classroomRepository.save(new Classroom(classroomDto)));
    }

    @Override
    public ClassroomDto update(ClassroomDto classroomDto) {
        return new ClassroomDto(classroomRepository.saveAndFlush(new Classroom(classroomDto)));
    }

    @Override
    public void deleteById(UUID id) {
        classroomRepository.deleteById(id);
    }

    @Override
    public Boolean addStudent(UUID id_class, UUID id_student) {
        Classroom classroom = classroomRepository.findById(id_class).orElseThrow();
        User student = userRepository.findById(id_student).orElseThrow();
        if(classroom == null || student == null) return false;
        classroom.addStudent(student);
        return true;
    }
}
