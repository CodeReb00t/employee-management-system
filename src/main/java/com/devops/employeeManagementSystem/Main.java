package com.devops.employeeManagementSystem;

public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Devansh Kumar Gupta 22BCE10417", "Developer");
        Employee emp2 = new Employee("Ainesh Sridhar 22BCE11157", "Tester");
        Employee emp3 = new Employee("Tejas Dev Lakhanpal 22BCE11157", "Cleaner");

        emp1.printDetails();
        emp2.printDetails();
        emp3.printDetails();

        System.out.println("Employee Management System running successfully inside Docker!");
    }
}
