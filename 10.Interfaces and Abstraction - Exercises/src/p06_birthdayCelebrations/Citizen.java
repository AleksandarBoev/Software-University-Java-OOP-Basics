package p06_birthdayCelebrations;

public class Citizen implements CheckIdInterface, CheckBirthDateInterface {
    private String name;
    private int age;
    private String id;
    private String birthDate;

    public Citizen(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
    }

    @Override
    public boolean idIsFake(String fakeIdIndicator) {
        return id.endsWith(fakeIdIndicator);
    }

    @Override
    public String getId() {
        return this.id;
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
