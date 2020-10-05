package com.mfrp.onlinetailoring;
import java.sql.ResultSet;
import java.sql.SQLException;
public class AdminRowMapper extends RowMapper<Admin> {
	

	public Admin mapRow(ResultSet rs, int rowNum)throws SQLException{
		Admin admin= new Admin();
		admin.setAdminId(rs.getString(1));
		admin.setPassword(rs.getString(2));
		return admin;

}
}