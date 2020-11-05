package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
@Component("bGdao")
public class BillGenerationDao {
	HibernateTemplate ht;  


	public HibernateTemplate getHt() {
		return ht;
	}
	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
	//method to save DressCategory
	@Transactional
	public BillGeneration saveBillGeneration(BillGeneration billGeneration){  
		ht.save(billGeneration);
		return billGeneration;  
	}  
	//method to update DressCategory
	@Transactional
	public void updateBillGeneration(BillGeneration billGeneration){  
		ht.update(billGeneration);  
	}  
	//method to delete DressCategory  
	@Transactional
	public void deleteBillGeneration(BillGeneration billGeneration){  
		ht.delete(billGeneration);  
	}  
	//method to return one DressCategory of given id  
	public BillGeneration getById(int id){  
		BillGeneration billGeneration=(BillGeneration)ht.get(BillGeneration.class,id);  
		return billGeneration;  
	}  
	//method to return all DressCategory
	public List<BillGeneration> getBillGeneration(){  
		List<BillGeneration> list=new ArrayList<BillGeneration>();  
		list=ht.loadAll(BillGeneration.class);  
		return list;  
	} 
	public BillGeneration getByorderId( int i) {
		Session session = ht.getSessionFactory().openSession();
		Query query = session.createQuery("SELECT b From  BillGeneration b WHERE b.orderId=?");
		query.setParameter(0, i);
		List<BillGeneration> s = query.list();
		if (s == null || s.size() == 0) {
			return null;
		}
		return s.get(0);
	}
}
