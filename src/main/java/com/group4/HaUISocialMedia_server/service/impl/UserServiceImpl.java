package com.group4.HaUISocialMedia_server.service.impl;

import com.group4.HaUISocialMedia_server.dto.SearchObject;
import com.group4.HaUISocialMedia_server.dto.UserDto;
import com.group4.HaUISocialMedia_server.entity.User;
import com.group4.HaUISocialMedia_server.repository.ClassroomRepository;
import com.group4.HaUISocialMedia_server.repository.UserRepository;
import com.group4.HaUISocialMedia_server.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RelationshipServiceImpl relationshipService;

    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private UserService userService;
    @Override
    public Set<UserDto> getAllUsers() {
        Set<UserDto> res = new HashSet<>();
        List<User> ds = userRepository.findAll();
        ds.stream().map(UserDto::new).forEach(res::add);
        return res;
    }

    @Override
    public UserDto getById(UUID userId)
    {
        Optional<User> user = userRepository.findById(userId);
        return user.map(UserDto::new).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public UserDto getByUserName(String name) {
        return new UserDto(userRepository.findByUsername(name));
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public UserDto updateUser(UserDto dto) {
        User entity = userService.getCurrentLoginUserEntity();
        if(entity == null)
            return null;
        entity.setCode(dto.getCode());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setUsername(dto.getUsername());
        entity.setAddress(dto.getAddress());
        entity.setGender(dto.isGender());
        entity.setBirthDate(dto.getBirthDate());
        entity.setAvatar(dto.getAvatar());
        entity.setPhoneNumber(dto.getPhoneNumber());

        if(dto.getClassroomDto() != null)
            entity.setClassroom(classroomRepository.findById(dto.getClassroomDto().getId()).orElse(null));
        userRepository.saveAndFlush(entity);
        return dto;
    }

    @Override
    public Set<UserDto> searchByUsername(SearchObject searchObject) {
        Set<UserDto> se = new HashSet<>();
        List<User> li = userRepository.getByUserName(searchObject.getKeyWord(), searchObject.getPageSize(), searchObject.getPageIndex());
        li.stream().map(UserDto::new).forEach(se::add);
        return se;
    }

    @Override
    public Set<UserDto> pagingUser(SearchObject searchObject) {
        Set<UserDto> se = new HashSet<>();

        Page<User> li = userRepository.findAll(PageRequest.of(searchObject.getPageIndex(), searchObject.getPageSize()));

        li.stream().map(UserDto::new).forEach(se::add);
        return se;
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

    @Override
    public Set<UserDto> pagingNewUser(SearchObject searchObject) {
        User currentUser = getCurrentLoginUserEntity();
        if (currentUser == null) return null;

        List<User> response = userRepository.findNewFriend(currentUser.getId(), PageRequest.of(searchObject.getPageIndex(), searchObject.getPageSize()));
        Set<UserDto> res = new HashSet<>();
        for (User user : response) {
            if (searchObject.getKeyWord() != null && searchObject.getKeyWord().length() > 0) {
                if (relationshipService.containsKeyword(searchObject.getKeyWord(), user)) res.add(new UserDto(user));
            } else
                res.add(new UserDto(user));
        }

        return res;
    }


}
