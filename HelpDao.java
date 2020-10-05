package com.mfrp.onlinetailoring;

import java.util.Date;
import java.util.List;

public class HelpDao {
	//String requestId;
	//String issue;
	//String description;
	//Date dateOfTicket;
	private JdbcTemplate jdbcTemplate;
	

	public JdbcTemplate getJdbcTemplte() {
		return jdbcTemplate;
	}

	public void setJdbcTemplte(JdbcTemplate jdbcTempalte) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int createHelp(Help help) {
		String sql = "insert into Help values(?,?,?)";
		int result = jdbcTemplate.update(sql, help.getIssue(),help.getDescription(),help.getDateOfTicket());
		return result;

	}
	public int updateHelp(Help help) {
		String sql="update Help set issue=?,description=?,dateOfTicket=? where requestId=?";
		int result = jdbcTemplate.update(sql,help.getIssue(),help.getDescription(),help.getDateOfTicket(),help.getRequestId());
		return result ;
		
	}
	public List <Help> readHelp() {
		String sql= "select* from Help";
		List<Help>help=jdbcTemplate.query(sql, new HelpRowMapper());
		return help;
		
	}
	public int deleteHelp(int requestId) {
		String sql="delete from AdminMaster where adminId=?";
		int result = jdbcTemplate.update(sql,requestId);
		return result ;

}
}
