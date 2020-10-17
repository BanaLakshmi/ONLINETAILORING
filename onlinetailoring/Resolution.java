
import javax.persistence.Entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name="Resolution")
public class Resolution {
	@Id @GeneratedValue
	private int requestId;
	private int resolutionId;
	private Date resolutionDate;
	private String adminId;
	private String resolution;
	
	@Override
	public String toString() {
		return "Resolution [requestId=" + requestId + ", resolutionId=" + resolutionId + ", resolutionDate="
				+ resolutionDate + ", adminId=" + adminId + ", resolution=" + resolution + "]";
	}


	

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
	public String getResolutionDate1() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(this.resolutionDate);
	}
	public void setResolutionDate1(String resolutionDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    this.resolutionDate = sdf.parse(resolutionDate);
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

	public Resolution() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Resolution(int resolutionId, int requestId, Date resolutionDate, String adminId, String resolution) {
		super();
		this.resolutionId = resolutionId;
		this.requestId = requestId;
		this.resolutionDate = resolutionDate;
		this.adminId = adminId;
		this.resolution = resolution;
	}

	

}
