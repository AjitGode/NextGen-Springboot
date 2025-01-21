package com.NextGen.NextGenInstitute.service;

import com.NextGen.NextGenInstitute.Entity.Courses;
import com.NextGen.NextGenInstitute.repository.Courserepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private Courserepository courserepository;

    @Override
    public Courses addCourse(Courses courses) {
        return courserepository.save(courses);
    }

    @Override
    public List<Courses> getAllCourses() {
        return courserepository.findAll();
    }

    @Override
    public Optional<Courses> getCorseById(int id) {
        return courserepository.findById(id);
    }

    @Override
    public Courses updateCourse(int id, Courses courses) {
       Courses existingCourse = courserepository.findById(id).orElse(null);
       if (existingCourse !=null){
           existingCourse.setCourseName(courses.getCourseName());
           existingCourse.setDescription(courses.getDescription());
           existingCourse.setDuration(courses.getDuration());
           existingCourse.setPrice(courses.getPrice());
           existingCourse.setMode(courses.getMode());
           existingCourse.setIcon(courses.getIcon());
           return courserepository.save(existingCourse);
       }
        throw new RuntimeException("Course not found with Id:"+id);
    }

    @Override
    public void deleteCourse(int id) {
        courserepository.deleteById(id);
    }
}
