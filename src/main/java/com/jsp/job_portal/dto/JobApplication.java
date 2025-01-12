package com.jsp.job_portal.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime appliedTime;

    private String status = "PENDING";

    @OneToOne
    private Job job;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getAppliedTime() {
        return appliedTime;
    }

    public void setAppliedTime(LocalDateTime appliedTime) {
        this.appliedTime = appliedTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
