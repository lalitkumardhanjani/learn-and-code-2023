package KaprekarConstantAssignment;


import java.util.HashSet;
import java.util.Set;

public class DigitExtractor {

    public static int[] getDigits(int number) {
        int thousands = number / 1000;
        int hundreds = (number % 1000) / 100;
        int tens = (number % 100) / 10;
        int ones = number % 10;

        return new int[] { thousands, hundreds, tens, ones };
    }

    
    public static int countDistinctDigits(int[] digits) {
        Set<Integer> distinctDigitSet = new HashSet<>();
        for (int digit : digits) {
            distinctDigitSet.add(digit);
        }
        return distinctDigitSet.size();
    }
    
}
