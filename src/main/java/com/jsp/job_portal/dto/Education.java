package com.jsp.job_portal.dto;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String degree;
    private String institution;
    private LocalDate eduStartDate;
    private LocalDate eduEndDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public LocalDate getEduStartDate() {
		return eduStartDate;
	}
	public void setEduStartDate(LocalDate eduStartDate) {
		this.eduStartDate = eduStartDate;
	}
	public LocalDate getEduEndDate() {
		return eduEndDate;
	}
	public void setEduEndDate(LocalDate eduEndDate) {
		this.eduEndDate = eduEndDate;
	}
    
    
}
