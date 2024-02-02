package KaprekarConstantAssignment;

public class KaprekarRoutine {

    public static String performKaprekarRoutine(int number) {
        int count = 0;
        int kaprekarConstant = 6174;

        while (number != kaprekarConstant) {
            int[] digits = DigitExtractor.getDigits(number);

            int[] descNumber = ArrayManipulator.sortDigitsDescending(digits);
            int[] ascNumber = ArrayManipulator.sortDigitsAscending(digits);

            number = NumberFormer.formNumber(descNumber) - NumberFormer.formNumber(ascNumber);

            count++;
            System.out.printf("Iteration %d: %d - %d = %d%n", count, NumberFormer.formNumber(descNumber), NumberFormer.formNumber(ascNumber),
                    number);
        }

        return String.format("Got Kaprekar's number %d after %d iterations", kaprekarConstant, count);
    }

    public static void main(String[] args) {
        int number = Input.takeInput();
        if(number==-1){
            System.out.println("Number is not valid");
            return;
        }
        
        int[] digits = DigitExtractor.getDigits(number);
        if (DigitValidator.areAllDigitsIdentical(digits)) {
            System.out.println("All digits are identical. Kaprekar's routine will not converge.");
        }else{
            String result = performKaprekarRoutine(number);
            System.out.println(result);
        }
    }
}
