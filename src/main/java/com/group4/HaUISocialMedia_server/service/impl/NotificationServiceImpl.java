package com.group4.HaUISocialMedia_server.service.impl;

import com.group4.HaUISocialMedia_server.dto.NotificationDto;
import com.group4.HaUISocialMedia_server.dto.SearchObject;
import com.group4.HaUISocialMedia_server.entity.Notification;
import com.group4.HaUISocialMedia_server.entity.User;
import com.group4.HaUISocialMedia_server.repository.NotificationRepository;
import com.group4.HaUISocialMedia_server.repository.NotificationTypeRepository;
import com.group4.HaUISocialMedia_server.repository.UserRepository;
import com.group4.HaUISocialMedia_server.service.NotificationService;
import com.group4.HaUISocialMedia_server.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationTypeRepository notificationTypeRepository;

    @Override
    public Set<NotificationDto> getAllNotifications() {
        User user = userService.getCurrentLoginUserEntity();
        Set<NotificationDto> res = new HashSet<>();
        List<Notification> li = notificationRepository.findAllByUser(user.getId());
        li.stream().map(NotificationDto::new).forEach(res::add);
        return res;
    }

    @Override
    @Transactional
    public NotificationDto save(NotificationDto notificationDto) {
        if (notificationDto == null)
            return null;
        Notification notification = new Notification();
        if (notificationDto.getNotificationType() != null)
            notification.setNotificationType(notificationTypeRepository.findById(notificationDto.getNotificationType().getId()).orElse(null));
        if (notificationDto.getOwner() != null)
            notification.setOwner(userRepository.findById(notificationDto.getOwner().getId()).orElse(null));
        if (notificationDto.getActor() != null)
            notification.setActor(userRepository.findById(notificationDto.getActor().getId()).orElse(null));

        notification.setContent(notificationDto.getContent());
        notification.setCreateDate(notificationDto.getCreateDate());
        return new NotificationDto(notificationRepository.save(notification));
    }

    @Override
    @Transactional
    public NotificationDto update(NotificationDto notificationDto) {
        Notification notification = notificationRepository.findById(notificationDto.getId()).orElse(null);
        if (notification == null)
            return null;
        notification.setContent(notificationDto.getContent());
        notification.setCreateDate(notificationDto.getCreateDate());
        if (notificationDto.getNotificationType() != null)
            notification.setNotificationType(notificationTypeRepository.findById(notificationDto.getNotificationType().getId()).orElse(null));
        if (notificationDto.getOwner() != null)
            notification.setOwner(userRepository.findById(notificationDto.getOwner().getId()).orElse(null));
        return new NotificationDto(notificationRepository.saveAndFlush(notification));
    }

    @Override
    @Transactional
    public Boolean deleteById(UUID id) {
        Notification notification = notificationRepository.findById(id).orElse(null);
        if (notification == null)
            return false;
        notificationRepository.delete(notification);
        return true;
    }

    @Override
    public Set<NotificationDto> getAnyNotification(SearchObject searchObject) {
        Set<NotificationDto> res = new HashSet<>();
        Page<Notification> li = notificationRepository.findAll(PageRequest.of(searchObject.getPageIndex(), searchObject.getPageSize()));
        li.stream().map(NotificationDto::new).forEach(res::add);
        return res;
    }

    @Override
    public Set<NotificationDto> pagingNotification(SearchObject searchObject) {
        User currentUser = userService.getCurrentLoginUserEntity();

        Set<NotificationDto> res = new HashSet<>();
        List<Notification> li = notificationRepository.pagingNotificationByUserId(currentUser.getId(), PageRequest.of(searchObject.getPageIndex(), searchObject.getPageSize()));
        li.stream().map(NotificationDto::new).forEach(res::add);
        return res;
    }

    @Override
    public void deleteNotificationByIdPost(UUID idPost) {
        notificationRepository.deleteNotificationByIdPost(idPost);
    }
}
