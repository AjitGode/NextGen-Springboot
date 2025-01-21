package com.NextGen.NextGenInstitute.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="enrollment")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private  String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String courseName;

    @Column(nullable = false, updatable = false)
    private LocalDateTime enrollmentDate;

    // Getter Setter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDateTime getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDateTime enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
}