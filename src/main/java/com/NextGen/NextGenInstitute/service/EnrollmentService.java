package com.NextGen.NextGenInstitute.service;

import com.NextGen.NextGenInstitute.Entity.Enrollment;

import java.util.List;
import java.util.Optional;

public interface EnrollmentService {
    Enrollment addStudent(Enrollment enrollment);

    List<Enrollment> getAllStudent();

    Optional<Enrollment> getStudentById(int id);

    Enrollment updateStudent(int id, Enrollment enrollment);
    Enrollment updatePaymentStatus(int id, String  paymentStatus);

    void deleteStudent(int id);
}
