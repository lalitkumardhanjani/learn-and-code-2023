package KaprekarConstantAssignment;

import java.util.Scanner;

public class InputHandler {
    public static int readIntegerInput() {
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.print("Enter a four-digit number: ");
        number = scanner.nextInt();
        return number;
    }
}
