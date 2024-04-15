package com.group4.HaUISocialMedia_server.service;

import com.group4.HaUISocialMedia_server.dto.SearchObject;
import com.group4.HaUISocialMedia_server.dto.UserDto;
import com.group4.HaUISocialMedia_server.entity.User;

import java.util.Set;
import java.util.UUID;

public interface UserService {
    public Set<UserDto> getAllUsers();

    public UserDto getById(UUID userId);

    public UserDto getByUserName(String name);

    public void deleteById(UUID id);

    public UserDto updateUser(UserDto dto);

    public Set<UserDto> searchByUsername(SearchObject searchObject);

    public Set<UserDto> pagingUser(SearchObject searchObject);

    public User getCurrentLoginUserEntity();

    public UserDto getCurrentLoginUser();

    public User getUserEntityById(UUID userId);

    public Set<UserDto> pagingNewUser(SearchObject searchObject);


}
