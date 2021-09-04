package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.onetoone.StockDetailEntity;
import com.entity.onetoone.StockEntity;

public class OneToOne {
	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		// stock
		StockEntity stock = new StockEntity();
		stock.setStockName("RIL");
		stock.setSector("Oil-Communication");

		// stockdetail
		StockDetailEntity stockDetail = new StockDetailEntity();
		stockDetail.setPrice(2500);
		stockDetail.setAllTimeHighPrice(5500);
		stockDetail.setAllTimeLowPrice(850);

		stock.setStockDetail(stockDetail);
		stockDetail.setStock(stock);
		
		Transaction tx = session.beginTransaction();

		try {
			session.save(stock);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e.getMessage());
		}
		session.close();

	}
}
