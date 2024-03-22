package com.group4.HaUISocialMedia_server.service.impl;

import com.group4.HaUISocialMedia_server.dto.ClassroomDto;
import com.group4.HaUISocialMedia_server.dto.UserDto;
import com.group4.HaUISocialMedia_server.entity.Classroom;
import com.group4.HaUISocialMedia_server.entity.User;
import com.group4.HaUISocialMedia_server.repository.ClassroomRepository;
import com.group4.HaUISocialMedia_server.repository.UserRepository;
import com.group4.HaUISocialMedia_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClassroomRepository classroomRepository;

    @Override
    public Set<UserDto> getAllUsers() {
        Set<UserDto> li = new HashSet<>();
        List<User> ds = userRepository.findAll();
        ds.stream().map(UserDto::new).forEach(li::add);
        return li;
    }

    @Override
    public UserDto getById(UUID userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.map(UserDto::new).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public UserDto getByUserName(String name) {
        return new UserDto(userRepository.findByUsername(name));
    }

    @Override
    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto updateUser(UserDto dto) {
        User entity = userRepository.findById(dto.getId()).orElse(null);
        if (entity == null) return null;

        // Update the user entity with the new data from the DTO
        entity.setCode(dto.getCode());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setUsername(dto.getUsername());
        entity.setAddress(dto.getAddress());
        entity.setGender(dto.isGender());
        entity.setBirthDate(dto.getBirthDate());
        // You can update other fields similarly

        if (dto.getClassroomDto() != null) {
            Classroom classroomEntity = classroomRepository.findById(dto.getClassroomDto().getId()).orElse(null);
            if (classroomEntity != null) entity.setClassroom(classroomEntity);
        }

        User response = userRepository.save(entity);

        return new UserDto(response);

    }

    @Override
    public User getCurrentLoginUserEntity() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String currentUserName = auth.getName();
        if (currentUserName == null) return null;
        User currentUser = userRepository.findByUsername(currentUserName);

        return currentUser;
    }

    @Override
    public User getUserEntityById(UUID userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
