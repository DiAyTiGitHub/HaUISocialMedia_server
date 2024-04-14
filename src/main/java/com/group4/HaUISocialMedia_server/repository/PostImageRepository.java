package com.group4.HaUISocialMedia_server.repository;

import com.group4.HaUISocialMedia_server.entity.PostImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostImageRepository extends JpaRepository<PostImage, UUID> {

    @Query("SELECT i FROM PostImage i WHERE i.post.id = :idPost")
    public List<PostImage> pagingSortImage(@Param("idPost")UUID idPost);
}
