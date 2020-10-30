package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
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
	@Transactional
	public int updatePassword(String password, String userId) 	
	{
		Session session = ht.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("UPDATE Users u SET u.password=? WHERE u.userId=?");
		query.setParameter(0, password);
		query.setParameter(1, userId);
		int no= query.executeUpdate();
		tx.commit();
		return no;
	}
//	public int update(String password, String userId) throws SQLException		
//	{
//		Connection con=ConnectionFactory.getConn();
//		PreparedStatement st = con.prepareStatement("UPDATE UserMaster SET password=? WHERE userId=?");
//		st.setString(1, password);
//		st.setString(2, userId);
//		int no = st.executeUpdate();
//		return no;
//	}
//	public SecretQuestions  read (String userId,String a1,String a2,String a3)
//	{
//		Session session = ht.getSessionFactory().openSession();
//		Query query = session.createQuery("SELECT q From  SecretQuestions q WHERE q.userId=? AND q.a1=? AND q.a2=? AND q.a3=?");
//		query.setParameter(0, userId);
//		query.setParameter(1, a1);
//		query.setParameter(2, a2);
//		query.setParameter(3, a3);
//		List<SecretQuestions>  s = query.list();
//		if(s==null && s.size()==0) {
//			return null;
//		}
//	return s.get(0);
//	}
//	
	
	
	
}
