package com.example.demo;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component("Dkdao")
public class DressKindDAO {
	
	HibernateTemplate ht;

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
	
	@Transactional
	public DressKind create(DressKind dressKind)
	{
		ht.save(dressKind);
		return dressKind;
	}
	public List<DressKind> read()
	{
		return ht.loadAll(DressKind.class);
	}
	
	public DressKind read(String kindId)
	{
		return ht.get(DressKind.class, kindId);
	}
	
	@Transactional
	public void update(DressKind dressKind) {
		ht.update(dressKind);
	}
	
	@Transactional
	public void delete(DressKind dressKind)
	{
		ht.delete(dressKind);
	}

	
	
}

