package com.group4.HaUISocialMedia_server.service;

import com.group4.HaUISocialMedia_server.dto.GroupDto;
import com.group4.HaUISocialMedia_server.dto.UserGroupDto;

import java.util.UUID;

public interface GroupService {

    public GroupDto createGroup(GroupDto groupDto);

    public GroupDto updateGroup(GroupDto groupDto);

    public UserGroupDto joinGroupRequest(UUID groupId);

    public UserGroupDto approvedJoinGroupRequest(UUID userGroupId);

    public boolean cancelJoinGroupRequest(UUID userGroupId);

    public boolean leaveGroup(UUID groupId);

    public boolean deleteGroup(UUID groupId);

    public boolean isAdminGroup(UUID groupId);
}
