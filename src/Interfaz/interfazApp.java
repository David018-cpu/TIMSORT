package Interfaz;

import Controlador.Control;
import java.util.Random;

public class interfazApp {

    public static void main(String[] args) {

        Control<Integer> ctrlNum = new Control<Integer>();
        int n = 10;
        Integer[] nums = new Integer[n];
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            nums[i] = rnd.nextInt(20);
        }
        System.out.println("Numeros antes:");
        ctrlNum.printArray(nums, n);
        ctrlNum.ordenar(nums, n);
        System.out.println("Numeros despues:");
        ctrlNum.printArray(nums, n);
    }
}
