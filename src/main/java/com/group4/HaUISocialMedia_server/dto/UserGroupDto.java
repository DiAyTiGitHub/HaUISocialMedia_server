package com.group4.HaUISocialMedia_server.dto;

import com.group4.HaUISocialMedia_server.entity.Group;
import com.group4.HaUISocialMedia_server.entity.User;
import com.group4.HaUISocialMedia_server.entity.UserGroup;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserGroupDto {

    private UUID id;
    private Date joinDate;
    private String role;
    private boolean isApproved;
    private UserDto user;
    private GroupDto group;

    public UserGroupDto(UserGroup entity){
        this.id = entity.getId();
        this.joinDate = entity.getJoinDate();
        this.role = entity.getRole();
        this.isApproved = entity.isApproved();
        if(entity.getUser() != null)
            this.user = new UserDto(entity.getUser());
        if(entity.getGroup() != null)
            this.group = new GroupDto(entity.getGroup());
    }
}
