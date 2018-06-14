package P04CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> workers;

    public Department() {
        this("", new ArrayList<>());
    }

    public Department(String name, List<Employee> workers) {
        this.name = name;
        this.workers = workers;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getWorkers() {
        return this.workers;
    }

    public void setWorkers(List<Employee> workers) {
        this.workers = workers;
    }

    public Double getAverageSalary() {
        double sum = this.workers.stream()
                .mapToDouble(w -> w.getSalary())
                .sum();

        return sum / this.workers.size();
    }



    public String getDepartmentEmployeesSortedBySalary() {
        StringBuilder sb = new StringBuilder();

        this.workers.stream().sorted((e1, e2) -> {
            return e2.getSalary().compareTo(e1.getSalary());
        }).forEach(e -> {
            sb.append(e.toString()).append(System.lineSeparator());
        });

        return sb.toString();
    }
}
