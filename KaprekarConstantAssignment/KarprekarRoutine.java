package KaprekarConstantAssignment;

public class KaprekarRoutine {

    public static void main(String[] args) {
        int number = InputHandler.readIntegerInput();
        performKaprekarRoutine(number);
    }

    public static void performKaprekarRoutine(int number) {
        if (!InputValidator.isValidInput(number)) {
            System.out.println("Number is not valid");
            return;
        }
    
        int count = 0;
        while (number != Constants.KAPREKAR_CONSTANT) {
            int[] digits = DigitExtractor.getDigits(number); // Get the digits from the current number
    
            if (DigitValidator.isDigitsIdentical(digits)) {
                System.out.println("All digits are identical. Kaprekar's routine will not converge.");
                return;
            }
    
            int[] descendingNumber = ArrayManipulator.sortDigitsDescending(digits);
            int[] ascendingNumber = ArrayManipulator.sortDigitsAscending(digits);
    
            number = digitsManupulator.digitsToNumber(descendingNumber) - digitsManupulator.digitsToNumber(ascendingNumber);
            count++;
    
            // Print the iteration details
            System.out.printf("Iteration %d: %d - %d = %d%n", count, digitsManupulator.digitsToNumber(descendingNumber),
                    digitsManupulator.digitsToNumber(ascendingNumber), number);
        }
    
        System.out.printf("Got Kaprekar's number %d after %d iterations%n", Constants.KAPREKAR_CONSTANT, count);
    }
}
