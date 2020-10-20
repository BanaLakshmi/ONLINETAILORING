package pojo;


public class DressType {
	private int dressTypeId;
	private String dressType ;
	private int categoryId;
	private int dressKindId;
	private int patternId;
	public int getDressTypeId() {
		return dressTypeId;
	}
	public void setDressTypeId(int dressTypeId) {
		this.dressTypeId = dressTypeId;
	}
	public String getDressType() {
		return dressType;
	}
	public void setDressType(String dressType) {
		this.dressType = dressType;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getDressKindId() {
		return dressKindId;
	}
	public void setDressKindId(int dressKindId) {
		this.dressKindId = dressKindId;
	}
	public int getPatternId() {
		return patternId;
	}
	public void setPatternId(int patternId) {
		this.patternId = patternId;
	}
	public DressType(int dressTypeId, String dressType, int categoryId, int dressKindId, int patternId) {
		super();
		this.dressTypeId = dressTypeId;
		this.dressType = dressType;
		this.categoryId = categoryId;
		this.dressKindId = dressKindId;
		this.patternId = patternId;
	}
	public DressType(String dressType, int categoryId, int dressKindId, int patternId) {
		super();
		this.dressType = dressType;
		this.categoryId = categoryId;
		this.dressKindId = dressKindId;
		this.patternId = patternId;
	}
	public DressType() {
		super();
	}
	
	
	
}
