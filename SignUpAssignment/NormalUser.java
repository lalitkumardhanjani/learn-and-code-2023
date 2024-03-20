package SignUpAssignment;

public class NormalUser implements User {
    private String username;
    private String password;
    private String role;
    private String name;
    private int age;
    private String pincode;

    public NormalUser(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPincode() {
        return pincode;
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
