package SignUpAssignment;

import java.util.Scanner;

public class Admin implements User {
    private String username;
    private String password;
    private String role;

    public Admin(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getRole() {
        return role;
    }
}
