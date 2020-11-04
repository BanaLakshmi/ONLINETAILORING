package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FeedbackQuestion")
public class FeedbackQuestion {
	@Id
	@Column(name = "questionId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int questionId;
	private String question;

	public FeedbackQuestion(int questionId, String question) {
		super();
		this.questionId = questionId;
		this.question = question;
	}

	public FeedbackQuestion() {
		// TODO Auto-generated constructor stub
		
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "FeedbackQuestion [questionId=" + questionId + ", question=" + question + "]";
	}
	
	
}
