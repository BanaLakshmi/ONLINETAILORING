package com.example.demo;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component("tailordao")
public class TailorDao {
	HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	@Transactional
	public void saveTailor(Tailor tailor) {
		ht.save(tailor);
	}

	@Transactional
	public void updateTailor(Tailor tailor) {
		ht.update(tailor);
	}

	@Transactional
	public void deleteTailor(Tailor tailor) {
		ht.delete(tailor);
	}

	public Tailor getById(String id) {
		Tailor tailor = (Tailor) ht.get(Tailor.class, id);
		return tailor;
	}

	public List<Tailor> getTailors() {
		List<Tailor> list = new ArrayList<Tailor>();
		list = ht.loadAll(Tailor.class);
		return list;

	}
	
	

	public List<String> getDeliveryArea(int categoryId,String dressKind ,String dressType ) {
		Session session = ht.getSessionFactory().openSession();
		String queryString = null;
		Query query = null;
			query = session.createSQLQuery(
					"select t.deliveryAddress from tailor_dress td join tailor t on t.tailorId=td.tailorId where td.categoryId=? and td.dressType=? and td.dressKind=?");
		query.setParameter(0, categoryId);
		query.setParameter(1, dressType);
		query.setParameter(2, dressKind);
		List<String> s = query.list();
		if (s == null || s.size() == 0) {
			return null;
		}
		return s;
	}

}
