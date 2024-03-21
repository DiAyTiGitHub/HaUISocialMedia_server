package com.group4.HaUISocialMedia_server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "tbl_user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String code;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private boolean gender;

    @Column(columnDefinition = "longtext")
    private String address;

    private Date birthDate;

    private String phoneNumber;

//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name = "users_roles",
//            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
//    )
//    private Set<Role> roles;

    private String role;


    @ManyToOne
    @JoinColumn(name = "classId")
    private Classroom classroom;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Message> messages;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<UserRoom> userRoom;

    @OneToMany(mappedBy = "userRequestSender")
    @JsonIgnore
    private Set<Friend> userRequest;

    @OneToMany(mappedBy = "userReciever")
    @JsonIgnore
    private Set<Friend> userReciever;
}
