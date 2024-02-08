package KaprekarConstantAssignment;

public class DigitValidator {
    public static boolean isDigitsIdentical(int[] digits) {
        int distinctCount = DigitExtractor.countDistinctDigits(digits);
        return distinctCount == 1;
    }
}