package shapes;

public class OctagonalPrism extends Prism
{
	//constructor
	public OctagonalPrism(double height, double side)
	{
		super(height, side);
	}
	
	@Override
	public double calcBaseArea()
	{
		double side = getSide();
		return 2 * (1 + Math.sqrt(2)) * Math.pow(side,  2);
	}
	
	
	
	
	
	
}
