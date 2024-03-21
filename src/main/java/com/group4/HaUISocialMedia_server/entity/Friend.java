package com.group4.HaUISocialMedia_server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_friend")
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column
    private Date lastModifyDate;
    @Column
    private boolean state;


    @OneToOne
    @JoinColumn(name = "roomid")
    private Room rooms;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "requestSenderId")
    private User userRequestSender;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "receiverId")
    private User userReciever;

}
