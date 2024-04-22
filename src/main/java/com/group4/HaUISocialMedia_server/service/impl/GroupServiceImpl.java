package com.group4.HaUISocialMedia_server.service.impl;

import com.group4.HaUISocialMedia_server.dto.GroupDto;
import com.group4.HaUISocialMedia_server.dto.MemberDto;
import com.group4.HaUISocialMedia_server.entity.Group;
import com.group4.HaUISocialMedia_server.entity.Role;
import com.group4.HaUISocialMedia_server.entity.User;
import com.group4.HaUISocialMedia_server.entity.Member;
import com.group4.HaUISocialMedia_server.repository.GroupRepository;
import com.group4.HaUISocialMedia_server.repository.MemberRepository;
import com.group4.HaUISocialMedia_server.repository.UserRepository;
import com.group4.HaUISocialMedia_server.service.GroupService;
import com.group4.HaUISocialMedia_server.service.MemberService;
import com.group4.HaUISocialMedia_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public GroupDto createGroup(GroupDto groupDto) {
        if(groupDto == null)
            return null;
        Group newGroup = new Group();
        newGroup.setCreateDate(new Date());
        newGroup.setName(groupDto.getName());
        newGroup.setCode(groupDto.getCode());
        newGroup.setAvatar(groupDto.getAvatar());
        newGroup.setBackGroundImage(groupDto.getBackGroundImage());
        newGroup.setUser(userService.getCurrentLoginUserEntity());
        newGroup.setDescription(groupDto.getDescription());

        Group group = groupRepository.save(newGroup);

        Set<Member> userList = new HashSet<>();
        Member userAdmin = new Member();
        userAdmin.setRole(Role.ADMIN.name());
        userAdmin.setApproved(true);
        userAdmin.setUser(userService.getCurrentLoginUserEntity());
        userAdmin.setGroup(group);
        memberService.createUserGroup(new MemberDto(userAdmin));

        if(groupDto.getUserJoins().isEmpty())
            return null;
        groupDto.getUserJoins().stream().map(x -> {
            User user = userRepository.findById(x.getUser().getId()).orElse(null);
            Member member = new Member();
            member.setGroup(group);
            member.setApproved(true);
            member.setRole(Role.USER.name());
            member.setUser(user);
            member.setJoinDate(new Date());
            MemberDto memberDto = memberService.createUserGroup(new MemberDto(member));
            member.setId(memberDto.getId());
            return member;
        }).forEach(userList::add);

        GroupDto newGroupDto = new GroupDto(group);
        newGroupDto.setUserJoins(userList.stream().map(MemberDto::new).collect(Collectors.toSet()));
        return newGroupDto;
    }

    @Override
    public GroupDto updateGroup(GroupDto groupDto) {
        Group oldGroup = groupRepository.findById(groupDto.getId()).orElse(null);
        if(oldGroup == null)
            return null;
        oldGroup.setName(groupDto.getName());
        oldGroup.setCode(groupDto.getCode());
        oldGroup.setAvatar(groupDto.getAvatar());
        oldGroup.setBackGroundImage(groupDto.getBackGroundImage());
        oldGroup.setDescription(groupDto.getDescription());
        return new GroupDto(groupRepository.saveAndFlush(oldGroup));
    }

    @Override
    public MemberDto joinGroupRequest(UUID groupId) {
        Member newMember = new Member();
        Group group = groupRepository.findById(groupId).orElse(null);
        if(group != null)
            newMember.setGroup(group);
        newMember.setUser(userService.getCurrentLoginUserEntity());
        newMember.setApproved(false);
        newMember.setRole(Role.USER.name());
        return memberService.createUserGroup(new MemberDto(newMember));
    }

    @Override
    public MemberDto approvedJoinGroupRequest(UUID userGroupId) {
        Member userRequest = memberRepository.findById(userGroupId).orElse(null);
        if(userRequest == null)
            return null;
        userRequest.setApproved(true);
        userRequest.setJoinDate(new Date());
        return memberService.createUserGroup(new MemberDto(userRequest));
    }

    @Override
    public boolean cancelJoinGroupRequest(UUID userGroupId) {
        Member userRequest = memberRepository.findById(userGroupId).orElse(null);
        if(userRequest == null)
            return false;
        memberService.deleteUserGroup(userRequest.getId());
        return true;
    }

    @Override
    public boolean leaveGroup(UUID groupId) {
        Member oldMember = memberRepository.findUserGroup(userService.getCurrentLoginUserEntity().getId(), groupId);
        if(oldMember == null)
            return false;
        memberService.deleteUserGroup(oldMember.getId());
        return true;
    }

    @Override
    public boolean deleteGroup(UUID groupId) {
        Group group = groupRepository.findById(groupId).orElse(null);
        if(group == null)
            return false;
        groupRepository.delete(group);
        return true;
    }

    @Override
    public boolean isAdminGroup(UUID groupId) {
        return groupRepository.findAdmin(groupId, userService.getCurrentLoginUserEntity().getId()) != null;
    }
}


