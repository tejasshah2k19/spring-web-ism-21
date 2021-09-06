package com;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.manytomany.DeveloperEntity;
import com.entity.manytomany.ProjectEntity;

public class ManyToMany {

	public static void main(String[] args) {

		new ManyToMany().getDeveloperData();
	}

	void getDeveloperData() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		DeveloperEntity karan = session.get(DeveloperEntity.class, 3);
		System.out.println(karan.getName());
		System.out.println(karan.getProjects());
	}

	void addData() {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		DeveloperEntity karan = new DeveloperEntity();
		DeveloperEntity arjun = new DeveloperEntity();
		DeveloperEntity thakur = new DeveloperEntity();

		ProjectEntity zomato = new ProjectEntity();
		ProjectEntity facebook = new ProjectEntity();
		ProjectEntity amazon = new ProjectEntity();

		// setters for developers
		karan.setName("karan");
		arjun.setName("arjun");
		thakur.setName("thakur");

		// setters for projects
		zomato.setProjectName("zomato");
		facebook.setProjectName("facebook");
		amazon.setProjectName("amazon");

		// create set of projects

		Set<ProjectEntity> karanProjects = new HashSet<ProjectEntity>();
		karanProjects.add(zomato);
		karanProjects.add(facebook);
		karanProjects.add(amazon);

		Set<ProjectEntity> arjunProjects = new HashSet<ProjectEntity>();
		arjunProjects.add(facebook);
		arjunProjects.add(amazon);

		Set<ProjectEntity> thakurProjects = new HashSet<ProjectEntity>();
		thakurProjects.add(zomato);
		thakurProjects.add(amazon);

		// assign projects to developers

		karan.setProjects(karanProjects);
		arjun.setProjects(arjunProjects);
		thakur.setProjects(thakurProjects);

		Transaction tx = session.beginTransaction();

		try {
			session.save(karan);
			session.save(arjun);
			session.save(thakur);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}

	}
}
