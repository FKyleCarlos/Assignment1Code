package appDomain;

import java.util.Comparator;
import shapes.*;
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

		//Testing value
//		String fileName = "res/shapes1.txt";
		
		String fileName = new String();

		char compareType = 'a'; // v = volume, h = height, a = base area
		char sortType = 'h';    // m = merge, q = quick, etc

		for (String arg : args) {
            arg = arg.trim();
            if (arg.startsWith("-f") || arg.startsWith("-F")) {
                fileName = arg.substring(2);
            } else if (arg.startsWith("-t") || arg.startsWith("-T")) {
                compareType = Character.toLowerCase(arg.charAt(2));
            } else if (arg.startsWith("-s") || arg.startsWith("-S")) {
                sortType = Character.toLowerCase(arg.charAt(2));
            }
        }
		
		// Load shapes from file
		Shape[] shapes = ShapeFileReader.readShapesFromFile(fileName);

		if (shapes == null || shapes.length == 0) {
			System.out.println("No shapes loaded from file.");
			return;
		}

		ShapeBaseAreaComparator areaCmp = new ShapeBaseAreaComparator();
		ShapeVolumeComparator volumeCmp = new ShapeVolumeComparator();
		// Choose comparator based on compareType
		Comparator<Shape> cmp;
		switch (compareType) {
			case 'h':
				cmp = (s1, s2) -> s1.compareTo(s2);
				break;
			case 'a':
				cmp = (s1, s2) -> areaCmp.compare(s1, s2);
				break;
			case 'v':
				cmp = (s1, s2) -> volumeCmp.compare(s1, s2);
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
		        utilities.SelectionSort.selectionSort(shapes, cmp);
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
		switch (compareType) 
		{
			case 'h':
				System.out.println("Time taken: " + (end - start) + " ms");
	
				System.out.println("\nFirst Shape: " + shapes[0].getClass().getSimpleName() +
						" | Height: " + shapes[0].getHeight());
				
				for(int i = 1000; i < shapes.length - 1; i += 1000)
				{
					System.out.println("Shape: " + shapes[i].getClass().getSimpleName() +
							" | Height: " + shapes[i].getHeight());
				}
	
				System.out.println("Last Shape: " + shapes[shapes.length - 1].getClass().getSimpleName() +
						" | Height: " + shapes[shapes.length - 1].getHeight());
				break;
			case 'a':
				System.out.println("Time taken: " + (end - start) + " ms");
	
				System.out.println("\nFirst Shape: " + shapes[0].getClass().getSimpleName() +
						" | Area: " + shapes[0].calcBaseArea());
				
				for(int i = 1000; i < shapes.length - 1; i += 1000)
				{
					System.out.println("Shape: " + shapes[i].getClass().getSimpleName() +
							" | Area: " + shapes[i].calcBaseArea());
				}
	
				System.out.println("Last Shape: " + shapes[shapes.length - 1].getClass().getSimpleName() +
						" | Area: " + shapes[shapes.length - 1].calcBaseArea());
				break;
			case 'v':
				System.out.println("Time taken: " + (end - start) + " ms");
	
				System.out.println("\nFirst Shape: " + shapes[0].getClass().getSimpleName() +
						" | Volume: " + shapes[0].calcVolume());
				
				for(int i = 1000; i < shapes.length - 1; i += 1000)
				{
					System.out.println(i + "-th element: " + shapes[i].getClass().getSimpleName() +
							" | Volume: " + shapes[i].calcVolume());
				}
	
				System.out.println("Last Shape: " + shapes[shapes.length - 1].getClass().getSimpleName() +
						" | Volume: " + shapes[shapes.length - 1].calcVolume());
				break;
			default:
				System.out.println("Invalid compare type. Use h, a, or v.");
				return;
		}

	}

}
