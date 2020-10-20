package Dao.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import pojo.Orders;



public class OrdersDao {
	HibernateTemplate ht;  


public HibernateTemplate getHt() {
	return ht;
}
public void setHt(HibernateTemplate ht) {
	this.ht = ht;
}

public void saveOrders(Orders orders){  
	ht.save(orders);  
}  

public void updateOrders(Orders orders){  
	ht.update(orders);  
}  

public void deleteOrders(Orders orders){  
	ht.delete(orders);  
}  
 
public Orders getById(int id){  
	Orders orders=(Orders)ht.get(Orders.class,id);  
	return orders;  
}  

public List<Orders> getOrders(){  
	List<Orders> list=new ArrayList<Orders>();  
	list=ht.loadAll(Orders.class);  
	return list;  
}  

}
