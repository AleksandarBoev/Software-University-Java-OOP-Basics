package p06_birthdayCelebrations;

public class Robot implements CheckIdInterface {
    private String model;
    private String id;

    public Robot(String model, String id) {
        this.model = model;
        this.id = id;
    }

    @Override
    public boolean idIsFake(String fakeIdIdentificator) {
        return id.endsWith(fakeIdIdentificator);
    }

    @Override
    public String getId() {
        return this.id;
    }
}
