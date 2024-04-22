package com.group4.HaUISocialMedia_server.repository;

import com.group4.HaUISocialMedia_server.dto.RelationshipDto;
import com.group4.HaUISocialMedia_server.dto.UserDto;
import com.group4.HaUISocialMedia_server.entity.Relationship;
import com.group4.HaUISocialMedia_server.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    public User findByUsername(String username);

    @Query(value = "SELECT * FROM tbl_user u WHERE u.last_name LIKE %?1% OR u.first_name LIKE %?1% OR u.username LIKE %?1% LIMIT ?2 OFFSET ?3", nativeQuery = true)
    List<User> getByUserName(String keyword, int limit, int offset);

    @Query("select u from User u where u.id in (select r.receiver.id from Relationship r where r.requestSender.id = :currentUserId and r.state = true ) or u.id in (select r.requestSender.id from Relationship r where r.receiver.id = :currentUserId and r.state = true )")
    List<User> findAllCurentFriend(@Param("currentUserId") UUID currentUserId, Pageable pageable);

    @Query("select u from User u " +
            "where u.role like 'USER' " +
            "and " +
            "(" +
            "u.username like %:keyword% " +
            " or u.firstName like %:keyword%" +
            " or u.lastName like %:keyword%" +
            " or u.address like %:keyword%" +
            " or u.code like %:keyword%" +
            " or u.email like %:keyword%" +
            " or u.phoneNumber like %:keyword%" +
            ") " +
            "and u.id != :currentUserId " +
            "and u.id not in (select r.receiver.id from Relationship r where r.requestSender.id = :currentUserId and r.state = true ) " +
            "and u.id not in (select r.requestSender.id from Relationship r where r.receiver.id = :currentUserId and r.state = true ) " +
            "and u.id not in (select r.receiver.id from Relationship r where r.receiver.id = :currentUserId and r.state = false ) " +
            "and u.id not in (select r.receiver.id from Relationship r where r.requestSender.id = :currentUserId and r.state = false )")
    List<User> findNewUsers(@Param("keyword") String keyword, @Param("currentUserId") UUID currentUserId, Pageable pageable);

    @Query(value = "SELECT u.id FROM User u WHERE u.role NOT LIKE 'ADMIN'")
    List<UUID> getAllStudentIds();


}
