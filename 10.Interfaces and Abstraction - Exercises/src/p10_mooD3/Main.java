package p10_mooD3;

import p10_mooD3.classes.Archangel;
import p10_mooD3.classes.Demon;
import p10_mooD3.interfaces.IGameObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//"KoHaH" | Demon | 100.0 | 100
        String[] tokens = reader.readLine().split(" \\| ");
        reader.close();

        IGameObjects gameObject = null;

        String name = tokens[0];
        String type = tokens[1];
        double specialPoints = Double.parseDouble(tokens[2]);
        int level = Integer.parseInt(tokens[3]);

        switch (type) {
            case "Demon":
                gameObject = new Demon(name, level, specialPoints);
                break;

            case "Archangel":
                gameObject = new Archangel(name, level, (int)specialPoints);
                break;
        }

        System.out.println(gameObject.toString());
    }
}
