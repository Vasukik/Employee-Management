// EmployeeService.java
package com.ems;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator; // Delete-க்கு பயன்படுத்துகிறோம்

public class EmployeeService {

    // Employee objects-களை சேமிக்க ArrayList பயன்படுகிறது
    List<Employee> employees = new ArrayList<>();

    // 1. CREATE Operation (உறுப்பினரைச் சேர்த்தல்)
    public void addEmployee(Employee emp) {
        employees.add(emp);
        System.out.println("Employee " + emp.getName() + " added successfully.");
    }

    // 2. READ All Operation (அனைத்துப் பணியாளர்களின் விவரங்களைப் பார்த்தல்)
    public void viewAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees in the system.");
            return;
        }
        System.out.println("--- Employee Details ---");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
        System.out.println("------------------------");
    }

    // 2. READ by ID Operation (குறிப்பிட்ட பணியாளரின் விவரங்களைப் பார்த்தல்)
    public void viewEmployeeById(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                System.out.println(emp);
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    // 3. UPDATE Operation (சம்பளத்தை மாற்றுதல்)
    public void updateEmployeeSalary(int id, double newSalary) {
        boolean found = false;
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                emp.setSalary(newSalary);
                System.out.println("Salary updated successfully for Employee ID: " + id);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee with ID " + id + " not found. Cannot update.");
        }
    }

    // 4. DELETE Operation (பணியாளரை நீக்குதல்)
    public void deleteEmployee(int id) {
        Iterator<Employee> iterator = employees.iterator(); // Delete செய்ய Iterator பயன்படுத்துவது சிறந்தது
        while (iterator.hasNext()) {
            Employee emp = iterator.next();
            if (emp.getId() == id) {
                iterator.remove();
                System.out.println("Employee ID: " + id + " deleted successfully.");
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found. Cannot delete.");
    }
}