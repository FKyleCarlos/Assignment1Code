package utilities;

import java.util.Comparator;

public class SortHelper
{
	static void Heapify(int arr[], int n, int i)
	{
		int largest = i;
		int left = (2 * i) + 1;
		int right = (2 * i) + 2;
		
		if(left < n && arr[left] > arr[largest])
		{
			largest = left;
		}
		
		if(right < n && arr[right] > arr[largest])
		{
			largest = right;
		}
		
		if(largest != i)
		{
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			Heapify(arr, n, largest);
		}
	}
	
	static void HeapSort(int arr[])
	{
		int n = arr.length;
		
		for(int i = n/2 - 1; i >= 0; i--)
		{
			Heapify(arr, n, i);
		}
		
		for(int i = n - 1; i > 0; i--)
		{
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			Heapify(arr, i, 0);
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
