package com.entity.annotation.onetoone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class AddressEntity {

	
	@Id
	@GeneratedValue
	int addressId;
	
	String street;
	String city;
	int pincode;
	
	@OneToOne(targetEntity=EmployeeEntity.class)
	EmployeeEntity employee;
	 //address 
	 //x 1 
	 //y 1 
	


	public int getAddressId() {
		return addressId;
	}


	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public int getPincode() {
		return pincode;
	}


	public void setPincode(int pincode) {
		this.pincode = pincode;
	}


	public EmployeeEntity getEmployee() {
		return employee;
	}


	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}
	
	
}
