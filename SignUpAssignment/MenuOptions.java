package SignUpAssignment;

import java.util.Scanner;

public class MenuOptions {
    
    public static void adminOptions(Scanner scanner) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Admin options:");
            System.out.println("1. Create user");
            System.out.println("2. Delete user");
            System.out.println("3. Create viewer");
            System.out.println("4. Delete viewer");
            System.out.println("5. Exit");
    
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline
    
            switch (option) {
                case 1:
                    System.out.println("Enter new user username:");
                    String newUserUsername = scanner.nextLine();
                    System.out.println("Enter new user password:");
                    String newUserPassword = scanner.nextLine();
                    NormalUser newUser = new NormalUser(newUserUsername, newUserPassword, "User");
                    UserDatabase.addUser(newUser);
                    
                    break;
    
                case 2:
                    System.out.println("Enter user username:");
                    String userUsername = scanner.nextLine();
                    UserDatabase.removeUser(userUsername);
                    System.out.println("User deleted successfully");
                    break;
    
                case 3:
                    System.out.println("Enter new viewer username:");
                    String newViewerUsername = scanner.nextLine();
                    System.out.println("Enter new viewer password:");
                    String newViewerPassword = scanner.nextLine();
                    Viewer newViewer = new Viewer(newViewerUsername, newViewerPassword, "Viewer");
                    UserDatabase.addUser(newViewer);
                    break;
    
                case 4:
                    System.out.println("Enter viewer username:");
                    String viewerUsername = scanner.nextLine();
                    UserDatabase.removeUser(viewerUsername);
                    System.out.println("Viewer deleted successfully");
                    break;
    
                case 5:
                    exit = true;
                    System.out.println("Exiting admin panel");
                    break;
    
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
    
    

    public static void userOptions(Scanner scanner) {
        boolean exit = false;
        NormalUser user = null;
        while (!exit) {
            System.out.println("User options:");
            System.out.println("1. Enter user details");
            System.out.println("2. Update user details");
            System.out.println("3. Show details");
            System.out.println("4. Exit");
    
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline
    
            switch (option) {
                case 1:
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter age:");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter pincode:");
                    String pincode = scanner.nextLine();
                    user = new NormalUser("", "", ""); // Create a new user object
                    user.setName(name);
                    user.setAge(age);
                    user.setPincode(pincode);
                    System.out.println("User details saved successfully");
                    break;
    
                case 2:
                    if (user != null) {
                        System.out.println("Update user details:");
                        System.out.println("1. Change age");
                        System.out.println("2. Change pincode");
                        int updateOption = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        switch (updateOption) {
                            case 1:
                                System.out.println("Enter new age:");
                                int newAge = scanner.nextInt();
                                scanner.nextLine(); // Consume newline
                                user.setAge(newAge);
                                System.out.println("Age updated successfully");
                                break;
    
                            case 2:
                                System.out.println("Enter new pincode:");
                                String newPincode = scanner.nextLine();
                                user.setPincode(newPincode);
                                System.out.println("Pincode updated successfully");
                                break;
    
                            default:
                                System.out.println("Invalid option");
                                break;
                        }
                    } else {
                        System.out.println("Please enter user details first");
                    }
                    break;
    
                case 3:
                    if (user != null) {
                        System.out.println("User details:");
                        System.out.println("Name: " + user.getName());
                        System.out.println("Age: " + user.getAge());
                        System.out.println("Pincode: " + user.getPincode());
                    } else {
                        System.out.println("User details not available");
                    }
                    break;
    
                case 4:
                    exit = true;
                    System.out.println("Exiting user panel");
                    break;
    
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
    
    
    
    
        

    public static void viewerOptions(Scanner scanner) {
        boolean exit = false;
        Viewer viewer = null;
        while (!exit) {
            System.out.println("Viewer options:");
            System.out.println("1. View user details");
            System.out.println("2. Logout");
    
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline
    
            switch (option) {
                case 1:
                    System.out.println("User details:");
                    for (User u : UserDatabase.getAllUsers()) {
                        if (!(u instanceof Viewer)) {
                            System.out.println("Username: " + u.getUsername());
                            System.out.println("Role: " + u.getRole());
                            if (u instanceof NormalUser) {
                                NormalUser nu = (NormalUser) u;
                                System.out.println("Name: " + nu.getName());
                                System.out.println("Age: " + nu.getAge());
                                System.out.println("Pincode: " + nu.getPincode());
                            }
                            System.out.println("----------");
                        }
                    }
                    break;
    
                case 2:
                    exit = true;
                    System.out.println("Logging out");
                    break;
    
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}
