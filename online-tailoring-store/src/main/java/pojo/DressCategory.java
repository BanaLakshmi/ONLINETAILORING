package pojo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DressCategoryMaster")
public class DressCategory {
	@Id @GeneratedValue
	private int categoryId ;
	private String dressCategoery ;
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getDressCategoery() {
		return dressCategoery;
	}
	public void setDressCategoery(String dressCategoery) {
		this.dressCategoery = dressCategoery;
	}
	public DressCategory() {
		super();
	}
	public DressCategory(int categoryId, String dressCategoery) {
		super();
		this.categoryId = categoryId;
		this.dressCategoery = dressCategoery;
	}
	public DressCategory(String dressCategoery) {
		super();
		this.dressCategoery = dressCategoery;
	}

}
