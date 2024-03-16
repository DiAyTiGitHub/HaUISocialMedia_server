package org.example.service;

import org.example.entity.Role;
import org.example.entity.User;

public interface IUserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addToUser(String username, String rolename);
}
