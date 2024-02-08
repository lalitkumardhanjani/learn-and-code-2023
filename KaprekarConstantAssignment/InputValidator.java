package KaprekarConstantAssignment;

public class InputValidator {
    public static boolean isValidInput(int number) {
        return number >= Constants.MIN_VALID_NUMBER && number <= Constants.MAX_VALID_NUMBER;
    }
}