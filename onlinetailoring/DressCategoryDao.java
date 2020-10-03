package tailoring;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class DressCategoryDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplte() {
		return jdbcTemplate;
	}

	public void setJdbcTemplte(JdbcTemplate jdbcTempalte) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int createDressCategory(DressCategory dressCategory) {
		String sql = "insert into DressCategoryMaster values(?,?)";
		int result = jdbcTemplate.update(sql, dressCategory.getCategoryId(), dressCategory.getDressCategoery());
		return result;

	}
	public List <DressCategory> readDressCategory() {
		String sql= "select* from DressCategoryMaster";
		List<DressCategory>dressCategory=jdbcTemplate.query(sql, new DressCategoryRowMapper());
		return dressCategory;
		
	}
	
}
