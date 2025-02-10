package com.NextGen.NextGenInstitute.service;

import com.NextGen.NextGenInstitute.Entity.Enrollment;
import com.NextGen.NextGenInstitute.repository.Enrollmentrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private Enrollmentrepository enrollmentrepository;

    @Override
    public Enrollment addStudent(Enrollment enrollment) {
        enrollment.setEnrollmentDate(LocalDateTime.now());
        return enrollmentrepository.save(enrollment);
    }

    @Override
    public List<Enrollment> getAllStudent() {
        return enrollmentrepository.findAll();
    }

    @Override
    public Optional<Enrollment> getStudentById(int id) {
        return enrollmentrepository.findById(id);
    }

    @Override
    public Enrollment updateStudent(int id, Enrollment enrollment) {
       Enrollment existingStudent = enrollmentrepository.findById(id).orElse(null);
       if (existingStudent !=null){
           existingStudent.setName(enrollment.getName());
           existingStudent.setEmail(enrollment.getEmail());
           existingStudent.setPhone(enrollment.getPhone());
           existingStudent.setCourseName(enrollment.getCourseName());
           existingStudent.setCity(enrollment.getCity());
           existingStudent.setEducation(enrollment.getEducation());
           existingStudent.setWorkingProfession(enrollment.getWorkingProfession());
           return enrollmentrepository.save(existingStudent);
       }
       throw new RuntimeException("Student not found with Id:"+id);
    }

    public Enrollment updatePaymentStatus(int id, String paymentStatus) {
        Enrollment enrollment = enrollmentrepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found"));
        enrollment.setPaymentStatus(paymentStatus);
        return enrollmentrepository.save(enrollment);
    }

    @Override
    public void deleteStudent(int id) {
      enrollmentrepository.deleteById(id);
    }
}
