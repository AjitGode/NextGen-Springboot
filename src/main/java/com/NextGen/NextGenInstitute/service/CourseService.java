package com.NextGen.NextGenInstitute.service;

import com.NextGen.NextGenInstitute.Entity.Courses;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Courses addCourse(Courses courses);

    List<Courses> getAllCourses();

    Optional<Courses> getCorseById(int id);

    Courses updateCourse(int id, Courses courses);

    void deleteCourse(int id);

}
