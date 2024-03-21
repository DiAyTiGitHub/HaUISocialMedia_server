package com.group4.HaUISocialMedia_server.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_message_type")
public class MessageType {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column
    private String code;
    @Column
    private String name;
    @Column
    private String description;
    @OneToMany(mappedBy = "messageType")
    private Set<Message> messages;
}
