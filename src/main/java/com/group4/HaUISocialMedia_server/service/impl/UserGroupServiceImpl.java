package com.group4.HaUISocialMedia_server.service.impl;

import com.group4.HaUISocialMedia_server.dto.UserGroupDto;
import com.group4.HaUISocialMedia_server.service.UserGroupService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserGroupServiceImpl implements UserGroupService {

    @Override
    public UserGroupDto createUserGroup(UserGroupDto userGroupDto) {
        return null;
    }

    @Override
    public UserGroupDto updateUserGroup(UserGroupDto userGroupDto) {
        return null;
    }

    @Override
    public boolean deleteUserGroup(UUID userGroupId) {
        return false;
    }
}
