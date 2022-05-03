package model;

public class StaffAccount {
    private int staffID;
    private String name;
    private String email;
    private String password;
    private String role;
    private String phone;


    public StaffAccount(int staffID, String name, String email, String password, String role, String phone) {
        this.staffID = staffID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.phone = phone;
    }

    // Getter Methods
    public int getStaffID() {
        return staffID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getPhone() { return phone; }

    //Setter Methods

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public void setName(String name) { this.name = name; }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}