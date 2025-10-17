package utilities;

import java.util.Comparator;
import shapes.Shape;

public class MergeSort {

    public static void sort(Shape[] arr, Comparator<Shape> cmp) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1, cmp);
    }

    private static void mergeSort(Shape[] arr, int left, int right, Comparator<Shape> cmp) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid, cmp);
            mergeSort(arr, mid + 1, right, cmp);
            merge(arr, left, mid, right, cmp);
        }
    }

    private static void merge(Shape[] arr, int left, int mid, int right, Comparator<Shape> cmp) {
        int size1 = mid - left + 1;
        int size2 = right - mid;

        Shape[] firstHalf = new Shape[size1];
        Shape[] secondHalf = new Shape[size2];

        for (int i = 0; i < size1; i++) {
            firstHalf[i] = arr[left + i];
        }
        for (int j = 0; j < size2; j++) {
            secondHalf[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < size1 && j < size2) {
            if (cmp.compare(firstHalf[i], secondHalf[j]) >= 0) {
                arr[k] = firstHalf[i];
                i++;
            } else {
                arr[k] = secondHalf[j];
                j++;
            }
            k++;
        }

        while (i < size1) {
            arr[k] = firstHalf[i];
            i++;
            k++;
        }

        while (j < size2) {
            arr[k] = secondHalf[j];
            j++;
            k++;
        }
    }
}
