package com.entity.annotation.onetoone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="office")
public class OfficeEntity {

	@Id
	@GeneratedValue
	int officeId;
	
	int urn;
	String address;
	public int getOfficeId() {
		return officeId;
	}
	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}
	public int getUrn() {
		return urn;
	}
	public void setUrn(int urn) {
		this.urn = urn;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
