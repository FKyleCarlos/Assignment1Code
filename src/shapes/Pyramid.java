package shapes;

public class Pyramid extends Shape
{
	
	//attribute
	private double side;

	public Pyramid(double height, double side) 
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
		return (1.0 / 3.0) * calcBaseArea() * getHeight();
	}

	@Override
	public double calcBaseArea() 
	{
		return Math.pow(side,  2);
	}
	

}
