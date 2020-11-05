package com.example.demo;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Tailor {
	@Id
	private String tailorId;
	private String shopName;
	private String address;
	private String contactNo;
	private int workingHours;
	private boolean courier;
	private String deliveryAddress;
	
	

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Tailor() {

	}

	public Tailor(String tailorId, String shopName, String address, String contactNo, int workingHours, boolean courier) {
		super();
		this.tailorId = tailorId;
		this.shopName = shopName;
		this.address = address;
		this.contactNo = contactNo;
		this.workingHours = workingHours;
		this.courier = courier;
	}

	public String getTailorId() {
		return tailorId;
	}

	public void setTailorId(String tailorId) {
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
