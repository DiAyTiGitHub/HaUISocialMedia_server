package com.group4.HaUISocialMedia_server.repository;

import com.group4.HaUISocialMedia_server.dto.UserDto;
import com.group4.HaUISocialMedia_server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    public User findByUsername(String username);

    @Query(value = "SELECT * FROM tbl_user u WHERE u.last_name LIKE %?1% OR u.first_name LIKE %?1% OR u.username LIKE %?1% LIMIT ?2 OFFSET ?3", nativeQuery = true)
    List<User> getByUserName(String keyword, int limit, int offset);


}
