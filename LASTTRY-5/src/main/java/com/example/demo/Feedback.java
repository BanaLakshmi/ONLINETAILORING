package com.example.demo;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Feedback")
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feedbackId;
	private Date feedbackDate;
	private String orderId,userId,tailorId;
	private String answer1;
	public String getFeedbackDate1() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(this.feedbackDate);
	}
	public void setFeedbackDate1(String feedbackDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    this.feedbackDate = sdf.parse(feedbackDate);
	}
	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	public Date getFeedbackDate() {
		return feedbackDate;
	}
	public void setFeedbackDate(Date feedbackDate) {
		this.feedbackDate = feedbackDate;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	
	public Feedback(int feedbackId, Date feedbackDate, String orderId, String userId, String tailorId, String answer1) {
		super();
		this.feedbackId = feedbackId;
		this.feedbackDate = feedbackDate;
		this.orderId = orderId;
		this.userId = userId;
		this.tailorId = tailorId;
		this.answer1 = answer1;
	}
	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", feedbackDate=" + feedbackDate + ", orderId=" + orderId
				+ ", userId=" + userId + ", tailorId=" + tailorId + ", answer1=" + answer1 + "]";
	}
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTailorId() {
		return tailorId;
	}
	public void setTailorId(String tailorId) {
		this.tailorId = tailorId;
	}
	
	
	
	
}

