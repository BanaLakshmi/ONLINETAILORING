package tailoring;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DressKindRowMapper implements RowMapper<DressKind>
{
	public DressKind mapRow(ResultSet rs, int rowNum)throws SQLException{
		DressKind dressKind= new DressKind();
		dressKind.setDressKindId(rs.getInt(1));
		dressKind.setDressKind(rs.getString(2));
		return dressKind;
		
}
}


