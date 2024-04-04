package com.group4.HaUISocialMedia_server.service;

import com.group4.HaUISocialMedia_server.dto.BoardRecordDto;
import com.group4.HaUISocialMedia_server.dto.PageResult;
import com.group4.HaUISocialMedia_server.dto.SearchDashboardDto;

import java.util.List;

public interface LeadingDashboardService {
    public PageResult pagingLeadingDashboard(SearchDashboardDto searchObject);
}
