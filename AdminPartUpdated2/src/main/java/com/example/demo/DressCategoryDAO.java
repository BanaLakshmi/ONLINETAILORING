package com.example.demo;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("Ddao")
public class DressCategoryDAO {
HibernateTemplate ht;

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
	
	@Transactional
	public DressCategory create(DressCategory dressCategory)
	{
		ht.save(dressCategory);
		return dressCategory;
	}
	public List<DressCategory> read()
	{
		return ht.loadAll(DressCategory.class);
	}
	
	public DressCategory read(String categoryId)
	{
		return ht.get(DressCategory.class, categoryId);
	}
	
	@Transactional
	public void update(DressCategory dressCategory) {
		ht.update(dressCategory);
	}
	
	@Transactional
	public void delete(DressCategory dressCategory)
	{
		ht.delete(dressCategory);
	}

	
	
}

