package javaexam1.tv;

public class Tv {

	public Tv() {	
	}
	
    public Tv(String name, int price, String description) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
	}
    
	private String name;
	private int price;
	private String description;
	
	
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String toString() {
		return name+"\t" + price +"\t"+ description;
		
	}
	
}
