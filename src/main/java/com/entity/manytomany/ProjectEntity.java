package com.entity.manytomany;

import java.util.Set;

public class ProjectEntity {

	int projectId;
	String projectName;
	Set<DeveloperEntity> developers;

	public Set<DeveloperEntity> getDevelopers() {
		return developers;
	}

	public void setDevelopers(Set<DeveloperEntity> developers) {
		this.developers = developers;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Override
	public String toString() {
		return this.projectName;
	}
}
