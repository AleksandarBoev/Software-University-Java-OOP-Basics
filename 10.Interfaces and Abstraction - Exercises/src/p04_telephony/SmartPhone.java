package p04_telephony;

public class SmartPhone implements Callable, Browsable {
    private static final String INVALID_PHONE_NUMBER_MESSAGE = "Invalid number!";
    private static final String INVALID_URL_MESSAGE = "Invalid URL!";

    private String number;

    public SmartPhone(String number) {
        this.number = number;
    }

    public String getNumber() {
        return this.number;
    }

    @Override
    public void browseWebsite(String website) { // TODO see why the commented part gives max points, and the uncommented part doesn't
//        for (int i = 0; i < website.length(); i++) {
//            if (Character.isDigit(website.charAt(i))) {
//                System.out.println(INVALID_URL_MESSAGE);
//                return;
//            }
//        }
//        System.out.printf("Browsing: %s!%n", website);

        if (website.matches("[^0-9]*")) {
            System.out.printf("Browsing: %s!%n", website);
        } else {
            System.out.println(INVALID_URL_MESSAGE);
        }
    }

    @Override
    public void call(SmartPhone phone) {
//        for (int i = 0; i < phone.getNumber().length(); i++) {
//            if (!Character.isDigit(phone.getNumber().charAt(i))) {
//                System.out.println(INVALID_PHONE_NUMBER_MESSAGE);
//                return;
//            }
//        }
//
//        System.out.printf("Calling... %s%n", phone.getNumber());

        if (phone.getNumber().matches("[0-9]*")) {
            System.out.printf("Calling... %s%n", phone.getNumber());
        } else {
            System.out.println(INVALID_PHONE_NUMBER_MESSAGE);
        }
    }
}
