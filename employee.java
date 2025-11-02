import java.io.Serializable;

// Class Name changed to lowercase to match file name
public class employee implements Serializable {
    
    // Serialization-க்காக
    private static final long serialVersionUID = 1L;

    // Attributes (மாறிகள்)
    private int id;
    private String name;
    private int age;
    private double salary;

    // Constructor 
    public employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // விவரங்களைப் பிரிண்ட் செய்ய
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Salary: " + salary;
    }
}