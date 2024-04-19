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
        String kw = "";
        if (searchObject.getKeyWord() != null) kw = searchObject.getKeyWord();
        List<BoardRecord> topDashboard = boardRecordRepository.getLeadingDashboard(kw,
                PageRequest.of(searchObject.getPageIndex() - 1, searchObject.getPageSize()));
        List<BoardRecordDto> res = new ArrayList<>();

        for (BoardRecord record : topDashboard) {
            res.add(new BoardRecordDto(record));
        }

        pageResult.setData(res);

        return pageResult;
    }

    @Override
    public BoardRecordDto getDashboardOfStudent(UUID userId) {
        if (userId == null) return null;

        User student = userRepository.findById(userId).orElse(null);
        if (student == null || !student.getRole().equals("USER")) return null;

        BoardRecord record = boardRecordRepository.getRecordOfStudent(userId);

        return new BoardRecordDto(record);
    }
}
