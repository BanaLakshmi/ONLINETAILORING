package tailoring;

public class DressType {
	private int dressTypeId;
	private String dressType ;
	private String dressCategory;
	private String dressKind;
	private String pattern ;
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
	public String getDressCategory() {
		return dressCategory;
	}
	public void setDressCategory(String dressCategory) {
		this.dressCategory = dressCategory;
	}
	public String getDressKind() {
		return dressKind;
	}
	public void setDressKind(String dressKind) {
		this.dressKind = dressKind;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public DressType() {
		super();
	}
	public DressType(int dressTypeId, String dressType, String dressCategory, String dressKind, String pattern) {
		super();
		this.dressTypeId = dressTypeId;
		this.dressType = dressType;
		this.dressCategory = dressCategory;
		this.dressKind = dressKind;
		this.pattern = pattern;
	}
	
	
}
