package com.NextGen.NextGenInstitute.controller;

import com.NextGen.NextGenInstitute.Entity.Courses;
import com.NextGen.NextGenInstitute.service.CourseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "*")
public class CourseController {

    @Autowired
    private CourseService courseService;


    @PostMapping(consumes = {"multipart/form-data"}, produces = "application/json")
    public ResponseEntity<?> addCourse(
            @RequestPart("courses") String coursesJson,
            @RequestPart(value = "image", required = false) MultipartFile image) {

        try {

            ObjectMapper objectMapper = new ObjectMapper();
            Courses courses = objectMapper.readValue(coursesJson, Courses.class);


            Courses savedCourse = courseService.addCourse(courses, image);
            return ResponseEntity.ok(savedCourse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("error", e.getMessage()));
        }
    }


    @GetMapping
    public ResponseEntity<List<Courses>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Courses> getCourseById(@PathVariable int id){
        return courseService.getCourseById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id, @RequestBody Courses courses) {
        try {
            return ResponseEntity.ok(courseService.updateCourse(id, courses));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("error", e.getMessage()));
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok(Collections.singletonMap("message", "Course Deleted Successfully!"));
    }

    @GetMapping("/{courseId}/image")
    public ResponseEntity<byte[]> getCourseImage(@PathVariable int courseId) {
        Courses courses = courseService.getCourseById(courseId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));

        if (courses == null || courses.getImage() == null) {
            return ResponseEntity.notFound().build();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(courses.getImageType())); // Store MIME type in DB
        headers.setContentLength(courses.getImage().length);

        return new ResponseEntity<>(courses.getImage(), headers, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}/image", consumes = {"multipart/form-data"})
    public ResponseEntity<?> updateCourseImage(
            @PathVariable int id,
            @RequestPart("image") MultipartFile image) {
        try {
            Courses updatedCourse = courseService.updateCourseImage(id, image);
            return ResponseEntity.ok(updatedCourse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("error", e.getMessage()));
        }
    }


}
