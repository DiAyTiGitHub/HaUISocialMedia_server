package com.group4.HaUISocialMedia_server.repository;

import com.group4.HaUISocialMedia_server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    public User findByUsername(String username);
}
