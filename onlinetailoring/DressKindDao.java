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
	public int updateDressKind(DressKind dressKind) {
		String sql="update DressKindMaster set dressKind= ? where dressKindId=?";
		int result = jdbcTemplate.update(sql,dressKind.getDressKind(),dressKind.getDressKindId());
		return result ;
		
	}
	public int deleteDressKind(int dressKindId) {
		String sql="delete from DressKindMaster where dressKindId=?";
		int result = jdbcTemplate.update(sql,dressKindId);
		return result ;

}
