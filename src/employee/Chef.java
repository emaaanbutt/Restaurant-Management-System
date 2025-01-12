
package employee;

import java.io.*;
import java.util.ArrayList;

public class Chef extends Employee implements Serializable, SalaryCalculator  {
    private String cuisineSpecialty;
    private int experienceInYears;

    private double salary;
    public Chef(String name, int age, String cuisineSpecialty,int experienceInYears)
    {
        super(name,age);
        try {
            if (cuisineSpecialty == null || cuisineSpecialty.isEmpty()) {
                throw new IllegalArgumentException("Cuisine specialty cannot be null or empty");
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }

        if (experienceInYears < 0) {
            throw new IllegalArgumentException("Experience in years must be non-negative");
        }
        this.cuisineSpecialty = cuisineSpecialty;
        this.experienceInYears = experienceInYears;
        this.salary=calculateSalary();
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setCuisineSpecialty(String cuisineSpecialty) {
        this.cuisineSpecialty = cuisineSpecialty;
    }

    public void setExperienceInYears(int experienceInYears) {
        this.experienceInYears = experienceInYears;
    }

    public String getCuisineSpecialty() {
        return cuisineSpecialty;
    }

    public int getExperienceInYears() {
        return experienceInYears;
    }

    @Override
    public double calculateSalary() {
        // A fixed base salary for chefs
        double baseSalary = 50000.0;

        // Additional bonus for each year of experience
        double experienceBonus = 1000.0;

        // Calculate the total salary
        return baseSalary + (getExperienceInYears() * experienceBonus);
    }

    // Method to display chef's experience
    public void displayExperienceYears() {
        System.out.println("Chef " + getEmployeeID() + " has experience of " + experienceInYears + " years");
    }

    @Override
    public String toString() {
        return String.format(" %-15s Age: %-4d Cuisine Specialty: %-12s Experience (in years): %-5d Salary: Rs.%-10.2f", getName(), getAge(), getCuisineSpecialty(), getExperienceInYears(), getSalary());
    }
}
