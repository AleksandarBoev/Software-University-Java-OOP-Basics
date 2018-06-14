package P04CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Department> departments = new HashMap<>();

        int numberOfInputs = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfInputs; i++) {
            String[] tokens = reader.readLine().split(" ");

            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String departmentName = tokens[3];

            Employee currentEmployee = new Employee(name, salary, position, departmentName);

            if (tokens.length == 5) { // another way of doing it: if (tokens[4].matches("\\d+")) ...
                try {
                    int age = Integer.parseInt(tokens[4]);
                    currentEmployee.setAge(age);
                } catch (NumberFormatException nfe) {
                    String email = tokens[4];
                    currentEmployee.setEmail(email);
                }
            } else if (tokens.length == 6) {
                String email = tokens[4];
                currentEmployee.setEmail(email);

                int age = Integer.parseInt(tokens[5]);
                currentEmployee.setAge(age);
            }

            if (!departments.containsKey(departmentName)) {
                List<Employee> employees = new ArrayList<>();
                employees.add(currentEmployee);
                Department currentDepartment = new Department(departmentName, employees);

                departments.put(departmentName, currentDepartment);
            } else {
                departments.get(departmentName).getWorkers().add(currentEmployee);
            }
        }
        reader.close();

        Optional<String> biggestAverageSalaryDepartmentName = departments.entrySet().stream()
                .sorted((kvp1, kvp2) -> {
                    return kvp2.getValue().getAverageSalary().compareTo(kvp1.getValue().getAverageSalary());
                }).map(kvp -> kvp.getKey())
                .findFirst();

        System.out.println("Highest Average Salary: " + biggestAverageSalaryDepartmentName.get());

        System.out.print(departments.get(biggestAverageSalaryDepartmentName.get()).getDepartmentEmployeesSortedBySalary());
        //main ends here
    }
}
