package com.Test4;

public class Circle extends Shape implements Movable {
	
	public Circle () {
		
	}
    public Circle (int radius, int x, int y)	{
    	super(new Point(x,y));
    	this.radius = radius;
    	
    }
	

	private int radius;


	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	
	@Override
	public void move(int x, int y) {
	    Point p = getPoint();
	    p.setX(p.getX() + x + 1);
	    p.setY(p.getY()+ y + 1);
	    setPoint(p);
	}


	@Override
	public double getArea() {
		return Math.round(Math.PI * Math.pow(radius, 2)) ;
	    
	}


	@Override
	public double getCircumference() {
		return Math.round(Math.PI * radius * 2) ;
		
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + "\t" + "\t"
				+radius + "\t"
				+getPoint().getX() + "\t"
				+getPoint().getY() + "\t"
				+getArea() +"\t"
				+getCircumference();
		// getName ; package이름까지
		// getSimpleName ; class이름만
		
	}

}
