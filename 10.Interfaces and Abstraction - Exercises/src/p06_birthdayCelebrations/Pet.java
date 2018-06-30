package p06_birthdayCelebrations;

public class Pet implements CheckBirthDateInterface{
    private String name;
    private String birthDate;

    public Pet(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public boolean isBornThisYear(String year) {
        return this.birthDate.endsWith(year);
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }
}
