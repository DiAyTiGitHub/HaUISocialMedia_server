package org.example.service;

import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.Role;
import org.example.entity.User;
import org.example.repository.RoleRepository;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService implements IUserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

//
    @Resource
    private final PasswordEncoder passwordEncoder;
    @Override
    public User saveUser(User user) {
//        user.setPassWord(passwordEncoder.encode(user.getPassword()));
          return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addToUser(String username, String rolename)  {
        User user = userRepository.findByEmail(username);
        Role role = roleRepository.findByName(rolename);
        user.getRoles().add(role);
    }
}
