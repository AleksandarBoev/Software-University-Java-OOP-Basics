package p03_mankind;

public class Student extends Human {
    private static final String NOT_BETWEEN_5_AND_10_SYMBOLS_FACULTY_NUMBER_MESSAGE = "Invalid faculty number!";

    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    private void setFacultyNumber(String facultyNumber) {
        if (facultyNumber.length() < 5 || facultyNumber.length() > 10) {
            throw new IllegalArgumentException(NOT_BETWEEN_5_AND_10_SYMBOLS_FACULTY_NUMBER_MESSAGE);
        }

        this.facultyNumber = facultyNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());

        sb.append("Faculty Number: ").append(this.facultyNumber);

        return sb.toString();
    }
}
