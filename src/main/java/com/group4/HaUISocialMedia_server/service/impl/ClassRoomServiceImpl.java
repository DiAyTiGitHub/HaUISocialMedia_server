package com.group4.HaUISocialMedia_server.service.impl;

import com.group4.HaUISocialMedia_server.dto.ClassroomDto;
import com.group4.HaUISocialMedia_server.dto.SearchObject;
import com.group4.HaUISocialMedia_server.dto.UserDto;
import com.group4.HaUISocialMedia_server.entity.Classroom;
import com.group4.HaUISocialMedia_server.entity.User;
import com.group4.HaUISocialMedia_server.repository.ClassroomRepository;
import com.group4.HaUISocialMedia_server.repository.UserRepository;
import com.group4.HaUISocialMedia_server.service.ClassroomService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ClassRoomServiceImpl implements ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;


    @Override
    public Set<ClassroomDto> getAllClassroom() {
        List<Classroom> ds = classroomRepository.findAll();
        return ds.stream()
                .map(ClassroomDto::new)
                .collect(Collectors.toSet());
    }

    @Override
    @Transactional
    public ClassroomDto save(ClassroomDto classroomDto) {
        Classroom entity = new Classroom();

        entity.setCode(classroomDto.getCode());
        entity.setName(classroomDto.getName());
        entity.setDescription(classroomDto.getDescription());

        Classroom responseEnntity = classroomRepository.save(entity);
        return new ClassroomDto(responseEnntity);
    }

    @Override
    @Transactional
    public ClassroomDto update(ClassroomDto classroomDto) {
        Classroom entity = classroomRepository.findById(classroomDto.getId()).orElse(null);
        if (entity == null) return null;
        entity.setCode(classroomDto.getCode());
        entity.setName(classroomDto.getName());
        entity.setDescription(classroomDto.getDescription());

        Classroom responseEnntity = classroomRepository.save(entity);
        return new ClassroomDto(responseEnntity);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        Classroom classroom = classroomRepository.findById(id).orElse(null);
        if(classroom == null)
            return;
        classroomRepository.deleteById(id);
    }

    @Override
    public Set<ClassroomDto> pagingClassroom(SearchObject searchObject) {
        return null;
    }

    @Override
    public ClassroomDto getById(UUID id) {
        Classroom classroom = classroomRepository.findById(id).orElse(null);
        if(classroom == null)
            return null;
        return new ClassroomDto(classroom);
    }
}
