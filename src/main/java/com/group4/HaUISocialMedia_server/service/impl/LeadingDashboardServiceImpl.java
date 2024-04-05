package com.group4.HaUISocialMedia_server.service.impl;

import com.group4.HaUISocialMedia_server.dto.BoardRecordDto;
import com.group4.HaUISocialMedia_server.dto.PageResult;
import com.group4.HaUISocialMedia_server.dto.SearchDashboardDto;
import com.group4.HaUISocialMedia_server.entity.BoardRecord;
import com.group4.HaUISocialMedia_server.entity.User;
import com.group4.HaUISocialMedia_server.repository.BoardRecordRepository;
import com.group4.HaUISocialMedia_server.repository.UserRepository;
import com.group4.HaUISocialMedia_server.service.LeadingDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class LeadingDashboardServiceImpl implements LeadingDashboardService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BoardRecordRepository boardRecordRepository;

    @Override
    public PageResult pagingLeadingDashboard(SearchDashboardDto searchObject) {
        if (searchObject == null) return null;

        PageResult pageResult = new PageResult();
        pageResult.setPageSize(searchObject.getPageSize());
        pageResult.setPageIndex(searchObject.getPageIndex());
        List<UUID> studentIds = userRepository.getAllStudentIds();
        pageResult.setTotalElements(studentIds.size());
        List<BoardRecord> topDashboard = boardRecordRepository.getLeadingDashboard(searchObject.getKeyWord(),
                PageRequest.of(searchObject.getPageIndex(), searchObject.getPageSize()));
        List<BoardRecordDto> res = new ArrayList<>();

        for (BoardRecord record : topDashboard) {
            res.add(new BoardRecordDto(record));
        }

        return pageResult;
    }
}
