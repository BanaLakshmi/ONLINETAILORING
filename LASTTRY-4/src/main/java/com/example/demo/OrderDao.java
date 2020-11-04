package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("orderDao")
public class OrderDao {
	HibernateTemplate ht; 


	public HibernateTemplate getHt() {
		return ht;
	}
	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
	
	@Transactional
	public Order create(Order order)
	{
		ht.save(order);
		return order;
	}
	
	@Transactional
	public void saveOrder(Order  order){  
	                  ht.save(order);  
	} 
	@Transactional
	public void updateOrder(Order order){  
		 ht.update(order);  
	}  
	@Transactional
	public void delete(Order order){  
		 ht.delete(order);  
	}  
	public Order getById(int orderId){  
		return ht.get(Order.class, orderId);
	}  
	public List<Order>  read(){
		return ht.loadAll(Order.class);
	} 
	
}
