package pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="UserMaster")
public class User {
	@Id @GeneratedValue
	private int userId;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private Date dob;
	private String gender;
	private String contactNo;
	private String email;
	private String userCatgory;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", dob=" + dob + ", gender=" + gender + ", contactNo="
				+ contactNo + ", email=" + email + ", userCatgory=" + userCatgory + "]";
	}
	public User(int userId, String userName, String password, String firstName, String lastName, Date dob,
			String gender, String contactNo, String email, String userCatgory) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.contactNo = contactNo;
		this.email = email;
		this.userCatgory = userCatgory;
	}
	
	

}
