import java.util.*;
import java.util.stream.*;

class Employee {
    String name;
    String department;
    double salary;

    Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    String getDepartment() {
        return department;
    }

    double getSalary() {
        return salary;
    }
}

public class EmployeeSalaryCategorization {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "HR", 50000),
            new Employee("Bob", "Engineering", 75000),
            new Employee("Charlie", "HR", 55000),
            new Employee("David", "Engineering", 80000)
        );

        Map<String, Double> avgSalary = employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        avgSalary.forEach((dept, avg) -> System.out.println(dept + ": " + avg));
    }
}