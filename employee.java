import java.io.Serializable;

public class employee implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private int age;
    private double salary;

    public employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Salary: " + salary;
    }
}