package tailoring;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DressCategoryRowMapper  implements RowMapper<DressCategory>
{
	public DressCategory mapRow(ResultSet rs, int rowNum)throws SQLException{
		DressCategory dressCategory= new DressCategory();
		dressCategory.setCategoryId(rs.getInt(1));
		dressCategory.setDressCategoery(rs.getString(2));
		return dressCategory;
		
	}

