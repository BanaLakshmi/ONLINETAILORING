package tailoring;
import org.springframework.jdbc.core.JdbcTemplate;

public class DressTypeDao {private JdbcTemplate jdbcTemplate;

public JdbcTemplate getJdbcTemplte() {
	return jdbcTemplate;
}

public void setJdbcTemplte(JdbcTemplate jdbcTempalte) {
	this.jdbcTemplate = jdbcTemplate;
}

public int createDressType(DressType dressType) {
	String sql = "insert into DressCategoryMaster values(?,?,?,?,?)";
	int result = jdbcTemplate.update(sql, dressType.getDressTypeId(),dressType.getDressType(),dressType.getDressCategory(),dressType.getDressKind(),dressType.getPattern());
	return result;

}


}
