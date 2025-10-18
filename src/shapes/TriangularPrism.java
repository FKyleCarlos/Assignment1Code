package shapes;

public class TriangularPrism extends Prism
{
	//constructor 
	public TriangularPrism(double height, double side) 
	{
		super(height, side);
	}
	
	@Override
	public double calcBaseArea()
	{
		double side = getSide();
		return (Math.pow(side, 2) * Math.sqrt(3)) /4;
	}
	
}

