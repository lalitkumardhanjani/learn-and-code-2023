package KaprekarConstantAssignment;

import java.util.Scanner;

public class Input {
    public static int takeInput() {
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.print("Enter a four-digit number: ");
        number = scanner.nextInt();
        if(!InputValidator.isValidInput(number)){
            return -1;
        }
        return number;
    }
}
