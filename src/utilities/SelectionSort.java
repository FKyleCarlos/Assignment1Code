package utilities;

import java.util.Comparator;

public class SelectionSort
{
	//Selection sorting by height****
	public static <T extends Comparable<T>> void selectionSort(T[] array) 
	{
		int n = array.length;
		
		for (int i = 0; i < n -1; i++)
		{
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
	            if (array[j].compareTo(array[minIndex]) > 0) {  //compareTo method in Shape.java returns 1 or -1
	                minIndex = j;
	            }
	        }

	        // swap
	        T temp = array[i];
	        array[i] = array[minIndex];
	        array[minIndex] = temp;
		}
	}
	
	//Selection sorting by Volume and Base area****
	public static <T> void selectionSort(T[] array, Comparator<T> comp)
    {
        int n = array.length;
        
        for (int i = 0; i < n - 1; i++)
        {
            int minIndex = i;
            for (int j = i + 1; j < n; j++)
            {
                if (comp.compare(array[j], array[minIndex]) < 0) 
                    minIndex = j;
            }

            T temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
}
