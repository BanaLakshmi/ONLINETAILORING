package com.mfrp.onlinetailoring;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User>
{

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user=new User();
		user.setContactNo(rs.getString(6));
		user.setDob(rs.getDate(4));
		user.setEmail(rs.getString(7));
		user.setFirstName(rs.getString(2));
		user.setGender(rs.getString(5));
		user.setLastName(rs.getString(3));
		user.setPassword(rs.getString(1));
		user.setSecretQuestions(rs.getString(9));
		user.setUserCatgory(rs.getString(8));
		
		
		return user;
	}

}