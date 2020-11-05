package com.example.demo;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component("dCdao")
public class DressCategoryDAO {
	HibernateTemplate ht;  


	public HibernateTemplate getHt() {
		return ht;
	}
	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
	//method to save DressCategory
	@Transactional
	public DressCategory saveDressCategory(DressCategory dressCategory){  
		ht.save(dressCategory);
		return dressCategory;  
	}  
	//method to update DressCategory
	@Transactional
	public void updateDressCategory(DressCategory dressCategory){  
		ht.update(dressCategory);  
	}  
	//method to delete DressCategory  
	@Transactional
	public void deleteDressCategory(DressCategory dressCategory){  
		ht.delete(dressCategory);  
	}  
	//method to return one DressCategory of given id  
	public DressCategory getById(int id){  
		DressCategory dressCategory=(DressCategory)ht.get(DressCategory.class,id);  
		return dressCategory;  
	}  
	//method to return all DressCategory
	public List<DressCategory> getDressCategories(){  
		List<DressCategory> list=new ArrayList<DressCategory>();  
		list=ht.loadAll(DressCategory.class);  
		return list;  
	} 
	public DressCategory getBydressCategoery(String dressCategoery ) {
		Session session = ht.getSessionFactory().openSession();
		Query query = session.createQuery("SELECT c From  DressCategory c WHERE c.dressCategoery=? ");
		query.setParameter(0, dressCategoery);
		List<DressCategory> s = query.list();
		if (s == null || s.size() == 0) {
			return null;
		}
		return s.get(0);
	}
	

}


