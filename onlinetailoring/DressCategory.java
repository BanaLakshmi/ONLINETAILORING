package tailoring;

public class DressCategory {
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

}
