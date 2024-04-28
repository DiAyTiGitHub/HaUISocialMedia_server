package com.group4.HaUISocialMedia_server.service;

import com.group4.HaUISocialMedia_server.dto.GroupDto;
import com.group4.HaUISocialMedia_server.dto.MemberDto;

import java.util.Set;
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

    public Set<GroupDto> getAllJoinedGroupOfUser(UUID userId);

    public Set<GroupDto> searchGroupByName(String name);

    public MemberDto dutyAdmin(UUID memberId);

    public boolean cancelDutyAdmin(UUID memberId);

    public Set<MemberDto> getAllUserWaitJoinedGroup(UUID groupId);

    public boolean kickUserLeaveFGroup(UUID memberId);

    public GroupDto findById(UUID groupId);

    public GroupDto findGroupByMember(UUID memberId);

    public boolean isJoinedGroup(UUID groupId);

    public Set<GroupDto> getAllGroupUserIsAdmin();

    public Set<GroupDto> getAllGroupUserNotYetJoin();

    public Set<MemberDto> getAllUserJoinedGroup(UUID groupId);
}
