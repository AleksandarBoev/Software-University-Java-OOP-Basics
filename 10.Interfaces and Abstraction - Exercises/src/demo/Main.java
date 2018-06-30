package demo;

public class Main {
    public static void main(String[] args) {
        Admin personAdmin = new Person("Pesho", "pesho@gmail.com", "password123", "356");
        User personUser = new Person("Pesho", "pesho@gmail.com", "password123", "356");

        ((Person) personUser).getCreditCardNumber(); // userInterface doesn't let me access certain information about a person
        ((Person) personUser).getPassword(); //TODO see if Interfaces are used like this in programming
        personUser.getEmail();
        personUser.getName();

        personAdmin.getCreditCardNumber();
        personAdmin.getPassword();
        personAdmin.getEmail();
        personAdmin.getName();

        //main ends here
    }
}
