package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Tailor {
	@Id
	private int tailorId;
	private String shopName;
	private String address;
	private String contactNo;
	private int workingHours;
	private boolean courier;

	public Tailor() {

	}

	public Tailor(int tailorId, String shopName, String address, String contactNo, int workingHours, boolean courier) {
		super();
		this.tailorId = tailorId;
		this.shopName = shopName;
		this.address = address;
		this.contactNo = contactNo;
		this.workingHours = workingHours;
		this.courier = courier;
	}

	public int getTailorId() {
		return tailorId;
	}

	public void setTailorId(int tailorId) {
		this.tailorId = tailorId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public int getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(int workingHours) {
		this.workingHours = workingHours;
	}

	public boolean isCourier() {
		return courier;
	}

	public void setCourier(boolean courier) {
		this.courier = courier;
	}

	@Override
	public String toString() {
		return "Tailor [tailorId=" + tailorId + ", shopName=" + shopName + ", address=" + address + ", contactNo="
				+ contactNo + ", workingHours=" + workingHours + ", courier=" + courier + "]";
	}

}
