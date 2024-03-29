package com.group4.HaUISocialMedia_server.service.impl;

import com.group4.HaUISocialMedia_server.config.JwtTokenProvider;
import com.group4.HaUISocialMedia_server.dto.LoginDto;
import com.group4.HaUISocialMedia_server.dto.UserDto;
import com.group4.HaUISocialMedia_server.entity.Classroom;
import com.group4.HaUISocialMedia_server.entity.Role;
import com.group4.HaUISocialMedia_server.entity.User;
import com.group4.HaUISocialMedia_server.repository.ClassroomRepository;
import com.group4.HaUISocialMedia_server.repository.UserRepository;
import com.group4.HaUISocialMedia_server.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String login(LoginDto loginDto) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(),
                loginDto.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        return token;
    }

    @Override
    public UserDto register(UserDto dto) {
        User existedUser = userRepository.findByUsername(dto.getUsername());
        if (existedUser != null) return null;

        User newUser = new User();

        newUser.setUsername(dto.getUsername());
        newUser.setPassword(passwordEncoder.encode(dto.getPassword()));

        if (dto.getClassroomDto() != null) {
            Classroom studentClass = classroomRepository.findById(dto.getClassroomDto().getId()).orElse(null);
            if (studentClass != null) newUser.setClassroom(studentClass);
        }
        if (dto.getCode() != null) {
            newUser.setCode(dto.getCode());
        }
        if (dto.getFirstName() != null) {
            newUser.setFirstName(dto.getFirstName());
        }
        if (dto.getLastName() != null) {
            newUser.setLastName(dto.getLastName());
        }

        newUser.setRole(Role.USER.name());

        User savedUser = userRepository.save(newUser);
        return new UserDto(savedUser);
    }
}