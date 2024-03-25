package com.group4.HaUISocialMedia_server.repository;

import com.group4.HaUISocialMedia_server.entity.Like;
import com.group4.HaUISocialMedia_server.entity.Relationship;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface RelationshipRepository extends JpaRepository<Relationship, UUID> {
    @Query( "select r from Relationship r where (r.requestSender.id = :currentUserId or r.receiver.id = :currentUserId) and r.state = true")
    List<Relationship> findAllAcceptedRelationship(@Param("currentUserId") UUID currentUserId);

    @Query( "select r from Relationship r where (r.receiver.id = :currentUserId) and r.state = false")
    List<Relationship> findAllPendingRelationship(@Param("currentUserId") UUID currentUserId, Pageable pageable);
}
