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
	private Integer orderId;
	private String tailorId;
	private String customerId;
	
	private String status;
	private Date expectedDate;
	
	public Date getExpectedDate() {
		return expectedDate;
	}
	public void setExpectedDate(Date expectedDate) {
		this.expectedDate = expectedDate;
	}
	

	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public int getAcceptedOrdersId() {
		return acceptedOrdersId;
	}
	public void setAcceptedOrdersId(int acceptedOrdersId) {
		this.acceptedOrdersId = acceptedOrdersId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
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
