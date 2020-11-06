package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="paymentDetails")
public class PaymentDetails {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentDetailsId;
	private Integer orderId,userId;
	public PaymentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaymentDetails(int paymentDetailsId, Integer orderId, Integer userId, String paymentStatus) {
		super();
		this.paymentDetailsId = paymentDetailsId;
		this.orderId = orderId;
		this.userId = userId;
		this.paymentStatus = paymentStatus;
	}
	@Override
	public String toString() {
		return "PaymentDetails [paymentDetailsId=" + paymentDetailsId + ", orderId=" + orderId + ", userId=" + userId
				+ ", paymentStatus=" + paymentStatus + "]";
	}
	public int getPaymentDetailsId() {
		return paymentDetailsId;
	}
	public void setPaymentDetailsId(int paymentDetailsId) {
		this.paymentDetailsId = paymentDetailsId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	private String paymentStatus;

}
