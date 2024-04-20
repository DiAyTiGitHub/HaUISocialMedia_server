package com.group4.HaUISocialMedia_server.dto;

import com.group4.HaUISocialMedia_server.entity.Group;
import com.group4.HaUISocialMedia_server.entity.User;
import com.group4.HaUISocialMedia_server.entity.UserGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GroupDto {

    private UUID id;
    private String code;
    private String name;
    private String description;
    private String avatar;
    private String backGroundImage;
    private Date createDate;
    private UserDto user;
    private Set<UserGroupDto> users;
    private Set<PostDto> posts;

    public GroupDto(Group entity){
        this.id = entity.getId();
        this.code = entity.getCode();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.avatar = entity.getAvatar();
        this.backGroundImage = entity.getBackGroundImage();
        this.createDate = entity.getCreateDate();
        if(entity.getUser() != null)
            this.user = new UserDto(entity.getUser());
    }
}
