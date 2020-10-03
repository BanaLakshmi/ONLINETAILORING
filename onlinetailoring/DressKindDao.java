package tailoring;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class DressKindDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplte() {
		return jdbcTemplate;
	}

	public void setJdbcTemplte(JdbcTemplate jdbcTempalte) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int createDressKind(DressKind dressKind) {
		String sql = "insert into DressKindMaster values(?,?)";
		int result = jdbcTemplate.update(sql,dressKind.getDressKindId(),dressKind.getDressKind());
		return result;

	}
	public List <DressKind> readDressKind() {
		String sql= "select* from DressKindMaster";
		List<DressKind>dressKind=jdbcTemplate.query(sql, new DressKindRowMapper());
		return dressKind;
		
	}

}
