package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String userName;
    private String email;
    private String passWord;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="user_role",
    joinColumns = @JoinColumn(name = "User_Id"),
    inverseJoinColumns = @JoinColumn(name = "Roles_ID"))
    private Set<Role> roles = new HashSet<>();

    public User(Long id, String fullName, String userName, String email, String passWord, Set<Role> roles) {
        this.id = id;
        this.fullName = fullName;
        this.userName = userName;
        this.email = email;
        this.passWord = passWord;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        roles.stream().forEach(i->authorities.add(new SimpleGrantedAuthority(i.getName())));
        return List.of(new SimpleGrantedAuthority(authorities.toString()));
    }

    @Override
    public String getPassword() {
        return passWord;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
