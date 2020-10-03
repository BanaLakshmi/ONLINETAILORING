package tailoring;

public class DressKind {
	private int dressKindId ;
	private String dressKind ;
	public int getDressKindId() {
		return dressKindId;
	}
	public void setDressKindId(int dressKindId) {
		this.dressKindId = dressKindId;
	}
	public String getDressKind() {
		return dressKind;
	}
	public void setDressKind(String dressKind) {
		this.dressKind = dressKind;
	}
	public DressKind() {
		super();
	}
	public DressKind(int dressKindId, String dressKind) {
		super();
		this.dressKindId = dressKindId;
		this.dressKind = dressKind;
	}
}
