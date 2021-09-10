package com.entity.annotation.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	//@PrimaryKeyJoinColumn // 
	int empId;
	
	//@JoinColumn--> pk or ck 
	
	//@PrimaryKeyJoinColumn 
	
	
	String name;
	
	
	@OneToOne(mappedBy="employee",cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	AddressEntity address;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}
	
	
	
	
}
