package com.group4.HaUISocialMedia_server.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PageResult {
    private Integer totalElements;
    private List<? extends Object> data;
    private Integer pageIndex;
    private Integer pageSize;

}

