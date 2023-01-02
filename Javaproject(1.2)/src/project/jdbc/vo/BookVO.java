package project.jdbc.vo;

public class BookVO {

	private String bisbn;
	private String btitle;
	private String bauthor;
	private String bpublisher;
	
	private String bdate;
	private String bpage;
	private String btranslator;
	
	private String rduedate;
	
	public BookVO() {
		
	}

	public BookVO(String bisbn, String btitle, String bauthor, String bpublisher, String bdate, String bpage,
			String btranslator, String rduedate) {
		super();
		this.bisbn = bisbn;
		this.btitle = btitle;
		this.bauthor = bauthor;
		this.bpublisher = bpublisher;
		this.bdate = bdate;
		this.bpage = bpage;
		this.btranslator = btranslator;
        this.rduedate = rduedate;
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

	public String getBpage() {
		return bpage;
	}

	public void setBpage(String bpage) {
		this.bpage = bpage;
	}

	public String getBtranslator() {
		return btranslator;
	}

	public void setBtranslator(String translator) {
		this.btranslator = translator;
	}

	public String getRduedate() {
		return rduedate;
	}

	public void setRduedate(String rduedate) {
		this.rduedate = rduedate;
	}
	
	
}
