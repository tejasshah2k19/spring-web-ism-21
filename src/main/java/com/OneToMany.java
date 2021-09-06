package com;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.onetomany.CustomerEntity;
import com.entity.onetomany.OrderEntity;

public class OneToMany {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		CustomerEntity ram = new CustomerEntity();
		ram.setFirstName("ram");

		CustomerEntity sita = new CustomerEntity();
		sita.setFirstName("sita");

		CustomerEntity balaram = new CustomerEntity();
		balaram.setFirstName("balaram");

		OrderEntity o1 = new OrderEntity();
		o1.setTitle("ram1");
		o1.setTotalAmount(5000);

		OrderEntity o2 = new OrderEntity();
		o2.setTitle("ram2");
		o2.setTotalAmount(10000);

		List<OrderEntity> ramOrders = new ArrayList<OrderEntity>();
		ramOrders.add(o1);
		ramOrders.add(o2);

		OrderEntity o3 = new OrderEntity();
		o3.setTitle("sita1");
		o3.setTotalAmount(6000);

		OrderEntity o4 = new OrderEntity();
		o4.setTitle("sita2");
		o4.setTotalAmount(8000);

		List<OrderEntity> sitaOrders = new ArrayList<OrderEntity>();
		sitaOrders.add(o3);
		sitaOrders.add(o4);

		ram.setOrders(ramOrders);
		sita.setOrders(sitaOrders);

		Transaction tx = session.beginTransaction();

		try {
			session.save(ram);
			session.save(sita);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}

		session.close();
	}
}
