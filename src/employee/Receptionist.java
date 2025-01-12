package employee;



import java.io.*;
import java.util.ArrayList;

public class Receptionist extends Employee implements Serializable, SalaryCalculator {
    private String shift;
    private int hoursWorked;
    private double salary;

    public Receptionist(String name, int age, String shift, int hoursWorked) {
        super(name, age);
        this.shift = shift;
        this.hoursWorked = hoursWorked;
        this.salary = hoursWorked * 1000;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double calculateSalary() {
        return 1000 * hoursWorked;
    }

    @Override
    public String toString() {
        return String.format(" %-15s Age: %-4d Working hours: %-5d Shift: %-10s Salary: Rs.%-10.2f", getName(), getAge(), getHoursWorked(), getShift(), getSalary());
    }
}

