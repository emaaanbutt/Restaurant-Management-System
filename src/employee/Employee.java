package employee;

import java.io.Serializable;
// SalaryCalculator interface
interface SalaryCalculator {
    double calculateSalary();
}



public class Employee implements Serializable, SalaryCalculator {
    private String username;
    private String password;
    private String name;
    private int age;
    private int employeeID;
    private int counter = 0;

    public Employee(String username, String password) throws IllegalArgumentException {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty.");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty.");
        }

        this.employeeID = ++counter;
        this.username = username;
        this.password = password;
    }

    public Employee(String name, int age) {
        this.employeeID = ++counter;
        this.name = name;
        this.age = age;
    }

    public Employee() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public double calculateSalary() {
        // Provide a default implementation for the base class
        return 0.0;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", employeeID=" + employeeID +
                '}';
    }
}

