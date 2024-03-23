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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
        Set<ClassroomDto> li = new HashSet<>();
        //Page là một đối tượng của interface Page trong Spring Data JPA dùng để thể hiện kết quả trả về theo phân trang
        //PageRequest: Là đối tượng của interface PageRequest, nó cung cấp thông tin phân trang khi truy vấn dữ liệu.
        Page<Classroom> ds = classroomRepository.findAll(PageRequest.of(searchObject.getPageIndex(), searchObject.getPageSize()));
       // List<Classroom> ds = classroomRepository.findAnyClassroom(searchObject.getPageSize(), searchObject.getPageIndex());
        ds.stream().map(ClassroomDto::new).forEach(li::add);
        return li;
    }

    @Override
    public ClassroomDto getById(UUID id) {
        Classroom classroom = classroomRepository.findById(id).orElse(null);
        if(classroom == null)
            return null;
        return new ClassroomDto(classroom);
    }


}
