package tailoring;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DressTypeRowMapper implements RowMapper<DressType>
{
	public DressType mapRow(ResultSet rs, int rowNum)throws SQLException{
		DressType dressType= new DressType();
		dressType.setDressTypeId(rs.getInt(1));
		dressType.setDressType(rs.getString(2));
		dressType.setDressCategory(rs.getString(3));
		dressType.setDressKind(rs.getString(4));
		dressType.setPattern(rs.getString(5));
		return dressType;
		
}
}


