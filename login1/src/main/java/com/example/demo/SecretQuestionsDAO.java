package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SecretQuestionsDAO {
	public int create(SecretQuestions secretQuestions) throws SQLException
	{
		Connection con = ConnectionFactory.getConn();
		PreparedStatement st = con.prepareStatement("INSERT INTO SecretQuestions VALUES(?,?,?,?)");
		st.setString(1, secretQuestions.getUserId());
		st.setString(2, secretQuestions.getA1());
		st.setString(3, secretQuestions.getA2());
		st.setString(4, secretQuestions.getA3());
		int no=st.executeUpdate();
		System.out.println(no+" row(s) affected");
		return no;
	}
	
	public SecretQuestions read(String userId, String a1, String a2, String a3) throws SQLException
	{
		Connection con=ConnectionFactory.getConn();
		PreparedStatement st = con.prepareStatement("SELECT * FROM SecretQuestions WHERE userId=?  AND a1=? AND a2=? AND a3=?");
		st.setString(1, userId);
		st.setString(2, a1);
		st.setString(3, a2);
		st.setString(4, a3);
		ResultSet rs = st.executeQuery();
		SecretQuestions  secretQuestions =null;
		if(rs.next())
			secretQuestions =new SecretQuestions (rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
		con.close();
		return secretQuestions ;
	}
}
