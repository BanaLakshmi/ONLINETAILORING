package Dao.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import pojo.DressKind;

public class DressKindDAO {
	HibernateTemplate ht;  


	public HibernateTemplate getHt() {
		return ht;
	}
	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
	//method to save DressKind
	public void saveDressKind(DressKind dressKind){  
		ht.save(dressKind);  
	}  
	//method to update DressKind
	public void updateDressKind(DressKind dressKind){  
		ht.update(dressKind);  
	}  
	//method to delete DressKind 
	public void deleteDressKind(DressKind dressKind){  
		ht.delete(dressKind);  
	}  
	//method to return one DressKind of given id  
	public DressKind getById(int id){  
		DressKind dressKind=(DressKind)ht.get(DressKind.class,id);  
		return dressKind;  
	}  
	//method to return all DressKind
	public List<DressKind> getDressKinds(){  
		List<DressKind> list=new ArrayList<DressKind>();  
		list=ht.loadAll(DressKind.class);  
		return list;  
	}  
	

}
