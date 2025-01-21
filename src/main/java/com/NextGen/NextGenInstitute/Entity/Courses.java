package com.NextGen.NextGenInstitute.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(nullable = false)
    private String courseName;


    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private String price;

    @Column(nullable = false)
    private String duration;

    @Column(nullable = false)
    private String mode;

    @Column(nullable = false)
    private String icon;


    // Getter Setter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
