package com.group4.HaUISocialMedia_server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.group4.HaUISocialMedia_server.dto.ClassroomDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_class")
public class Classroom implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    private String description;

    @OneToMany(mappedBy = "classroom")
    @JsonIgnore
    private Set<User> students;

    public Classroom(ClassroomDto entity) {
        this.id = entity.getId();
        this.code = entity.getCode();
        this.name = entity.getName();
        this.description = entity.getDescription();
    }

    public void addStudent(User user){
        students.add(user);
    }
}
