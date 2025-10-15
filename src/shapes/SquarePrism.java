package shapes;

public class SquarePrism extends Prism
{
	//constructor
	public SquarePrism(double height, double side) 
	{
		super(height, side);
	}

	@Override
	public double calcBaseArea() 
	{
		return Math.pow(getSide(), 2);
	}
	
}
