package com.group4.HaUISocialMedia_server.service.impl;

import com.group4.HaUISocialMedia_server.dto.LikeDto;
import com.group4.HaUISocialMedia_server.dto.NotificationDto;
import com.group4.HaUISocialMedia_server.dto.NotificationTypeDto;
import com.group4.HaUISocialMedia_server.entity.*;
import com.group4.HaUISocialMedia_server.repository.LikeRepository;
import com.group4.HaUISocialMedia_server.repository.PostRepository;
import com.group4.HaUISocialMedia_server.service.LikeService;
import com.group4.HaUISocialMedia_server.service.NotificationService;
import com.group4.HaUISocialMedia_server.service.NotificationTypeService;
import com.group4.HaUISocialMedia_server.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.*;

@Service
public class LikeServiceImpl implements LikeService {
    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private NotificationTypeService notificationTypeService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Override
    @Transactional
    public LikeDto likeAPost(UUID postId) {

        User user = userService.getCurrentLoginUserEntity();
        Post post = postRepository.getById(postId);

        Like like = new Like();
        like.setCreateDate(new Date());
        like.setUserLike(user);
        like.setPost(post);

        //Get the recipient notification
        User receiverUser = post.getOwner();
        NotificationType notificationType = notificationTypeService.getNotificationTypeEntityByName("Post");

        Notification notification = new Notification();
        notification.setCreateDate(new Date());
        notification.setContent(user.getUsername() + " đã thích một bài viết của bạn");
        notification.setActor(user);
        notification.setReferenceId(postId);
        notification.setOwner(receiverUser);
        notification.setNotificationType(notificationType);

        NotificationDto noti = notificationService.save(new NotificationDto(notification));
        //send this noti via socket (do later)
        simpMessagingTemplate.convertAndSendToUser(user.getId().toString(), "/notification", noti);

        return new LikeDto(likeRepository.save(like));
    }

    @Override
    public Set<LikeDto> getListLikesOfPost(UUID postId) {
        Set<LikeDto> res = new HashSet<>();
        List<Like> li = likeRepository.findByPost(postId);
        li.stream().map(LikeDto::new).forEach(res::add);
        return res;
    }

    @Override
    @Transactional
    public void dislikeAPost(UUID postId) {
        User user = userService.getCurrentLoginUserEntity();
        likeRepository.deleteByIdPost(postId, user.getId());
    }
}
