package shapes;

public abstract class Prism extends Shape
{
	//attributes 
	private double side;
	
	//constrcutor 
	public Prism(double height, double side)
	{
		super(height);
		this.side = side;
	}
	
	//getter 
	public double getSide()
	{
		return side;
	}
	
	@Override
	public double calcVolume()
	{
		return calcBaseArea() * getHeight(); 
	}
}
