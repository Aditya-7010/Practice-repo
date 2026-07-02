```java id="i9l0df"
package com.cognizant.ormlearn;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.EmployeeService;

@SpringBootApplication
public class OrmLearnApplication {

    private static EmployeeService employeeService;

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(
                        OrmLearnApplication.class, args);

        employeeService =
                context.getBean(EmployeeService.class);

        testGetAllPermanentEmployees();

        testGetAverageSalary();

        testGetAllEmployeesNative();
    }

    private static void testGetAllPermanentEmployees() {

        List<Employee> employees =
                employeeService.getAllPermanentEmployees();

        employees.forEach(employee -> {

            System.out.println(employee);

            System.out.println(employee.getDepartment());

            System.out.println(employee.getSkillList());
        });
    }

    private static void testGetAverageSalary() {

        double avg =
                employeeService.getAverageSalary(1);

        System.out.println(avg);
    }

    private static void testGetAllEmployeesNative() {

        List<Employee> employees =
                employeeService.getAllEmployeesNative();

        employees.forEach(System.out::println);
    }
}
```
