package com.group4.HaUISocialMedia_server.controller;

import com.group4.HaUISocialMedia_server.dto.ClassroomDto;
import com.group4.HaUISocialMedia_server.entity.Classroom;
import com.group4.HaUISocialMedia_server.entity.User;
import com.group4.HaUISocialMedia_server.repository.ClassroomRepository;
import com.group4.HaUISocialMedia_server.service.ClassroomService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/classroom")
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @Autowired
    private ClassroomRepository classroomRepository;


    @GetMapping("/all")
    public ResponseEntity<Set<ClassroomDto>> getAllClassroom(){
        Set<ClassroomDto> li = classroomService.getAllClassroom();
        if(li.isEmpty()) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(li, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ClassroomDto> save(@RequestBody ClassroomDto classroomDto){
        ClassroomDto classroomDto1 = classroomService.save(classroomDto);
        if(classroomDto1 == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(classroomDto1, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ClassroomDto> update(@RequestBody ClassroomDto classroomDto){
        Optional<Classroom> x = classroomRepository.findById(classroomDto.getId());
        ClassroomDto classroomDto1 = new ClassroomDto(x.map(o -> o).orElseThrow());
        if(classroomDto1 == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(classroomDto1, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id")UUID id){
        if(classroomRepository.findById(id) == null) return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        classroomService.deleteById(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/addStudent/{id_cl}/{id_st}")
    public ResponseEntity<Boolean> addStudent(@PathVariable("id_cl") UUID id_cl, @PathVariable("id_st")UUID id_st){
       if(classroomService.addStudent(id_cl, id_st))
           return  new ResponseEntity<>(true, HttpStatus.OK);
       return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }
}
