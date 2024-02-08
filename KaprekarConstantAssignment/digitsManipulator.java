package KaprekarConstantAssignment;

public class digitsManupulator {
    public static int digitsToNumber(int[] digits) {
        return digits[0] * 1000 + digits[1] * 100 + digits[2] * 10 + digits[3];
    }
}
