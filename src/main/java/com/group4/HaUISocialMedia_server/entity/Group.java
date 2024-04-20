package com.group4.HaUISocialMedia_server.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbl_group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "VARCHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "longtext")
    private String description;

    @Column(columnDefinition = "longtext")
    private String avatar;

    @Column(columnDefinition = "longtext")
    private String backGroundImage;

    @Column
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User creator;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private Set<UserGroup> users;

}
