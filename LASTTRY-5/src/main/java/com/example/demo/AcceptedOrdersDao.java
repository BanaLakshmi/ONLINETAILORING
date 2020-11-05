package com.example.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
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
	public List<AcceptedOrders> getByOrderByStatus (String tailorId,String status)
	{
		Session session = ht.getSessionFactory().openSession();
		Query query = session.createQuery("SELECT a From  AcceptedOrders a WHERE a.tailorId=? AND a.status=? ");
		query.setParameter(0, tailorId);
		query.setParameter(1, status);
		List<AcceptedOrders> s = query.list();
		return s;
	}
	public List<AcceptedOrders> getByCustomerOrderByStatus (String customerId,String status)
	{
		Session session = ht.getSessionFactory().openSession();
		Query query = session.createQuery("SELECT a From  AcceptedOrders a WHERE a.customerId=? AND a.status=? ");
		query.setParameter(0, customerId);
		query.setParameter(1, status);
		List<AcceptedOrders> s = query.list();
		return s;
	}
	@Transactional
	public int updatestatus(Integer orderId, String status) 	
	{
		Session session = ht.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("UPDATE AcceptedOrders a SET a.status=? WHERE a.orderId=?");
		query.setParameter(0, status);
		query.setParameter(1, orderId);
		int no= query.executeUpdate();
		tx.commit();
		return no;
	}
}
