package com.example.demo;


public class User {

	private String userId;
	private String password;
	public User(String userId, String password, String firstName, String lastName, String dob, String gender,
			String contactNumber, String email, String category) {
		super();
		this.userId = userId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.email = email;
		this.category = category;
	}
	private String firstName;
	private String lastName;
	private String dob;
	private String gender;
	private String contactNumber;
	private String email;
	private String category;
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", dob=" + dob + ", gender=" + gender + ", contactNumber=" + contactNumber + ", email="
				+ email + ", category=" + category + "]";
	}
	
	
	
	
	
	
}
