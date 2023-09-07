package geometry;
import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {
	private Point upperLeftPoint;
	private int height;
	private int width;
	
	 public Rectangle () {
		 this.upperLeftPoint = new Point(height, height);
	 }
	 
	public Rectangle(Point upperLeftPoint, int height, int width)  {
		this.upperLeftPoint = upperLeftPoint;
		this.height = height;
		this.width = width;
	}
	
	public Rectangle(Point upperLeftPoint, int height, int width, boolean selected) {
		this(upperLeftPoint, height, width);
		this.selected = selected;
	}
	
	public Rectangle(Point upperLeftPoint, int height, int width, boolean selected, Color color) {
		this(upperLeftPoint, height, width, selected);
		setColor(color);
	}
	
	public Rectangle(Point upperLeftPoint, int height, int width, boolean selected, Color color, Color innerColor) {
		this(upperLeftPoint, height, width, selected, color);
		setInnerColor(innerColor);
	}
	
	public double area() {
		return (this.height * this.width);
	}
	
	public double circumference() {
		return 2*(this.height + this.width);
	}

	public Point getUpperLeftPoint() {
		return this.upperLeftPoint;
	}

	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	
	@Override
	public String toString() {
		//return "Upper left point: (" + this.upperLeftPoint.getX() + "," + this.upperLeftPoint.getY() + "), width = "+ this.width + ", height = "+ this.height;
		return "Upper left point: " + this.upperLeftPoint + ", width = "+ this.width + ", height = "+ this.height;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Rectangle) {
			Rectangle r = (Rectangle)o;
			return (r.getUpperLeftPoint().equals(this.upperLeftPoint) &&
					r.getHeight() == this.height && r.getWidth() == this.width);
		} else {
			return false;
		}
	}
	
	public boolean contains(int x, int y) {
		if(x > this.upperLeftPoint.getX() && x < this.upperLeftPoint.getX() + width
				&& y > this.upperLeftPoint.getY() && y < this.getUpperLeftPoint().getY() + height) {
			return true;
		}
		return false;
	}
	
	public boolean contains(Point point) {
		if(point.getX() > this.upperLeftPoint.getX() && point.getX() < this.upperLeftPoint.getX() + width
				&& point.getY()> this.upperLeftPoint.getY() && point.getY() < this.getUpperLeftPoint().getY() + height) {
			return true;
		}
		return false;
	}
	
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawRect(this.upperLeftPoint.getX(), this.upperLeftPoint.getY(), this.width, this.height);
		
		this.fill(g);
		
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(getUpperLeftPoint().getX() - 3, getUpperLeftPoint().getY() - 3, 6, 6);
			g.drawRect(getUpperLeftPoint().getX() + getWidth() - 3, getUpperLeftPoint().getY() - 3, 6, 6);
			g.drawRect(getUpperLeftPoint().getX() - 3, getUpperLeftPoint().getY() + getHeight() - 3, 6, 6);
			g.drawRect(getUpperLeftPoint().getX() + getWidth() - 3, getUpperLeftPoint().getY() + getHeight() - 3, 6, 6);
		}

	}
	
	@Override
	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		g.fillRect(this.upperLeftPoint.getX()+1, this.getUpperLeftPoint().getY()+1, width-1, height-1);
	}
	
	public void moveBy(int byX, int byY) {
		this.upperLeftPoint.moveBy(byX, byY);
	}
	
	public void moveTo(int x, int y) {
		this.upperLeftPoint.moveTo(x, y);
	}
	
	public int compareTo(Object o) {
		if (o instanceof Rectangle) {
			return (int) (this.area() - ((Rectangle) o).area());
		}
		return 0;
	}

	
}