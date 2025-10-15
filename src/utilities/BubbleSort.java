package utilities;

import java.util.Comparator;

public class BubbleSort {

    public static <T> void sort(T[] arr, Comparator<? super T> cmp) {
        boolean swapped;

        for (int n = arr.length; n > 1; n--) {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (cmp.compare(arr[i - 1], arr[i]) < 0) {
                    T temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; 
        }
    }
}
