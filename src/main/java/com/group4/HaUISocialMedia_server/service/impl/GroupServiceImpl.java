package com.group4.HaUISocialMedia_server.service.impl;

import com.group4.HaUISocialMedia_server.dto.GroupDto;
import com.group4.HaUISocialMedia_server.dto.UserGroupDto;
import com.group4.HaUISocialMedia_server.service.GroupService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GroupServiceImpl implements GroupService {

    @Override
    public GroupDto createGroup(GroupDto groupDto) {
        return null;
    }

    @Override
    public GroupDto updateGroup(GroupDto groupDto) {
        return null;
    }

    @Override
    public UserGroupDto joinGroupRequest(UUID groupId) {
        return null;
    }

    @Override
    public UserGroupDto approvedJoinGroupRequest(UUID userGroupId) {
        return null;
    }

    @Override
    public boolean cancelJoinGroupRequest(UUID userGroupId) {
        return false;
    }

    @Override
    public boolean leaveGroup(UUID groupId) {
        return false;
    }

    @Override
    public boolean deleteGroup(UUID groupId) {
        return false;
    }

    @Override
    public boolean isAdminGroup(UUID groupId) {
        return false;
    }
}


