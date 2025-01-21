package com.NextGen.NextGenInstitute.controller;

import com.NextGen.NextGenInstitute.Entity.Courses;
import com.NextGen.NextGenInstitute.repository.Courserepository;
import com.NextGen.NextGenInstitute.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "*")
public class CourseController {

    @Autowired
   private CourseService courseService;


    @PostMapping
    public Courses addCourse(@RequestBody Courses courses){
        return courseService.addCourse(courses);
    }

    @GetMapping
    public List<Courses> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Courses> getCourseById(@PathVariable int id){
        return courseService.getCorseById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }

    @PutMapping("/{id}")
    public ResponseEntity<Courses> updateCourse(@PathVariable int id, @RequestBody Courses courses){
        try{
            return ResponseEntity.ok(courseService.updateCourse(id,courses));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable int id){
        courseService.deleteCourse(id);
        return ResponseEntity.ok("Course Deleted Successfully!!");
    }

}
