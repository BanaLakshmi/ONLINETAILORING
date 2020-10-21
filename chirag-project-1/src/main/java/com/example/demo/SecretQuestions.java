package com.example.demo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SecretQuestions")
public class SecretQuestions {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sqId ;
	private String answer1;
	private String answer2;
	private String answer3;
	private int userId;
	public int getSqId() {
		return sqId;
	}
	public void setSqId(int sqId) {
		this.sqId = sqId;
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public String getAnswer3() {
		return answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public SecretQuestions(int sqId, String answer1, String answer2, String answer3, int userId) {
		super();
		this.sqId = sqId;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.userId = userId;
	}
	public SecretQuestions(String answer1, String answer2, String answer3, int userId) {
		super();
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.userId = userId;
	}
	public SecretQuestions() {
		super();
	}
	
	
	

}
