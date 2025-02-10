package com.NextGen.NextGenInstitute.controller;

import com.NextGen.NextGenInstitute.Entity.Enrollment;
import com.NextGen.NextGenInstitute.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/enrollment")
@CrossOrigin(origins = "*")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping
    public Enrollment addStudent(@RequestBody Enrollment enrollment){
        return enrollmentService.addStudent(enrollment);
    }

    @GetMapping
    public List<Enrollment> getAllStudent(){
        return enrollmentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enrollment> getStudentById(@PathVariable int id){
        return enrollmentService.getStudentById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }

    @PutMapping("/{id}")
    public  ResponseEntity<Enrollment> updateStudent(@PathVariable int id,@RequestBody Enrollment enrollment){
        try{
            return ResponseEntity.ok(enrollmentService.updateStudent(id,enrollment));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}/payment-status")
    public ResponseEntity<Enrollment> updatePaymentStatus(@PathVariable int id, @RequestBody Map<String, String> payload) {
        String paymentStatus = payload.get("paymentStatus");
        try {
            Enrollment updatedEnrollment = enrollmentService.updatePaymentStatus(id, paymentStatus);
            return ResponseEntity.ok(updatedEnrollment);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        enrollmentService.deleteStudent(id);
        return ResponseEntity.ok("Student Deleted Sucessfully!!!");
    }
}
