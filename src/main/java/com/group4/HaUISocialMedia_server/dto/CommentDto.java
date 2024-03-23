package com.group4.HaUISocialMedia_server.dto;

import com.group4.HaUISocialMedia_server.entity.Comment;
import com.group4.HaUISocialMedia_server.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class CommentDto {
    private UUID id;
    private String content;
    private Date createDate;
    private UserDto commenter;
    private CommentDto repliedComment;
    private int numsOfSubComments;

    public CommentDto(Comment entity) {
        this.id = entity.getId();
        this.content = entity.getContent();
        this.createDate = entity.getCreateDate();
        if (entity.getOwner() != null) {
            this.commenter = new UserDto(entity.getOwner());
        }
        if (entity.getRepliedComment() != null) {
            this.repliedComment = new CommentDto(entity.getRepliedComment());
        }
        this.numsOfSubComments = entity.getSubComments().size();
    }
}
