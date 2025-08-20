// Method References – Name Uppercasing

class Employee {
    String name;
    String getName() { return name; }
}

class HR {
    void convertNames(List<Employee> emps) {
        emps.stream()
            .map(Employee::getName)
            .map(String::toUpperCase)   // method reference to uppercase
            .forEach(System.out::println);
    }
}
