package com.example.demo;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component("dTdao")
public class DressTypeDAO {
	HibernateTemplate ht;  


	public HibernateTemplate getHt() {
		return ht;
	}
	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
	//method to save DressType
	public DressType saveDressType(DressType dressType){  
		ht.save(dressType);
		return dressType;  
	}  
	//method to update DressType
	public void updateDressType(DressType dressType){  
		ht.update(dressType);  
	}  
	//method to delete DressType 
	public void deleteDressType(DressType dressType){  
		ht.delete(dressType);  
	}  
	//method to return one DressType of given id  
	public DressType getById(int id){  
		DressType dressType=(DressType)ht.get(DressType.class,id);  
		return dressType;  
	}  
	//method to return all DressType
	public List<DressType> getDressTypes(){  
		List<DressType> list=new ArrayList<DressType>();  
		list=ht.loadAll(DressType.class);  
		return list;  
	}  
	
//	public List<DressType> getDressKind(int categoryId) {
//		Session session = ht.getSessionFactory().openSession();
//		Query query = session.createQuery("SELECT dt.dressKind From  DressType dt WHERE dt.categoryId=?");
//		query.setParameter(0, categoryId);
//		List<DressType>  dT = query.list();
//		if(dT==null || dT.size()==0) {
//			return null;
//		}
//	return dT;
		
		
		
	
	public List<String> getDressKindByCategoryId(int categoryId)
	{
			Session session = ht.getSessionFactory().openSession();
			Query query = session.createQuery("SELECT dt.dressKind From  DressType dt WHERE dt.categoryId=?");
			query.setParameter(0, categoryId);
			return query.list();
	}
	public List<String> getDressTypeByDressKindNCategory(String dressKind,int categoryId)
	{
			Session session = ht.getSessionFactory().openSession();
			Query query = session.createQuery("SELECT dt.dressType From  DressType dt WHERE dt.dressKind=? and dt.categoryId=?");
			query.setParameter(0,dressKind);
			query.setParameter(1,categoryId);
			return query.list();
	}
	public DressType getBydressType(String dressKind,String dressType ) {
		Session session = ht.getSessionFactory().openSession();
		Query query = session.createQuery("SELECT t From  DressType t WHERE t.dressKind=? AND t.dressType=? ");
		query.setParameter(0, dressKind);
		query.setParameter(1, dressType);
		List<DressType> s = query.list();
		if (s == null || s.size() == 0) {
			return null;
		}
		return s.get(0);
	}
	

}
