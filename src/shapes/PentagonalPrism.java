package shapes;

public class PentagonalPrism extends Prism
{
	//constructor
	public PentagonalPrism(double height, double side) 
	{
		super(height, side);
	}
	
	@Override
	public double calcBaseArea()
	{
		double side = getSide();
		return (5 * Math.pow(side, 2)) / (4 * Math.tan(Math.toRadians(54)));
	}
	
	

}
