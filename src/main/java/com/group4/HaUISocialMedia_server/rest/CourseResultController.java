package com.group4.HaUISocialMedia_server.rest;

import com.group4.HaUISocialMedia_server.dto.ClassroomDto;
import com.group4.HaUISocialMedia_server.dto.CourseResultDto;
import com.group4.HaUISocialMedia_server.dto.SearchObject;
import com.group4.HaUISocialMedia_server.service.CourseResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/api/courseresult")
public class CourseResultController {
    @Autowired
    private CourseResultService courseResultService;

    @GetMapping("/paging")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<Set<CourseResultDto>> findAllCourseResult(@RequestBody SearchObject searchObject){
        Set<CourseResultDto> li = courseResultService.pagingCourseResult(searchObject);
        if(li.isEmpty()) return new ResponseEntity<>(li, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(li, HttpStatus.OK);
    }

    @PostMapping("/addone")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<CourseResultDto> addOne(@RequestBody CourseResultDto courseResultDto){
        CourseResultDto courseResultDto1 = courseResultService.addOne(courseResultDto);
        if(courseResultDto1 == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(courseResultDto1, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<CourseResultDto> getById(@PathVariable("id") UUID id){
        CourseResultDto courseResultDto = courseResultService.findById(id);
        if(courseResultDto == null) return  new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(courseResultDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") UUID id){
        CourseResultDto courseResultDto = courseResultService.findById(id);
        if(courseResultDto == null) return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PutMapping("/update")
    @CrossOrigin(origins = "http://localhost:5173")
    public  ResponseEntity<CourseResultDto> update(@RequestBody CourseResultDto courseResultDto){
        CourseResultDto courseResultDto1 = courseResultService.update(courseResultDto);
        if(courseResultDto1 == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(courseResultDto1, HttpStatus.OK);
    }

    @GetMapping("/all")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<Set<CourseResultDto>> getAllCourseResult(){
        Set<CourseResultDto> li = courseResultService.getAllCourseResult();
        if(li.isEmpty()) return  new ResponseEntity<>(li, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(li, HttpStatus.OK);
    }

}
