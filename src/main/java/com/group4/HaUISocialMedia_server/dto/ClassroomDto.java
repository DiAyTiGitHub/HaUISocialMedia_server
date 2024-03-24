package com.group4.HaUISocialMedia_server.dto;

import com.group4.HaUISocialMedia_server.entity.Classroom;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClassroomDto {
    private UUID id;
    private String code;
    private String name;
    private String description;
    private Set<UserDto> students;

    public ClassroomDto(Classroom entity) {
        this.id = entity.getId();
        this.code = entity.getCode();
        this.name = entity.getName();
        this.description = entity.getDescription();
        if(entity.getStudents() != null && !entity.getStudents().isEmpty()){
            this.students = new HashSet<>();
            entity.getStudents().stream().map(UserDto::new).forEach(this.students::add);
        }
    }

}
