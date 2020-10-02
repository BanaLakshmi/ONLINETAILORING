import java.sql.Date;

public class resolution {
	private int resolutionId;
	private int requestId;
	private Date resolutionDate;
	private String adminId;
	private String resolution;

	public int getResolutionId() {
		return resolutionId;
	}

	public void setResolutionId(int resolutionId) {
		this.resolutionId = resolutionId;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public Date getResolutionDate() {
		return resolutionDate;
	}

	public void setResolutionDate(Date resolutionDate) {
		this.resolutionDate = resolutionDate;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public resolution() {
		super();
	}

	public resolution(int resolutionId, int requestId, Date resolutionDate, String adminId, String resolution) {
		super();
		this.resolutionId = resolutionId;
		this.requestId = requestId;
		this.resolutionDate = resolutionDate;
		this.adminId = adminId;
		this.resolution = resolution;
	}

}