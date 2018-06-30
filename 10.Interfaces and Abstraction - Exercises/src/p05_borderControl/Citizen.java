package p05_borderControl;

public class Citizen implements CheckIdInterface {
    private String name;
    private int age;
    private String id;

    public Citizen(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public boolean idIsFake(String fakeIdIndicator) {
        return id.endsWith(fakeIdIndicator);
    }

    @Override
    public String getId() {
        return this.id;
    }
}
