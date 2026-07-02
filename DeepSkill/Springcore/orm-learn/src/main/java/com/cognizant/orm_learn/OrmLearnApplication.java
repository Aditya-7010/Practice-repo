
package com.cognizant.ormlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;

@SpringBootApplication
public class OrmLearnApplication {

    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(OrmLearnApplication.class, args);

        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);

        testGetEmployee();
        testAddEmployee();
        testUpdateEmployee();
        testGetDepartment();
        testAddSkillToEmployee();
    }

    private static void testGetEmployee() {

        Employee employee = employeeService.get(1);

        System.out.println(employee);
        System.out.println(employee.getDepartment());
        System.out.println(employee.getSkillList());
    }

    private static void testAddEmployee() {

        Employee employee = new Employee();

        employee.setName("Adi");
        employee.setSalary(50000);
        employee.setPermanent(true);

        Department department = departmentService.get(1);

        employee.setDepartment(department);

        employeeService.save(employee);

        System.out.println(employee);
    }

    private static void testUpdateEmployee() {

        Employee employee = employeeService.get(1);

        Department department = departmentService.get(2);

        employee.setDepartment(department);

        employeeService.save(employee);

        System.out.println(employee);
    }

    private static void testGetDepartment() {

        Department department = departmentService.get(1);

        System.out.println(department);
        System.out.println(department.getEmployeeList());
    }

    private static void testAddSkillToEmployee() {

        Employee employee = employeeService.get(1);

        Skill skill = skillService.get(2);

        employee.getSkillList().add(skill);

        employeeService.save(employee);

        System.out.println(employee);
    }
}

