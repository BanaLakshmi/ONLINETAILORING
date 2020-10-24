package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

	public int create(User user) throws SQLException
	{
		Connection con = ConnectionFactory.getConn();
		PreparedStatement st = con.prepareStatement("INSERT INTO UserMaster VALUES(?,?,?,?,?,?,?,?,?)");
		st.setString(1, user.getUserId());
		st.setString(2, user.getPassword());
		st.setString(3, user.getFirstName());
		st.setString(4, user.getLastName());
		st.setString(5, user.getDob());
		st.setString(6, user.getGender());
		st.setString(7, user.getContactNumber());
		st.setString(8, user.getEmail());
		st.setString(9, user.getCategory());
		int no=st.executeUpdate();
		System.out.println(no+" row(s) affected");
		return no;
	}
	public User read(String userId, String password) throws SQLException		//uid, pwd, if i get a record, then it is success
	{
		Connection con=ConnectionFactory.getConn();
		PreparedStatement st = con.prepareStatement("SELECT * FROM UserMaster WHERE userId=? AND password=?");
		st.setString(1, userId);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();
		User user=null;
		if(rs.next())
			user=new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
		con.close();
		return user;
	}
	
	public int update(String password, String userId) throws SQLException		
	{
		Connection con=ConnectionFactory.getConn();
		PreparedStatement st = con.prepareStatement("UPDATE UserMaster SET password=? WHERE userId=?");
		st.setString(1, password);
		st.setString(2, userId);
		int no = st.executeUpdate();
		return no;
	}
}
