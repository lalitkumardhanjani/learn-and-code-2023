package KaprekarConstantAssignment;

public class DigitValidator {
    public static boolean areAllDigitsIdentical(int[] digits) {
        int distinctCount = DigitExtractor.countDistinctDigits(digits);
        return distinctCount == 1;
    }

}
