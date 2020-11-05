package com.example.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
@Component("AcceptedOrderddao")
public class AcceptedOrdersDao {
	HibernateTemplate ht;

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
	
	@Transactional
	public AcceptedOrders create(AcceptedOrders acceptedOrders)
	{
		ht.save(acceptedOrders);
		return acceptedOrders;
	}
	@Transactional
	public int updateTailerStatusAccepted (int orderId,String status)
	{  	System.out.println("the status is"+status );
	System.out.println("\n");
	System.out.println(orderId);
		Session session=ht.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("UPDATE AcceptedOrders a SET a.status=? WHERE a.orderId=?");
		query.setParameter(0, status);
		query.setParameter(1, orderId);
		//Query query=session.createQuery("UPDATE AcceptedOrders SET status=? WHERE orderid=?");
		//query.setParameter(0,status);
		//query.setParameter(1,orderId);
		//query.executeUpdate();
		int no= query.executeUpdate();
		tx.commit();
		return no;
		//session.close();
	}
	
	public List<AcceptedOrders> read()
	{
		return ht.loadAll(AcceptedOrders.class);
	}
	
	public AcceptedOrders read(String acceptedOrdersId)
	{
		return ht.get(AcceptedOrders.class, acceptedOrdersId);
	}
	
	@Transactional
	public void update(AcceptedOrders acceptedOrders) {
		ht.update(acceptedOrders);
	}
	
	@Transactional
	public void delete(AcceptedOrders acceptedOrders)
	{
		ht.delete(acceptedOrders);
	}
	
	public AcceptedOrders getByorderId( int i) {
		Session session = ht.getSessionFactory().openSession();
		Query query = session.createQuery("SELECT a From  AcceptedOrders a WHERE a.orderId=?");
		query.setParameter(0, i);
		List<AcceptedOrders> s = query.list();
		if (s == null || s.size() == 0) {
			return null;
		}
		return s.get(0);
	}

	
	public List<AcceptedOrders> getBytailorId (String tailorId)
	{
		Session session = ht.getSessionFactory().openSession();
		Query query = session.createQuery("SELECT a From  AcceptedOrders a WHERE a.tailorId=?");
		query.setParameter(0, tailorId);
		List<AcceptedOrders> s = query.list();
		return s;
	}
}
