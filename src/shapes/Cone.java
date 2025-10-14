package shapes;

public class Cone extends Shape 
{
	//attribute
	private double radius;
	
	//constructor 
	public Cone(double height, double radius)
	{
		super(height);
		this.radius = radius;
	}
	
	//getter 
	public double getRadius()
	{
		return radius;
	}

	@Override //these come from the Class Shape.java 
	public double calcVolume() 
	{
		//can also write it as 1.0 / 3.0 * calcBaseArea() * getHeight();
		return calcBaseArea() * getHeight() / 3;
	}

	@Override
	public double calcBaseArea() 
	{
		
		return Math.PI * radius * radius;
	}
	
	
}
