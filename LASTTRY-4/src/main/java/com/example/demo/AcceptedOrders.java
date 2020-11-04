package com.example.demo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AcceptedOrders {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int acceptedOrdersId;
	private int orderId;
	private String tailorId;
	private String status;
	private Date expectedDate;
	
	public Date getExpectedDate() {
		return expectedDate;
	}
	public void setExpectedDate(Date expectedDate) {
		this.expectedDate = expectedDate;
	}
	public int getAcceptedOrdersId() {
		return acceptedOrdersId;
	}
	public void setAcceptedOrdersId(int acceptedOrdersId) {
		this.acceptedOrdersId = acceptedOrdersId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getTailorId() {
		return tailorId;
	}
	public void setTailorId(String tailorId) {
		this.tailorId = tailorId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public AcceptedOrders() {
		super();
	}
	
	

}
