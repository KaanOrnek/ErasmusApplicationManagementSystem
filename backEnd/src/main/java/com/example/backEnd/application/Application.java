package com.example.backEnd.application;

import com.example.backEnd.document.Document;
import com.example.backEnd.university.University;
import com.example.backEnd.student.Student;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Set;

@Entity
@Table(name="application")
@Data
@CrossOrigin
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationID;
    private String applicationStatus;
    @ElementCollection
    private Set<Long> appliedUniversityIds;
    private Long studentId;
    @ElementCollection
    private Set<Long> documentIds;

    public Application( String applicationStatus, Set<Long> appliedUniversityIds, Long studentId, Set<Long> documentIds) {
        this.applicationStatus = applicationStatus;
        this.appliedUniversityIds = appliedUniversityIds;
        this.studentId = studentId;
        this.documentIds = documentIds;
    }

    public Application() {
        this.applicationStatus = null;
        this.appliedUniversityIds = null;
        this.studentId = null;
        this.documentIds = null;
    }

    public Long getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(Long applicationID) {
        this.applicationID = applicationID;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public Set<Long> getAppliedUniversityIds() {
        return appliedUniversityIds;
    }

    public void setAppliedUniversityIds(Set<Long> appliedUniversityIds) {
        this.appliedUniversityIds = appliedUniversityIds;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Set<Long> getDocumentIds() {
        return documentIds;
    }

    public void setDocumentIds(Set<Long> documentIds) {
        this.documentIds = documentIds;
    }
}