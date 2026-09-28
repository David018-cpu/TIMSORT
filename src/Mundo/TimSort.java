package Mundo;

import java.util.Arrays;

public class TimSort<T extends Comparable<T>> {

    public final int RUN = 32;

    public void InsertionSort(T[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            T temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j].compareTo(temp) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    public void MergeSort(T[] arr, int l, int m, int r) {
        T[] left = Arrays.copyOfRange(arr, l, m + 1);
        T[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l;
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length)
            arr[k++] = left[i++];
        while (j < right.length)
            arr[k++] = right[j++];
    }

    public void TimSort(T[] arr, int n) {
        for (int i = 0; i < n; i += RUN) {
            InsertionSort(arr, i, Math.min(i + RUN - 1, n - 1));
        }
        for (int size = RUN; size < n; size *= 2) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, n - 1);
                if (mid < right) {
                    MergeSort(arr, left, mid, right);
                }
            }
        }
    }

    public int getRUN() {
        return RUN;
    }
}