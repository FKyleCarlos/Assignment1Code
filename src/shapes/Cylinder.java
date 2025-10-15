package shapes;

public class Cylinder extends Shape
{
	//attribute
	private double radius;
	
	//constructor 
	public Cylinder(double height, double radius)
	{
		super(height);
		this.radius = radius;
	}
	
	//getter
	public double getRadius()
	{
		return radius;
	}
	
	@Override
	public double calcVolume()
	{
		return Math.PI * radius * radius * getHeight();
	}

	@Override
	public double calcBaseArea() 
	{
		return Math.PI * radius * radius; 
	}
}
