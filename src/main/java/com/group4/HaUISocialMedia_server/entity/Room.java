package com.group4.HaUISocialMedia_server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.interfaces.RSAKey;
import java.util.Date;
import java.util.Set;
import java.util.UUID;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column
    private String code;
    @Column(columnDefinition = "longtext")
    private String name;
    @Column(columnDefinition = "longtext")
    private String description;
    @Column
    private Date createDate;
    @Column
    private String avatar;
    @Column
    private String color;

    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;

    @OneToMany(mappedBy = "room", cascade = CascadeType.REMOVE)
    private Set<Message> messages;

//    @OneToMany(mappedBy = "room", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
//    private Set<UserRoom> userRooms;

//    @OneToOne(mappedBy = "room")
//    private Friend relationship;

    @OneToMany(mappedBy = "rooms")
    @JsonIgnore
    private Set<UserRoom> userRoom;

    @OneToOne(mappedBy = "rooms")
    private Friend friend;
}
