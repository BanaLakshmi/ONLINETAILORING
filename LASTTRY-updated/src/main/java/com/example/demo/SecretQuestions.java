package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SecretQuestions {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String sqId;
	private String userId;
	private String a1;
	private String a2;
	private String a3;
	private String email;
	public String getSqId() {
		return sqId;
	}
	public void setSqId(String sqId) {
		this.sqId = sqId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getA1() {
		return a1;
	}
	public void setA1(String a1) {
		this.a1 = a1;
	}
	public String getA2() {
		return a2;
	}
	public void setA2(String a2) {
		this.a2 = a2;
	}
	public String getA3() {
		return a3;
	}
	public void setA3(String a3) {
		this.a3 = a3;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public SecretQuestions(String sqId, String userId, String a1, String a2, String a3, String email) {
		super();
		this.sqId = sqId;
		this.userId = userId;
		this.a1 = a1;
		this.a2 = a2;
		this.a3 = a3;
		this.email = email;
	}
	public SecretQuestions() {
		super();
	}
		
	

}
