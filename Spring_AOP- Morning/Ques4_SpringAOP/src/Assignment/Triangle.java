package Assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

//@Component
//@Scope(value = "prototype")
public class Triangle {


    

    @Autowired
    @Qualifier("PointA")
    private Point pointA;

    @Autowired
    @Qualifier("PointB")
    private Point pointB;

    @Autowired
    @Qualifier("PointC")
    private Point pointC;
    
    
    private String type;
    private int width;
    private int height;


 

    public Triangle(){}

    public Triangle(String type, int width, int height) {
        this.type = type;
        this.width = width;
        this.height = height;
    }
    public Triangle(Point pointA, Point pointB, Point pointC, int width, int height, String type) {
		super();
		this.pointA = pointA;
		this.pointB = pointB;
		this.pointC = pointC;
		this.width = width;
		this.height = height;
		this.type = type;
	}

    

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }
    
    public String getType() { return type; }
    public void setType(String type) {
        this.type = type;
    }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    public Point getPointA() {
        return pointA;
    }
    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }
    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() { return pointC; }

    public void setPointC(Point pointC) { this.pointC = pointC; }

    public void draw() {
        
        System.out.println("Type : "+getType() + 
        		"Point A :"+ getPointA().getX()+","+getPointA().getY()
    	  		+ " Point B :"+ getPointB().getX()+","+getPointB().getY()
    	  		+ " Point C : "+ getPointC().getX()+","+getPointC().getY()
    	  		+ " Width : " + getWidth()
    	  		+ " Height : " + getHeight());
    }

}