import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

// Class Name changed to lowercase to match file name
public class employeeservice {

    private static final String FILE_NAME = "employee_data.ser"; 

    // employee objects-களை சேமிக்க ArrayList பயன்படுகிறது
    List<employee> employees = new ArrayList<>();

    // Constructor: புரோகிராம் ஆரம்பிக்கும்போதே தரவுகளை ஏற்றுகிறது
    public employeeservice() {
        loadDataFromFile();
    }

    // CREATE Operation
    public void addEmployee(employee emp) {
        employees.add(emp);
        System.out.println("Employee " + emp.getName() + " added successfully.");
    }

    // READ All Operation
    public void viewAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees in the system.");
            return;
        }
        System.out.println("--- Employee Details ---");
        for (employee emp : employees) {
            System.out.println(emp);
        }
        System.out.println("------------------------");
    }

    // READ by ID Operation
    public void viewEmployeeById(int id) {
        for (employee emp : employees) {
            if (emp.getId() == id) {
                System.out.println(emp);
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    // UPDATE Operation
    public void updateEmployeeSalary(int id, double newSalary) {
        boolean found = false;
        for (employee emp : employees) {
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

    // DELETE Operation
    public void deleteEmployee(int id) {
        Iterator<employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            employee emp = iterator.next();
            if (emp.getId() == id) {
                iterator.remove();
                System.out.println("Employee ID: " + id + " deleted successfully.");
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found. Cannot delete.");
    }
    
    // தரவுகளைக் கோப்பில் சேமிக்க (Permanent Save)
    public void saveDataToFile() {
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            
            oos.writeObject(employees);
            System.out.println("Data saved successfully to " + FILE_NAME);
            
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    // கோப்பிலிருந்து தரவுகளை ஏற்ற (Load from File)
    @SuppressWarnings("unchecked") // unchecked warning-ஐ நீக்க
    private void loadDataFromFile() {
        try (FileInputStream fis = new FileInputStream(FILE_NAME);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            
            employees = (List<employee>) ois.readObject(); 
            System.out.println("Data loaded successfully from " + FILE_NAME);
            
        } catch (FileNotFoundException e) {
            System.out.println("Data file not found. Starting with empty list.");
            employees = new ArrayList<>();
            
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading data. Starting with empty list: " + e.getMessage());
            employees = new ArrayList<>();
        }
    }
}