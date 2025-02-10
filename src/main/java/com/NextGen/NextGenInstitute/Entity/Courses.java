package com.NextGen.NextGenInstitute.Entity;

import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

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

    @Column(nullable = false,columnDefinition = "TEXT")
    private  String shortDescription;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String courseIntro;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String trainingDescription;

   @Lob
    private byte[] image;

    @Column(nullable = false)
    private String imageType;

    @Column(nullable = false)
    private  String imageName;

    @Column(nullable = false)
    private String duration;

    @Column(nullable = false)
    private int enrolled;

    @Column(nullable = false)
    private double rating;

    @Column(nullable = false)
    private String mode;

    @Column(nullable = false)
    private String language;

    @Column(nullable = false)
    private int modules;

    @Column(nullable = false)
    private int quizzes;

    @Column(nullable = false)
    private int projects;

    @ElementCollection
    private List<String> certifications;

    @ElementCollection
    private List<String> eligibility;

    @ElementCollection
    private List<String> achievements;

    @ElementCollection
    private List<String> courseOverview;

    @ElementCollection
    private List<String> keyHighlights;


    // Getter Setter:


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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getCourseIntro() {
        return courseIntro;
    }

    public void setCourseIntro(String courseIntro) {
        this.courseIntro = courseIntro;
    }

    public String getTrainingDescription() {
        return trainingDescription;
    }

    public void setTrainingDescription(String trainingDescription) {
        this.trainingDescription = trainingDescription;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(int enrolled) {
        this.enrolled = enrolled;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getModules() {
        return modules;
    }

    public void setModules(int modules) {
        this.modules = modules;
    }

    public int getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(int quizzes) {
        this.quizzes = quizzes;
    }

    public int getProjects() {
        return projects;
    }

    public void setProjects(int projects) {
        this.projects = projects;
    }

    public List<String> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<String> certifications) {
        this.certifications = certifications;
    }

    public List<String> getEligibility() {
        return eligibility;
    }

    public void setEligibility(List<String> eligibility) {
        this.eligibility = eligibility;
    }

    public List<String> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<String> achievements) {
        this.achievements = achievements;
    }

    public List<String> getCourseOverview() {
        return courseOverview;
    }

    public void setCourseOverview(List<String> courseOverview) {
        this.courseOverview = courseOverview;
    }

    public List<String> getKeyHighlights() {
        return keyHighlights;
    }

    public void setKeyHighlights(List<String> keyHighlights) {
        this.keyHighlights = keyHighlights;
    }
}
