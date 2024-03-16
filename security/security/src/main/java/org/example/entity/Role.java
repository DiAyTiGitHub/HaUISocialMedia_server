package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "roles")
public class Role {
    @Id
//    @SequenceGenerator(name = "roles_sequence",
//    sequenceName = "roles_sequence",
//    allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.AUTO,
//    generator = "roles_sequence")

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "roles")
   // @Fetch(value = FetchMode.SELECT)
    @JsonIgnore
    private Set<User> users = new HashSet<>();

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
