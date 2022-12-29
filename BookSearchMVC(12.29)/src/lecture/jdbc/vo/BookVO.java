package lecture.jdbc.vo;

public class BookVO {

	private String bisbn;
	private String btitle;
	private String bauthor;
	private int bprice;
	
	private String bdate;
	private int bpage;
	private String bsupplment;
	private String bpublisher;
	
	public BookVO() {
	
	}



	public BookVO(String bdate, int bpage, String bsupplment, String bpublisher) {
		super();
		this.bdate = bdate;
		this.bpage = bpage;
		this.bsupplment = bsupplment;
		this.bpublisher = bpublisher;
	}

	public BookVO(String bisbn, String btitle, String bauthor, int bprice) {
		super();
		this.bisbn = bisbn;
		this.btitle = btitle;
		this.bauthor = bauthor;
		this.bprice = bprice;
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



	public int getBprice() {
		return bprice;
	}



	public void setBprice(int bprice) {
		this.bprice = bprice;
	}



	public String getBdate() {
		return bdate;
	}



	public void setBdate(String bdate) {
		this.bdate = bdate;
	}



	public int getBpage() {
		return bpage;
	}



	public void setBpage(int bpage) {
		this.bpage = bpage;
	}



	public String getBsupplment() {
		return bsupplment;
	}



	public void setBsupplment(String bsupplment) {
		this.bsupplment = bsupplment;
	}



	public String getBpublisher() {
		return bpublisher;
	}



	public void setBpublisher(String bpublisher) {
		this.bpublisher = bpublisher;
	}



	
}
