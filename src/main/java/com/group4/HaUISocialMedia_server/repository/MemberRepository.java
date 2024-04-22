package com.group4.HaUISocialMedia_server.repository;

import com.group4.HaUISocialMedia_server.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MemberRepository extends JpaRepository<Member, UUID> {

    @Query("SELECT u FROM Member u WHERE u.user.id = :userId and u.group.id = :groupId")
    public Member findUserGroup(@Param("userId")UUID userId, @Param("groupId")UUID groupId);
}
