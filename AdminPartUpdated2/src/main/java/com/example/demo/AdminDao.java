package com.example.demo;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component("Adao")
public class AdminDao {
	HibernateTemplate ht;

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
	
	@Transactional
	public Admin create(Admin admin)
	{
		ht.save(admin);
		return admin;
	}
	public List<Admin> read()
	{
		return ht.loadAll(Admin.class);
	}
	
	public Admin read(String adminId)
	{
		return ht.get(Admin.class, adminId);
	}
	
	@Transactional
	public void update(Admin admin) {
		ht.update(admin);
	}
	
	@Transactional
	public void delete(Admin admin)
	{
		ht.delete(admin);
	}

	
	
}
