package p04_telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] phoneNumbers = reader.readLine().split(" ");
        List<SmartPhone> phones = new ArrayList<>();
        for (String phoneNumber : phoneNumbers) {
            SmartPhone currentPhone = new SmartPhone(phoneNumber);
            phones.add(currentPhone);
        }

        String[] websites = reader.readLine().split(" ");
        reader.close();

        Callable phoneForCalling = new SmartPhone("000");
        for (SmartPhone phone : phones) {
            phoneForCalling.call(phone);
        }

        Browsable phoneForBrowsing = new SmartPhone("000");
        for (String website : websites) {
            phoneForBrowsing.browseWebsite(website);
        }
    }
}
