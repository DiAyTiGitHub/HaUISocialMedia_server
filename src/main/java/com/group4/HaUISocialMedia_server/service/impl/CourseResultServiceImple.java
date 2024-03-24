package com.group4.HaUISocialMedia_server.service.impl;

import com.group4.HaUISocialMedia_server.dto.CourseResultDto;
import com.group4.HaUISocialMedia_server.dto.SearchObject;
import com.group4.HaUISocialMedia_server.dto.UserDto;
import com.group4.HaUISocialMedia_server.entity.CourseResult;
import com.group4.HaUISocialMedia_server.entity.User;
import com.group4.HaUISocialMedia_server.repository.CourseResultRepository;
import com.group4.HaUISocialMedia_server.service.CourseResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CourseResultServiceImple implements CourseResultService {
    @Autowired
    private CourseResultRepository courseResultRepository;
    @Override
    public Set<CourseResultDto> pagingCourseResult(SearchObject searchObject) {
        Set<CourseResultDto> se = new HashSet<>();
        Page<CourseResult> li = courseResultRepository.findAll(PageRequest.of(searchObject.getPageIndex(), searchObject.getPageSize()));
        li.stream().map(CourseResultDto::new).forEach(se::add);
        return se;
    }

    @Override
    public CourseResultDto addOne(CourseResultDto courseResultDto) {
        CourseResult entity = new CourseResult();
        entity.setCode(courseResultDto.getCode());
        entity.setName(courseResultDto.getName());
        entity.setDescription(courseResultDto.getDescription());
        CourseResult responseEntity = courseResultRepository.save(entity);
        return new CourseResultDto(responseEntity);
    }

    @Override
    public CourseResultDto findById(UUID id) {
        CourseResult courseResult = courseResultRepository.findById(id).orElse(null);
        if(courseResult == null)
            return null;
        return new CourseResultDto(courseResult);
    }

    @Override
    public void deleteById(UUID id) {
        CourseResult courseResult = courseResultRepository.findById(id).orElse(null);
        if(courseResult == null) return;
        courseResultRepository.deleteById(id);
    }

    @Override
    public CourseResultDto update(CourseResultDto courseResultDto) {
        CourseResult entity = courseResultRepository.findById(courseResultDto.getId()).orElse(null);
        if(entity == null) return null;
        entity.setCode(courseResultDto.getCode());
        entity.setName(courseResultDto.getName());
        entity.setDescription(courseResultDto.getDescription());

        CourseResult responseEntity = courseResultRepository.save(entity);
        return new CourseResultDto(responseEntity);
    }

    @Override
    public Set<CourseResultDto> getAllCourseResult() {
        List<CourseResult> ds = courseResultRepository.findAll();
        return ds.stream()
                .map(CourseResultDto::new)
                .collect(Collectors.toSet());
    }
}
