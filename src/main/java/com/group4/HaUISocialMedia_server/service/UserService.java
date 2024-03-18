package com.group4.HaUISocialMedia_server.service;

import com.group4.HaUISocialMedia_server.dto.UserDto;

import java.util.Set;
import java.util.UUID;

public interface UserService {
    public Set<UserDto> getAllUsers();

    public UserDto getById(UUID userId);
}
