package project.jdbc.vo;

import java.util.Date;

public class BookVO {

	private String bisbn;
	private String btitle;
	private String bauthor;
	private String bpublisher;
	
	private String bdate;
	private int bpage;
	private String btranslator;
	private String bborrowable;
	
	private String risbn;
	private String rtitle;
	private String rauthor;
	private String rpublisher;
	private String rid;
	private Date rdate;
	private Date rduedate;
	
	
	public BookVO() {
		
	}

	public BookVO(String risbn, String rtitle, String rauthor, String rpublisher, String rid, Date rdate, Date rduedate) {
		super();
		this.risbn = risbn;
		this.rtitle = rtitle;
		this.rauthor = rauthor;
		this.rpublisher = rpublisher;
		this.rid = rid;
		this.rdate = rdate;
		this.rduedate = rduedate;
		
	}

	public BookVO(Date rduedate) {
		super();
		this.rduedate = rduedate;
	}

	public BookVO(String bisbn, String btitle, String bauthor, String bpublisher, String bdate, int bpage,
			String btranslator) {
		super();
		this.bisbn = bisbn;
		this.btitle = btitle;
		this.bauthor = bauthor;
		this.bpublisher = bpublisher;
		this.bdate = bdate;
		this.bpage = bpage;
		this.btranslator = btranslator;
	}

	public BookVO(String risbn, String rtitle, String rauthor, String rpublisher, Date rduedate) {
		super();
		this.risbn = risbn;
		this.rtitle = rtitle;
		this.rauthor = rauthor;
		this.rpublisher = rpublisher;
		this.rduedate = rduedate;
	}

	
	public BookVO(String bisbn, String btitle, String bauthor, String bpublisher,String bborrowable) {
		super();
		this.bisbn = bisbn;
		this.btitle = btitle;
		this.bauthor = bauthor;
		this.bpublisher = bpublisher;
		this.bborrowable = bborrowable;
	}



	public BookVO(String bdate, Integer bpage, String btranslator) {
		super();
		this.bdate = bdate;
		this.bpage = bpage;
		this.btranslator = btranslator;
	}


	public String getBisbn() {
		return bisbn;
	}

	public void setBisbn(String bisbn) {
		this.bisbn = bisbn;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	public String getBpublisher() {
		return bpublisher;
	}

	public void setBpublisher(String bpublisher) {
		this.bpublisher = bpublisher;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public Integer getBpage() {
		return bpage;
	}

	public void setBpage(int bpage) {
		this.bpage = bpage;
	}

	public String getBtranslator() {
		return btranslator;
	}

	public void setBtranslator(String translator) {
		this.btranslator = translator;
	}
	public String getBborrowable() {
		return bborrowable;
	}

	public void setBborrowable(String bborrowable) {
		this.bborrowable = bborrowable;
	}
	public String getRisbn() {
		return risbn;
	}

	public void setRisbn(String risbn) {
		this.risbn = risbn;
	}

	public String getRtitle() {
		return rtitle;
	}

	public void setRtitle(String rtitle) {
		this.rtitle = rtitle;
	}

	public String getRauthor() {
		return rauthor;
	}

	public void setRauthor(String rauthor) {
		this.rauthor = rauthor;
	}

	public String getRpublisher() {
		return rpublisher;
	}

	public void setRpublisher(String rpublisher) {
		this.rpublisher = rpublisher;
	}
	public Date getRduedate() {
		return rduedate;
	}

	public void setRduedate(Date rduedate) {
		this.rduedate = rduedate;
	}

	
}
