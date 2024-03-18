package com.group4.HaUISocialMedia_server.dto;

import com.group4.HaUISocialMedia_server.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private UUID id;
    private String code;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String address;
    private boolean gender;
    private Date birthDate;
    private String avatar;
    private String role;
    private String phoneNumber;
    private ClassroomDto classroomDto;

    public UserDto(User entity) {
        this.id = entity.getId();
        this.code = entity.getCode();
        this.firstName = entity.getFirstName();
        this.lastName = entity.getLastName();
        this.username = entity.getUsername();
        this.role = entity.getRole().name();
        this.classroomDto = new ClassroomDto(entity.getClassroom());
    }
}
