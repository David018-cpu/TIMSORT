package Controlador;

import Mundo.TimSort;

public class Control<T extends Comparable<T>> {

    private TimSort<T> timSort = new TimSort<T>();

    public void ordenar(T[] arr, int n) {
        timSort.TimSort(arr, n);
    }

    public void printArray(T[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public TimSort<T> getTimSort() {
        return timSort;
    }
}