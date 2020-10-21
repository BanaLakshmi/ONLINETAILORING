package com.example.demo;



import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
//@Table(name = "UserMaster")
public class User {
	@Id

	private String userId;
	private String password;
	private String firstName;
	private String lastName;
	private Date dob;
	private String gender;
	private String contactNo;
	private String email;
	private String userCatgory;
	private String secretQuestions;
	
	public User(String userId, String password, String firstName, String lastName, Date dob, String gender,
			String contactNo, String email, String userCatgory, String secretQuestions) {
		super();
		this.userId = userId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.contactNo = contactNo;
		this.email = email;
		this.userCatgory = userCatgory;
		this.secretQuestions = secretQuestions;
	}
	public User() {}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserCatgory() {
		return userCatgory;
	}
	public void setUserCatgory(String userCatgory) {
		this.userCatgory = userCatgory;
	}
	public String getSecretQuestions() {
		return secretQuestions;
	}
	public void setSecretQuestions(String secretQuestions) {
		this.secretQuestions = secretQuestions;
	}
	
}
