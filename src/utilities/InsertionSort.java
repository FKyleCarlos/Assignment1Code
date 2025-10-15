package utilities;

import java.util.Comparator;

public class InsertionSort {

    public static <T> void sort(T[] arr, Comparator<? super T> cmp) {
        for (int i = 1; i < arr.length; i++) {
            T key = arr[i];
            int j = i - 1;

            // Sort in descending order
            while (j >= 0 && cmp.compare(arr[j], key) < 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
