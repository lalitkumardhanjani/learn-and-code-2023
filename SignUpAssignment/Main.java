package SignUpAssignment;

public class Main {
    public static void main(String[] args) {
        InputHandler getInput = new InputHandler(); 
        boolean exitRequested = false;
        while (!exitRequested) {
            System.out.println("Select user type:");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Viewer");
            System.out.println("4. Exit");

            int userType = getInput.getIntInput();

            switch (userType) {
                case 1:
                    System.out.println("Enter admin username:");
                    String adminUsername = getInput.getStringInput();
                    System.out.println("Enter admin password:");
                    String adminPassword = getInput.getStringInput();

                    if (adminUsername.equals("admin") && adminPassword.equals("1234")) {
                        System.out.println("Login successful as admin");
                        MenuOptions.adminOptions(getInput.getScanner());
                    } else {
                        System.out.println("Invalid admin credentials");
                    }
                    break;

                case 2:
                    System.out.println("Enter user username:");
                    String userUsername = getInput.getStringInput();
                    System.out.println("Enter user password:");
                    String userPassword = getInput.getStringInput();

                    if (UserDatabase.validateUser(userUsername, userPassword, "User")) {
                        System.out.println("Login successful as user");
                        MenuOptions.userOptions(getInput.getScanner());
                    } else {
                        System.out.println("Invalid user credentials");
                    }
                    break;

                case 3:
                    System.out.println("Enter viewer username:");
                    String viewerUsername = getInput.getStringInput();
                    System.out.println("Enter viewer password:");
                    String viewerPassword = getInput.getStringInput();

                    if (UserDatabase.validateUser(viewerUsername, viewerPassword, "Viewer")) {
                        System.out.println("Login successful as viewer");
                        MenuOptions.viewerOptions(getInput.getScanner());
                    } else {
                        System.out.println("Invalid viewer credentials");
                    }
                    break;

                case 4:
                    exitRequested = true;
                    System.out.println("Exiting program");
                    break;

                default:
                    System.out.println("Invalid option");
                    break;
            }
        }

        getInput.closeScanner();
    }
}
