package com.entity.manytomany;

import java.util.Set;

public class DeveloperEntity {
	int developerId;
	String name;
	
	Set<ProjectEntity> projects;

	public int getDeveloperId() {
		return developerId;
	}

	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<ProjectEntity> getProjects() {
		return projects;
	}

	public void setProjects(Set<ProjectEntity> projects) {
		this.projects = projects;
	}
	
	
	
}
