package demo;

public class Person implements Admin, User {
    private String name;
    private String email;
    private String password;
    private String creditCardNumber;

    public Person(String name, String email, String password, String creditCardNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getCreditCardNumber() {
        return this.creditCardNumber;
    }
}
