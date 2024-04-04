package com.group4.HaUISocialMedia_server.service.impl;

import com.group4.HaUISocialMedia_server.dto.PageResult;
import com.group4.HaUISocialMedia_server.dto.SearchDashboardDto;
import com.group4.HaUISocialMedia_server.entity.User;
import com.group4.HaUISocialMedia_server.repository.UserRepository;
import com.group4.HaUISocialMedia_server.service.LeadingDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class LeadingDashboardServiceImpl implements LeadingDashboardService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public PageResult pagingLeadingDashboard(SearchDashboardDto searchObject) {
        if (searchObject == null) return null;

        PageResult pageResult = new PageResult();
        pageResult.setPageSize(searchObject.getPageSize());
        pageResult.setPageIndex(searchObject.getPageIndex());
        List<UUID> studentIds = userRepository.getAllStudentIds();
        pageResult.setTotalElements(studentIds.size());

        return pageResult;
    }
}
