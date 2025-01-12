package com.jsp.job_portal.dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;



@Entity

public class JobSeeker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Size(min = 3, max = 30, message = "* Enter between 3~30 charecters")
	private String name;
	@Email(message = "* Enter Proper Email")
	@NotEmpty(message = "* It is Required Field")
	private String email;
	@DecimalMin(value = "6000000000", message = "* Enter Proper Mobile Number")
	@DecimalMax(value = "9999999999", message = "* Enter Proper Mobile Number")
	@NotNull(message = "* It is Required Field")
	private Long mobile;
	@Pattern(regexp = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", message = "* Enter minimum 8 charecter, one uppercase, one lowercase, one number and one special charecter")
	private String password;
	@Transient
	@Pattern(regexp = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", message = "* Enter minimum 8 charecter, one uppercase, one lowercase, one number and one special charecter")
	private String confirmPassword;
	private boolean completed;
	private Boolean verified;
	private Integer otp;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<JobApplication> jobApplications = new ArrayList<>();

	@OneToOne(cascade = CascadeType.ALL)
	Education education;

	@OneToOne(cascade = CascadeType.ALL)
	Experience experience;

	private String resumeUrl;
	private String profilePicUrl;
	
	public JobApplication getApplication(Job job){
		for(JobApplication application : this.jobApplications){
			if(application.getJob().getId() == job.getId()){
				return application;
			}
		}
		return null;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public Boolean getVerified() {
		return verified;
	}
	public void setVerified(Boolean verified) {
		this.verified = verified;
	}
	public Integer getOtp() {
		return otp;
	}
	public void setOtp(Integer otp) {
		this.otp = otp;
	}
	public List<JobApplication> getJobApplications() {
		return jobApplications;
	}
	public void setJobApplications(List<JobApplication> jobApplications) {
		this.jobApplications = jobApplications;
	}
	public Education getEducation() {
		return education;
	}
	public void setEducation(Education education) {
		this.education = education;
	}
	public Experience getExperience() {
		return experience;
	}
	public void setExperience(Experience experience) {
		this.experience = experience;
	}
	public String getResumeUrl() {
		return resumeUrl;
	}
	public void setResumeUrl(String resumeUrl) {
		this.resumeUrl = resumeUrl;
	}
	public String getProfilePicUrl() {
		return profilePicUrl;
	}
	public void setProfilePicUrl(String profilePicUrl) {
		this.profilePicUrl = profilePicUrl;
	}
	
	
}
