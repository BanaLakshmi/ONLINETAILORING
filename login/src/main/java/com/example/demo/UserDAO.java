package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

	public int create(User user) throws SQLException
	{
		Connection con = ConnectionFactory.getConn();
		PreparedStatement st = con.prepareStatement("INSERT INTO UserMaster VALUES(?,?,?,?,?,?,?,?,?,?)");
		st.setString(1, user.getUserId());
		st.setString(2, user.getUserName());
		st.setString(3, user.getPassword());
		st.setString(4, user.getFirstName());
		st.setString(5, user.getLastName());
		st.setString(6, user.getDob());
		st.setString(7, user.getGender());
		st.setString(8, user.getContactNumber());
		st.setString(9, user.getEmail());
		st.setString(10, user.getUserCategory());
		int no=st.executeUpdate();
		System.out.println(no+" row(s) affected");
		return no;
	}
	public User read(String userName, String password) throws SQLException		//uname, pwd, if i get a record, then it is success
	{
		Connection con=ConnectionFactory.getConn();
		PreparedStatement st = con.prepareStatement("SELECT * FROM UserMaster WHERE userName=? AND password=?");
		st.setString(1, userName);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();
		User user=null;
		if(rs.next())
			user=new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),rs.getString(10));
		con.close();
		return user;
	}
	
	public int update(String password, String userName) throws SQLException		
	{
		Connection con=ConnectionFactory.getConn();
		PreparedStatement st = con.prepareStatement("UPDATE UserMaster SET password=? WHERE userName=?");
		st.setString(1, password);
		st.setString(2, userName);
		int no = st.executeUpdate();
		return no;
	}
}
