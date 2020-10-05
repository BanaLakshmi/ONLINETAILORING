package com.mfrp.onlinetailoring;



import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class HelpRowMapper implements RowMapper<Help>
{

	public Help mapRow(ResultSet rs, int rowNum) throws SQLException {
		Help help=new Help();
		
		help.setIssue(rs.getString(1));
		help.setDescription(rs.getString(2));
		help.setDateOfTicket(rs.getDate(3));
		
		return help;
	}

}
