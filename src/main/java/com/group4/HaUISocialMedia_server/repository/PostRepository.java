package com.group4.HaUISocialMedia_server.repository;

import com.group4.HaUISocialMedia_server.dto.MessageDto;
import com.group4.HaUISocialMedia_server.dto.PostDto;
import com.group4.HaUISocialMedia_server.entity.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {
//    @Query(value = "select new com.group4.HaUISocialMedia_server.dto.PostDto(p) from Post p where p.room.id = ?1 and m.sendDate < ?2 order by m.sendDate desc ")
//    List<PostDto> findNext5PostFromPostId(UUID postId, Date sendDate, Pageable pageable);
}
