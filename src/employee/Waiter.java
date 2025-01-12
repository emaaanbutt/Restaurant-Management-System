package employee;

import java.io.*;
import java.util.ArrayList;

public class Waiter extends Employee implements Serializable, SalaryCalculator {
    private double salary;
    private int hoursWorked;

    public Waiter() {
    }

    public Waiter(String name, int age, int hoursWorked) {
        super(name, age);
        this.hoursWorked = hoursWorked;
        this.salary = calculateSalary();
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
        this.salary = calculateSalary(); // Update salary when hoursWorked is set
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double calculateSalary() {
        double hourlyWage = 500; // Set your default hourly wage here
        return getHoursWorked() * hourlyWage;
    }

    @Override
    public String toString() {
        return String.format(" %-15s Age: %-4d Working hours: %-5d Salary: Rs.%-10.2f", getName(), getAge(), getHoursWorked(), getSalary());
    }
}

