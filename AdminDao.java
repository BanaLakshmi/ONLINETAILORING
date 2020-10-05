package com.mfrp.onlinetailoring;
import java.util.List;

public class AdminDao {
	private JdbcTemplate jdbcTemplate;
	//private String adminId;
	//private String password;
	

	public JdbcTemplate getJdbcTemplte() {
		return jdbcTemplate;
	}

	public void setJdbcTemplte(JdbcTemplate jdbcTempalte) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int createAdmin(Admin admin) {
		String sql = "insert into AdminMaster values(?,?)";
		int result = jdbcTemplate.update(sql, admin.getAdminId(),admin.getPassword());
		return result;

	}
	public int updateAdmin(Admin admin) {
		String sql="update AdminMaster set password= ?  where adminId=?";
		int result = jdbcTemplate.update(sql,admin.getPassword(),admin.getAdminId());
		return result ;
		
	}
	public List <Admin> readAdmin() {
		String sql= "select* from AdminMaster";
		List<Admin>dressType=jdbcTemplate.query(sql, new AdminRowMapper());
		return dressType;
		
	}
	public int deleteAdmin(int adminId) {
		String sql="delete from AdminMaster where adminId=?";
		int result = jdbcTemplate.update(sql,adminId);
		return result ;


	}


