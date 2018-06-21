package p03_mankind;

public class Worker extends Human {
    private static final String LESS_THAN_FOUR_LETTERS_LAST_NAME_MESSAGE = "Expected length more than 3 symbols!Argument: lastName";
    private static final String LESS_THAN_10_WEEKLY_SALARY_MESSAGE = "Expected value mismatch!Argument: weekSalary";
    private static final String NOT_BETWEEN_1_AND_12_WORK_HOURS_MESSAGE = "Expected value mismatch!Argument: workHoursPerDay";

    private double weeklySalary;
    private double workHoursPerDay;

    public Worker(String firstName, String lastName, double weeklySalary, double workHoursPerDay) {
        super(firstName, lastName);
        this.setWeeklySalary(weeklySalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    @Override
    protected void setLastName(String lastName) {
        if (lastName.length() < 4) {
            throw new IllegalArgumentException(LESS_THAN_FOUR_LETTERS_LAST_NAME_MESSAGE);
        }

        this.lastName = lastName;
    }

    private void setWeeklySalary(double weeklySalary) {
        if (weeklySalary < 10) {
            throw new IllegalArgumentException(LESS_THAN_10_WEEKLY_SALARY_MESSAGE);
        }

        this.weeklySalary = weeklySalary;
    }

    private void setWorkHoursPerDay(double workHoursPerDay) {
        if (workHoursPerDay < 1 || workHoursPerDay > 12) {
            throw new IllegalArgumentException(NOT_BETWEEN_1_AND_12_WORK_HOURS_MESSAGE);
        }

        this.workHoursPerDay = workHoursPerDay;
    }

    private double calculateSalaryPerHour() {
        return this.weeklySalary / (this.workHoursPerDay * 7);
    }

    public String getSalaryPerHourToSecondDigit() {
        return String.format("%.2f", this.calculateSalaryPerHour());
    }

    public String getWeekSalaryToSecondDigit() {
        return String.format("%.2f", this.weeklySalary);
    }

    public String getWorkHoursPerDayToSecondDigit() {
        return String.format("%.2f", this.workHoursPerDay);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());

        sb.append("Week Salary: ").append(this.getWeekSalaryToSecondDigit()).append(System.lineSeparator());
        sb.append("Hours per day: ").append(this.getWorkHoursPerDayToSecondDigit()).append(System.lineSeparator());
        sb.append("Salary per hour: ").append(this.getSalaryPerHourToSecondDigit());

        return sb.toString();
    }
}
