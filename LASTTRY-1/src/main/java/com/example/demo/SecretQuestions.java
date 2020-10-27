package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SecretQuestions {
	@Id
	private String userId;
	private String a1;
	private String a2;
	private String a3;
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
	public SecretQuestions(String userId, String a1, String a2, String a3) {
		super();
		this.userId = userId;
		this.a1 = a1;
		this.a2 = a2;
		this.a3 = a3;
	}
	public SecretQuestions() {
		super();
	}
	
	

}
