package com.devops.employeeManagementSystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {

    @Test
    public void testEmployeeName() {
        Employee emp = new Employee("John Doe", "Manager");
        assertEquals("John Doe", emp.getName());
    }

    @Test
    public void testEmployeeRole() {
        Employee emp = new Employee("Jane Doe", "Developer");
        assertEquals("Developer", emp.getRole());
    }
}
