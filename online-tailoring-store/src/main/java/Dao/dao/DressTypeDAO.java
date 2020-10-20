package Dao.dao;


import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import pojo.DressType;

public class DressTypeDAO {
	HibernateTemplate ht;  


	public HibernateTemplate getHt() {
		return ht;
	}
	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
	//method to save DressType
	public void saveDressType(DressType dressType){  
		ht.save(dressType);  
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
	

}
