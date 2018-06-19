package p05_randomArrayList;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new RandomArrayList() {{
            add("One");
            add("Two");
            add("Three");
            add("Four");
            add("Five");
            add("Six");
        }};

        System.out.println(((RandomArrayList) list).getRandomElement());
    }
}
