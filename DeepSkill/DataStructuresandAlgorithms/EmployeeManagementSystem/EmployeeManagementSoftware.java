package DeepSkill.DataStructuresandAlgorithms.EmployeeManagementSystem;

public class EmployeeManagementSoftware {

    public static void main(String[] args) {

        EmployeeManager manager = new EmployeeManager(10);

        manager.addEmployee(new Employee(24, "Aditya","Software Engineer",60000));

        manager.addEmployee(new Employee(25,"Rahul","Tester",45000));

        manager.addEmployee(new Employee(27,"Pia","Manager",85000));

        System.out.println("\nEmployee Records:");
        manager.displayEmployees();

        System.out.println("\nSearch Result:");
        System.out.println(manager.searchEmployee(24));

        manager.deleteEmployee(25);

        System.out.println("\nAfter Deletion:");
        manager.displayEmployees();
    }
}