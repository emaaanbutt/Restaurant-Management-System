package employee;

import java.io.*;

public class Manager extends Employee implements Serializable, SalaryCalculator  {
    private String department;
    private double baseSalary;



    public Manager(String name, int age, String department)
    {
        super(name,age);
        this.department=department;
        this.baseSalary = 80000.0;

    }


    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }


    @Override
    public double calculateSalary() {
        return baseSalary;
    }

    @Override
    public String toString() {
        return String.format(" %-15s Age:%-4d Department: %-15s Salary: Rs.%-10.2f", getName(), getAge(), getDepartment(), getBaseSalary());
    }
}
