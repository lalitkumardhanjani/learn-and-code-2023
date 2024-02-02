package KaprekarConstantAssignment;

public class NumberFormer {
    public static int formNumber(int[] digits) {
        return digits[0] * 1000 + digits[1] * 100 + digits[2] * 10 + digits[3];
    }
}
