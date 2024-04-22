package com.group4.HaUISocialMedia_server.service;

import com.group4.HaUISocialMedia_server.dto.GroupDto;
import com.group4.HaUISocialMedia_server.dto.MemberDto;

import java.util.UUID;

public interface GroupService {

    public GroupDto createGroup(GroupDto groupDto);

    public GroupDto updateGroup(GroupDto groupDto);

    public MemberDto joinGroupRequest(UUID groupId);

    public MemberDto approvedJoinGroupRequest(UUID userGroupId);

    public boolean cancelJoinGroupRequest(UUID userGroupId);

    public boolean leaveGroup(UUID groupId);

    public boolean deleteGroup(UUID groupId);

    public boolean isAdminGroup(UUID groupId);
}
