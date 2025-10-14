package shapes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShapeFileReader
{
    public static Shape[] readShapesFromFile(String fileName)
    {
        Shape[] shapes = null;

        try
        {
           
            File inputFile = new File(fileName);
            Scanner input = new Scanner(inputFile);

            //first line number of shapes
            int numShapes = input.nextInt();
            shapes = new Shape[numShapes];

            //read
            for (int i = 0; i < numShapes; i++)
            {
                String type = input.next();       
                double height = input.nextDouble();
                double value = input.nextDouble(); 

                //create shape with height and value
                shapes[i] = createShape(type.toLowerCase(), height, value);
            }
        }
        catch (FileNotFoundException e)
        {
            System.err.println("File not found: " + fileName);
        }

        return shapes;
    }

    
    private static Shape createShape(String type, double height, double value)
    {
        switch (type)
        {
            case "cylinder":         return new Cylinder(height, value);
            case "cone":             return new Cone(height, value);
            case "pyramid":          return new Pyramid(height, value);
            case "squareprism":      return new SquarePrism(height, value);
            case "triangularprism":  return new TriangularPrism(height, value);
            case "pentagonalprism":  return new PentagonalPrism(height, value);
            case "octagonalprism":   return new OctagonalPrism(height, value);
            default:
                return null;
        }
    }

    //testing
    public static void main(String[] args)
    {
        Shape[] shapes = readShapesFromFile("assignment1StartingCode/res/shapes1.txt");

        if (shapes == null) return;

        	System.out.println("Loaded " + shapes.length + " shapes:\n");

        for (Shape s : shapes)
        {
            if (s != null)
            {
            	System.out.println(
            		    "Shape: " + s.getClass().getSimpleName() +
            		    " | Height: " + s.getHeight() +
            		    " | Base Area: " + s.calcBaseArea() +
            		    " | Volume: " + s.calcVolume()
            		);

            }
        }
    }
}
