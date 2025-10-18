package utilities;

import java.util.Comparator;
import shapes.Shape;

public class QuickSort {

    public static void sort(Shape[] arr, Comparator<Shape> cmp) {
        if (arr == null || arr.length < 2) return;
        quickSort(arr, 0, arr.length - 1, cmp);
    }

    private static void quickSort(Shape[] arr, int low, int high, Comparator<Shape> cmp) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high, cmp);
            quickSort(arr, low, pivotIndex - 1, cmp);
            quickSort(arr, pivotIndex + 1, high, cmp);
        }
    }

    private static int partition(Shape[] arr, int low, int high, Comparator<Shape> cmp) {
        Shape pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (cmp.compare(arr[j], pivot) <= 0) {
                i++;
                Shape temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Shape temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
