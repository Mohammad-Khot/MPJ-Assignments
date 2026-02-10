package assignment1;

import java.util.Scanner;

class Student {
    private String name;
    private String rollNo;
    private int[] marks;

    public Student(String name, String rollNo, int[] marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    public double calculateAverage() {
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        return sum / 5.0;
    }

    public double calculatePercentage() {
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        return (sum / 500.0) * 100;
    }

    public char calculateGrade() {
        double percentage = calculatePercentage();
        if (percentage >= 75) return 'A';
        else if (percentage >= 60) return 'B';
        else return 'C';
    }

    public void displayResult() {
        System.out.println("\n--- Student Result ---");
        System.out.println("Name       : " + name);
        System.out.println("Roll No    : " + rollNo);
        System.out.printf("Average    : %.2f%n", calculateAverage());
        System.out.printf("Percentage : %.2f%%%n", calculatePercentage());
        System.out.println("Grade      : " + calculateGrade());
    }
}

public class StudentGradeApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        String rollNo = sc.nextLine();

        int[] marks = new int[5];
        System.out.println("Enter marks for 5 subjects:");
        for (int i = 0; i < 5; i++) {
            marks[i] = sc.nextInt();
        }

        Student student = new Student(name, rollNo, marks);
        student.displayResult();

        sc.close();
    }
}
