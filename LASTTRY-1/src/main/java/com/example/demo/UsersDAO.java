package com.example.demo;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("udao")
public class UsersDAO {

	HibernateTemplate ht;

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
	
	@Transactional
	public Users create(Users users)
	{
		ht.save(users);
		return users;
	}
	public List<Users> read()
	{
		return ht.loadAll(Users.class);
	}
	
	public Users read(String userId)
	{
		return ht.get(Users.class, userId);
	}
	
	@Transactional
	public void update(Users users) {
		ht.update(users);
	}
	
	@Transactional
	public void delete(Users users)
	{
		ht.delete(users);
	}

	
	

	
}
