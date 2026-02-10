package assignment2;

import java.util.Scanner;

class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void displaySalary(double before, double after) {
        System.out.println("\n--- Salary Details ---");
        System.out.println("Employee Name : " + name);
        System.out.printf("Salary Before : %.2f%n", before);
        System.out.printf("Salary After  : %.2f%n", after);
    }
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    public double salaryAfterHike() {
        return salary + (0.50 * salary); // 50% hike
    }
}

class InternEmployee extends Employee {
    public InternEmployee(String name, double salary) {
        super(name, salary);
    }

    public double salaryAfterHike() {
        return salary + (0.25 * salary); // 25% hike
    }
}

public class EmployeeInheritanceApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1) Full Time Employee (50% hike)");
        System.out.println("2) Intern Employee (25% hike)");
        System.out.print("Choose type: ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        if (choice == 1) {
            FullTimeEmployee f = new FullTimeEmployee(name, salary);
            double after = f.salaryAfterHike();
            f.displaySalary(salary, after);
        } else if (choice == 2) {
            InternEmployee i = new InternEmployee(name, salary);
            double after = i.salaryAfterHike();
            i.displaySalary(salary, after);
        } else {
            System.out.println("Invalid choice.");
        }

        sc.close();
    }
}
