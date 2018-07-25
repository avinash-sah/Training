package train.main;

import train.array.RotationReversal;
import train.array.ShiftArray;

public class ArrayMain {

    public static void main(String[] args) {
        System.out.println("HelloWorld");
        int[] input = new int[]{1, 3, 2, 4, 5};
        printArr(input);
        ShiftArray shiftArray = new ShiftArray();
        printArr(shiftArray.rightShift(input, 2, 5));
        printArr(shiftArray.leftShift(input, 2, 5));
        input = new int[]{1, 3, 2, 4, 5};
        shiftArray.inPlaceShift(input, 2, 5);
        printArr(input);
        input = new int[]{1, 3, 2, 4, 5};
        shiftArray.inPlaceShiftRef(input, 2, 5);
        printArr(input);
        input = new int[]{1, 3, 2, 4, 5};
        shiftArray.juggler(input, 2, 5);
        printArr(input);
        input = new int[]{1, 3, 2, 4, 5};
        new RotationReversal().rotate(input, 2);
        printArr(input);

    }

    public static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

