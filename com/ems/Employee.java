// Employee.java
package com.ems;

public class Employee {
    // Attributes (மாறிகள்)
    private int id;
    private String name;
    private int age;
    private double salary;

    // Constructor (புதிய Employee உருவாக்க)
    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Getters and Setters (விவரங்களைப் பெற/மாற்ற - Encapsulation)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    // இந்தப் புராஜெக்ட்டில் சம்பளத்தை மட்டுமே மாற்றும் வசதியை வைப்போம்.
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // விவரங்களைப் பிரிண்ட் செய்ய (Read)
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Salary: " + salary;
    }
}