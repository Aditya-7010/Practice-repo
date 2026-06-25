package DeepSkill.DataStructuresandAlgorithms.EmployeeManagementSystem;

public class Employee {

    private int employeeID;
    private String name;
    private String position;
    private double salary;

    public Employee(int employeeID, String name, String position, double salary) {
        this.employeeID = employeeID;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String displayData() {
        return "ID: " + employeeID + ", Name: " + name + ", Position: " + position + ", Salary: $" + salary;
    }
}