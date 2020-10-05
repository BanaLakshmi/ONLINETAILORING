package com.mfrp.onlinetailoring;

import java.sql.Date;
import java.util.List;

public class UserDao {
	
	
	

	public JdbcTemplate getJdbcTemplte() {
		return jdbcTemplate;
	}

	public void setJdbcTemplte(JdbcTemplate jdbcTempalte) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int createUser(User user) {
		String sql = "insert into UserMaster values(?,?,?,?,?,?,?,?,?,?)";
		int result = jdbcTemplate.update(sql,user.getUserId(),user.getPassword(),user.getFirstName(),user.getLastName(),user.getDob(),
				user.getGender(),user.getContactNo(),user.getEmail(),user.getUserCatgory(),user.getSecretQuestions());
		return result;

	}
	public int updateUser(User user) {
		String sql="update UserMaster set password=?,firstName=?,lastName=?,dob=?,gender=?,contactNo=?,email=?,userCategory=?,secretQuestions=? where userId=? ";
		int result = jdbcTemplate.update(sql,user.getPassword(),user.getFirstName(),user.getLastName(),user.getDob(),
				user.getGender(),user.getContactNo(),user.getEmail(),user.getUserCatgory(),user.getSecretQuestions(),user.getUserId());
		return result ;
		
	}
	public List <User> readUser() {
		String sql= "select* from UserMaster";
		List<User>user=jdbcTemplate.query(sql, new UserRowMapper());
		return user;
		
	}
	public int deleteUser(int userId) {
		String sql="delete from UserMaster where adminId=?";
		int result = jdbcTemplate.update(sql,userId);
		return result ;

}
}
