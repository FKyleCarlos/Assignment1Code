package appDomain;

import java.util.Comparator;
import shapes.Shape;
import shapes.ShapeFileReader;
import utilities.*;

/**
 * <p>
 * This application driver code is designed to be used as a basis for the
 * Complexity and Sorting assignment that will be developed in the CPRG304 
 * F2025 class at SAIT. The implementors of this applications will be required
 * to add all the correct functionality.
 * </p>
 */
public class AppDriver
{
	/**
	 *  The main method is the entry point of the application.
	 *  
	 *  @param args The input to control the execution of the application.
	 */
	public static void main( String[] args )
	{
		// TODO Auto-generated method stub

		// refer to demo00 BasicFileIO.java for a simple example on how to
		// read data from a text file

		// refer to demo01 Test.java for an example on how to parse command
		// line arguments and benchmarking tests

		// refer to demo02 Student.java for comparable implementation, and
		// NameCompare.java or GradeCompare for comparator implementations

		// refer to demo02 KittySort.java on how to use a custom sorting
		// algorithm on a list of comparables to sort using either the
		// natural order (comparable) or other orders (comparators)
		
		// Example arguments
		String fileName = "res/shapes3.txt";

		char compareType = 'v'; // v = volume, h = height, a = base area
		char sortType = 'h';    // m = merge, q = quick

		// Load shapes from file
		Shape[] shapes = ShapeFileReader.readShapesFromFile(fileName);

		if (shapes == null || shapes.length == 0) {
			System.out.println("No shapes loaded from file.");
			return;
		}

		// Choose comparator based on compareType
		Comparator<Shape> cmp;
		switch (compareType) {
			case 'h':
				cmp = (s1, s2) -> Double.compare(s1.getHeight(), s2.getHeight());
				break;
			case 'a':
				cmp = (s1, s2) -> Double.compare(s1.calcBaseArea(), s2.calcBaseArea());
				break;
			case 'v':
				cmp = (s1, s2) -> Double.compare(s1.calcVolume(), s2.calcVolume());
				break;
			default:
				System.out.println("Invalid compare type. Use h, a, or v.");
				return;
		}

		
		long start = System.currentTimeMillis();

		switch (sortType) {
		    case 'b':
		        utilities.BubbleSort.sort(shapes, cmp);
		        System.out.println("\nSorted using Bubble Sort");
		        break;
		    case 'i':
		        utilities.InsertionSort.sort(shapes, cmp);
		        System.out.println("\nSorted using Insertion Sort");
		        break;
		    case 'm':
		        utilities.MergeSort.sort(shapes, cmp);
		        System.out.println("\nSorted using Merge Sort");
		        break;
		    case 'q':
		        utilities.QuickSort.sort(shapes, cmp);
		        System.out.println("\nSorted using Quick Sort");
		        break;
		    case 's':
		        utilities.QuickSort.sort(shapes, cmp);
		        System.out.println("\nSorted using Selection Sort");
		        break;
		    case 'h':
		        utilities.HeapSort.sort(shapes, cmp);
		        System.out.println("\nSorted using Heap Sort");
		        break;
		    default:
		        System.out.println("Unknown sort type: " + sortType);
		        return;
		}

		long end = System.currentTimeMillis();
		System.out.println("Time taken: " + (end - start) + " ms");

		System.out.println("\nFirst Shape: " + shapes[0].getClass().getSimpleName() +
				" | Area: " + shapes[0].calcVolume());

		System.out.println("Last Shape: " + shapes[shapes.length - 1].getClass().getSimpleName() +
				" | Area: " + shapes[shapes.length - 1].calcVolume());

	}

}
