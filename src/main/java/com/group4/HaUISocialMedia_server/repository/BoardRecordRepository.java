package com.group4.HaUISocialMedia_server.repository;

import com.group4.HaUISocialMedia_server.entity.BoardRecord;
import com.group4.HaUISocialMedia_server.entity.Classroom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface BoardRecordRepository extends JpaRepository<BoardRecord, UUID> {
    @Query("SELECT r from BoardRecord r where r.user.id = :userId")
    public BoardRecord getRecordOfStudent(@Param("userId") UUID userId);

    @Query("SELECT r from BoardRecord r "
            +
            "where r.user.code like %:keyword% or r.user.username like %:keyword% or r.user.firstName like %:keyword% " +
            "order by " +
            "r.numsOfA desc, r.numsOfBPlus desc, r.numsOfB desc, r.numsOfCPlus desc, r.numsOfC desc, r.numsOfDPlus desc, r.numsOfD desc, r.lastModifyDate desc"
    )
    public Page<BoardRecord> getLeadingDashboard(@Param("keyword") String keyword, Pageable pageable);
}
