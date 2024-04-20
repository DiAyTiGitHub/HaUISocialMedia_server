package com.group4.HaUISocialMedia_server.service;

import com.group4.HaUISocialMedia_server.dto.UserGroupDto;

import java.util.UUID;

public interface UserGroupService {

    public UserGroupDto createUserGroup(UserGroupDto userGroupDto);

    public UserGroupDto updateUserGroup(UserGroupDto userGroupDto);

    public boolean deleteUserGroup(UUID userGroupId);

}
