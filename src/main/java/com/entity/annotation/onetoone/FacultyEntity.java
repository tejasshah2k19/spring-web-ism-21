package com.entity.annotation.onetoone;

import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@Table(name = "faculty")
public class FacultyEntity {

	@Id
	@GeneratedValue
	int facultyId;

	String firstName;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	OfficeEntity office;


	public int getFacultyId() {
		return facultyId;
	}


	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public OfficeEntity getOffice() {
		return office;
	}


	public void setOffice(OfficeEntity office) {
		this.office = office;
	}

}
