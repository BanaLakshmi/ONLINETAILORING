package com.example.demo;



import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;


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
	public void saveDressCategory(DressCategory dressCategory){  
		ht.save(dressCategory);  
	}  
	//method to update DressCategory
	public void updateDressCategory(DressCategory dressCategory){  
		ht.update(dressCategory);  
	}  
	//method to delete DressCategory  
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
	

}


