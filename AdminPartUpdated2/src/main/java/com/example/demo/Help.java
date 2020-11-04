package com.example.demo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Help {
	@Id
	@Column(name = "requestId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int requestId;

	private String issue;
	private String description;
	private Date dateOfTicket;
	private String resolution;
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public Help() {
		super();
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateOfTicket() {
		return dateOfTicket;
	}

	public void setDateOfTicket(Date dateOfTicket) {
		this.dateOfTicket = dateOfTicket;
	}

	public Help(int requestId, String issue, String description, Date dateOfTicket,String resolution,String userId) {
		super();
		this.requestId = requestId;
		this.issue = issue;
		this.description = description;
		this.dateOfTicket = dateOfTicket;
		this.resolution=resolution;
		this.userId=userId;
	}

	@Override
	public String toString() {
		return "Help [requestId=" + requestId + ", issue=" + issue + ", description=" + description + ", dateOfTicket="
				+ dateOfTicket + ", resolution=" + resolution + ", userId=" + userId + "]";
	}

	
	
	
}