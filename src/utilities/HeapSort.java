package utilities;

import java.util.Comparator;

public class HeapSort
{
	static <T> void heapify(T[] arr, int n, int i, Comparator<T> comp)
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
			heapify(arr, n, largest, comp);
		}
	}
	
	public static <T> void sort(T[] arr, Comparator<T> comp)
	{
		int n = arr.length;
		
		for(int i = n/2 - 1; i >= 0; i--)
		{
			heapify(arr, n, i, comp);
		}
		
		for(int i = n - 1; i > 0; i--)
		{
			T temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, i, 0, comp);
		}
	}
}
