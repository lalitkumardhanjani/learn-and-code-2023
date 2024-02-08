import java.util.Scanner;

public class InputReader {
    public static String readUsername() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your email username: ");
        return scanner.nextLine();
    }

    public static String readPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your email password: ");
        return scanner.nextLine();
    }

    public static String readEmailDomain() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your email domain (e.g. gmail.com): ");
        return scanner.nextLine();
    }
}