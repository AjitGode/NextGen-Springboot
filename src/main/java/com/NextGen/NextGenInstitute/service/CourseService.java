package com.NextGen.NextGenInstitute.service;

import com.NextGen.NextGenInstitute.Entity.Courses;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface CourseService {
    Courses addCourse(Courses courses, MultipartFile image) throws IOException;

    List<Courses> getAllCourses();

    Optional<Courses> getCourseById(int id);

    Courses updateCourse(int id, Courses courses);

    void deleteCourse(int id);

    Courses updateCourseImage(int id, MultipartFile image) throws IOException;


}
