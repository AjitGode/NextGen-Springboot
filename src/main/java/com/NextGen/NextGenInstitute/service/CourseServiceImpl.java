package com.NextGen.NextGenInstitute.service;

import com.NextGen.NextGenInstitute.Entity.Courses;
import com.NextGen.NextGenInstitute.repository.Courserepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private Courserepository courserepository;

    @Override
    public Courses addCourse(Courses courses, MultipartFile image) throws IOException {
        if (image != null && !image.isEmpty()) { // ✅ Fix: Handle optional images
            courses.setImageName(image.getOriginalFilename());
            courses.setImageType(image.getContentType());
            courses.setImage(image.getBytes());
        }
        return courserepository.save(courses);
    }

    @Override
    public List<Courses> getAllCourses() {
        return courserepository.findAll();
    }

    @Override
    public Optional<Courses> getCourseById(int id) {
        return courserepository.findById(id);
    }

    @Override
    public Courses updateCourse(int id, Courses courses) {
        Courses existingCourse = courserepository.findById(id).orElseThrow(() ->
                new RuntimeException("Course not found with Id: " + id)
        );

        existingCourse.setCourseName(courses.getCourseName());
        existingCourse.setDescription(courses.getDescription());
        existingCourse.setShortDescription(courses.getShortDescription());
        existingCourse.setCourseIntro(courses.getCourseIntro());
        existingCourse.setTrainingDescription(courses.getTrainingDescription());
        existingCourse.setDuration(courses.getDuration());
        existingCourse.setEnrolled(courses.getEnrolled());
        existingCourse.setRating(courses.getRating());
        existingCourse.setMode(courses.getMode());
        existingCourse.setLanguage(courses.getLanguage());
        existingCourse.setModules(courses.getModules());
        existingCourse.setQuizzes(courses.getQuizzes());
        existingCourse.setProjects(courses.getProjects());
        existingCourse.setCertifications(courses.getCertifications());
        existingCourse.setEligibility(courses.getEligibility());
        existingCourse.setAchievements(courses.getAchievements());
        existingCourse.setCourseOverview(courses.getCourseOverview());
        existingCourse.setKeyHighlights(courses.getKeyHighlights());

        return courserepository.save(existingCourse);
    }

    @Override
    public void deleteCourse(int id) {
        courserepository.deleteById(id);
    }

    @Override
    public Courses updateCourseImage(int id, MultipartFile image) throws IOException {
        Courses existingCourse = courserepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with Id: " + id));
        if (image != null && !image.isEmpty()) {
            existingCourse.setImageName(image.getOriginalFilename());
            existingCourse.setImageType(image.getContentType());
            existingCourse.setImage(image.getBytes());
        }
        return courserepository.save(existingCourse);
    }
}
