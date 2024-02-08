package KaprekarConstantAssignment;

import java.util.Arrays;

public class ArrayManipulator {
    public static int[] sortDigitsDescending(int[] digits) {
        int[] sortedDigits = Arrays.copyOf(digits, digits.length);
        Arrays.sort(sortedDigits);
        reverseArray(sortedDigits);
        return sortedDigits;
    }
    
    public static int[] sortDigitsAscending(int[] digits) {
        int[] sortedDigits = Arrays.copyOf(digits, digits.length);
        Arrays.sort(sortedDigits);
        return sortedDigits;
    }

    public static void reverseArray(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
