package SignUpAssignment;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserDatabase {
    private static Map<String, User> users = new HashMap<>();
    private static Map<String, String> userRoles = new HashMap<>();

    public static void addUser(User user) {
        if (users.containsKey(user.getUsername())) {
            String existingRole = userRoles.get(user.getUsername());
            if (existingRole.equals(user.getRole())) {
                System.out.println("Username '" + user.getUsername() + "' already exists as a " + user.getRole() + ". Please choose a different username.");
            } else {
                users.put(user.getUsername(), user);
                userRoles.put(user.getUsername(), user.getRole());
                System.out.println(user.getRole() + " created successfully");
            }
        } else {
            users.put(user.getUsername(), user);
            userRoles.put(user.getUsername(), user.getRole());
            System.out.println(user.getRole() + " created successfully");
        }
    }
    

    public static User getUser(String username) {
        return users.get(username);
    }

    public static void removeUser(String username) {
        users.remove(username);
        userRoles.remove(username);
    }

    public static Collection<User> getAllUsers() {
        return users.values();
    }

    public static boolean validateUser(String username, String password, String role) {
        User user = users.get(username);
        return user != null && user.getRole().equals(role) && user.getPassword().equals(password);
    }
}

