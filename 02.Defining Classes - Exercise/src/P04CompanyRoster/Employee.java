package P04CompanyRoster;
//name, salary, position, department, email and age
public class Employee {
    private String name;
    private Double salary;
    private String position;
    private String department;
    private String email;
    private Integer age;

    public Employee(String name, double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        String email = this.email; // instead of these evaluations I could have used constants:
        if (email == null) {       // private static final String DEFAULT_EMAIL = "n/a"
            email = "n/a";         // private static final String DEFAULT_AGE = -1
        }

        Integer age = this.age;
        if (age == null) {
            age = -1;
        }

        return String.format("%s %.2f %s %d", this.name, this.salary, email, age);
    }
}
