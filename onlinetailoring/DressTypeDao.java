package tailoring;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class DressTypeDao {
	private JdbcTemplate jdbcTemplate;

public JdbcTemplate getJdbcTemplte() {
	return jdbcTemplate;
}

public void setJdbcTemplte(JdbcTemplate jdbcTempalte) {
	this.jdbcTemplate = jdbcTemplate;
}

public int createDressType(DressType dressType) {
	String sql = "insert into DressTypeMaster values(?,?,?,?,?)";
	int result = jdbcTemplate.update(sql, dressType.getDressTypeId(),dressType.getDressType(),dressType.getDressCategory(),dressType.getDressKind(),dressType.getPattern());
	return result;

}
public int updateDressType(DressType dressType) {
	String sql="update DressTypeMaster set dressType= ? ,dressCategory=?,dressKind=?,pattern=? where dressTypeId=?";
	int result = jdbcTemplate.update(sql,dressType.getDressType(),dressType.getDressCategory(),dressType.getDressKind(),dressType.getPattern(),dressType.getDressTypeId());
	return result ;
	
}
public List <DressType> readDressType() {
	String sql= "select* from DressTypeMaster";
	List<DressType>dressType=jdbcTemplate.query(sql, new DressTypeRowMapper());
	return dressType;
	
}
public int deleteDressType(int dressTypeId) {
	String sql="delete from DressTypeMaster where dressTypeId=?";
	int result = jdbcTemplate.update(sql,dressTypeId);
	return result ;


}
