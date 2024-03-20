package SignUpAssignment;

import java.util.Scanner;

public class InputHandler {
    private static Scanner scanner = new Scanner(System.in);

    public static Scanner getScanner() {
        return scanner;
    }

    public static int getIntInput() {
        return scanner.nextInt();
    }

    public static String getStringInput() {
        return scanner.nextLine();
    }

    public static void closeScanner() {
        scanner.close();
    }
}
