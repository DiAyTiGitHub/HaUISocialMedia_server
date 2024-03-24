package com.group4.HaUISocialMedia_server.dto;

import com.group4.HaUISocialMedia_server.entity.Like;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LikeDto {
    private UUID id;
    private Date createDate;
    private UserDto userLike;
    private PostDto likedPost;

    public LikeDto(Like entity) {
        this.id = entity.getId();
        this.createDate = entity.getCreateDate();
        if (entity.getUserLike() != null) {
            this.userLike = new UserDto(entity.getUserLike());
        }
        if (entity.getPost() != null) {
            this.likedPost = new PostDto(entity.getPost());
        }
    }
}
