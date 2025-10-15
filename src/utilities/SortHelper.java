package utilities;

import java.util.Comparator;

public class SortHelper
{
	static <T> void Heapify(T[] arr, int n, int i, Comparator<T> comp)
	{
		int largest = i;
		int left = (2 * i) + 1;
		int right = (2 * i) + 2;
		
		if(left < n && comp.compare(arr[left], arr[largest]) > 0)
		{
			largest = left;
		}
		
		if(right < n && comp.compare(arr[right], arr[largest]) > 0)
		{
			largest = right;
		}
		
		if(largest != i)
		{
			T temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			Heapify(arr, n, largest, comp);
		}
	}
	
	static <T> void HeapSort(T[] arr, Comparator<T> comp)
	{
		int n = arr.length;
		
		for(int i = n/2 - 1; i >= 0; i--)
		{
			Heapify(arr, n, i, comp);
		}
		
		for(int i = n - 1; i > 0; i--)
		{
			T temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			Heapify(arr, i, 0, comp);
		}
	}
	
	
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
                if (comp.compare(array[j], array[minIndex]) > 0) 
                    minIndex = j;
            }

            T temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
	
}
