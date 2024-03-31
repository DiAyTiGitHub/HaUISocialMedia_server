package com.group4.HaUISocialMedia_server.repository;

import com.group4.HaUISocialMedia_server.dto.PostDto;
import com.group4.HaUISocialMedia_server.entity.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;


@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {
    @Query(value = "SELECT new com.group4.HaUISocialMedia_server.dto.PostDto(p) FROM Post p WHERE p.owner.id IN :userIds AND p.createDate < :mileStone ORDER BY p.createDate DESC LIMIT :limit OFFSET :offset")
    List<PostDto> findNext5PostFromMileStone(@Param("userIds") List<UUID> userIds, @Param("mileStone") Date mileStone, @Param("limit") int limit, @Param("offset") int offset);
}
