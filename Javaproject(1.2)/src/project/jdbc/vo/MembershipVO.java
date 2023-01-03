package project.jdbc.vo;

public class MembershipVO {

	private String mid;
	private String mpw;
	private String mname;
	private String mldate;
	private String mbirth;
	private String mphonenumber;
	private String memail;
	private int mpluspoint;
	private int mminuspoint;
	private int mtotalpoint;
	
	public MembershipVO() {
	}

	public MembershipVO(String mid, String mpw) {
		super();
		this.mid = mid;
		this.mpw = mpw;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpw() {
		return mpw;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMldate() {
		return mldate;
	}

	public void setMldate(String mldate) {
		this.mldate = mldate;
	}

	public String getMbirth() {
		return mbirth;
	}

	public void setMbirth(String mbirth) {
		this.mbirth = mbirth;
	}

	public String getMphonenumber() {
		return mphonenumber;
	}

	public void setMphonenumber(String mphonenumber) {
		this.mphonenumber = mphonenumber;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public int getMpluspoint() {
		return mpluspoint;
	}

	public void setMpluspoint(int mpluspoint) {
		this.mpluspoint = mpluspoint;
	}

	public int getMminuspoint() {
		return mminuspoint;
	}

	public void setMminuspoint(int mminuspoint) {
		this.mminuspoint = mminuspoint;
	}

	public int getMtotalpoint() {
		return mtotalpoint;
	}

	public void setMtotalpoint(int mtotalpoint) {
		this.mtotalpoint = mtotalpoint;
	}

	
	
	
}
