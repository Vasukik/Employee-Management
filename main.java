import java.util.Scanner;

// Class Name changed to lowercase to match file name
public class main { 
    public static void main(String[] args) {
        // Class name-ஐ lowercase-க்கு மாற்றியுள்ளேன்
        employeeservice service = new employeeservice(); 
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n-------------------------------------");
            System.out.println("Employee Management System (Console)");
            System.out.println("1. Add Employee (Create)");
            System.out.println("2. View All Employees (Read All)");
            System.out.println("3. View Employee by ID (Read One)");
            System.out.println("4. Update Employee Salary (Update)");
            System.out.println("5. Delete Employee (Delete)");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            // Input Validation-க்காக error handling செய்வது சிறந்தது.
            // இங்கு எளிமைக்காக நேரடியாக input எடுக்கப்பட்டுள்ளது.
            
            choice = scanner.nextInt();

            switch (choice) {
                case 1: // Add Employee
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    // Class name-ஐ lowercase-க்கு மாற்றியுள்ளேன்
                    service.addEmployee(new employee(id, name, age, salary)); 
                    break;

                case 2: // View All
                    service.viewAllEmployees();
                    break;

                case 3: // View by ID
                    System.out.print("Enter Employee ID to view: ");
                    int viewId = scanner.nextInt();
                    service.viewEmployeeById(viewId);
                    break;

                case 4: // Update Salary
                    System.out.print("Enter Employee ID to update salary: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter New Salary: ");
                    double newSalary = scanner.nextDouble();
                    service.updateEmployeeSalary(updateId, newSalary);
                    break;

                case 5: // Delete
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    service.deleteEmployee(deleteId);
                    break;

                case 6: // Exit
                    service.saveDataToFile(); // <- Exit ஆவதற்கு முன் தரவுகளை நிரந்தரமாகச் சேமிக்கிறது
                    System.out.println("Exiting Application. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}