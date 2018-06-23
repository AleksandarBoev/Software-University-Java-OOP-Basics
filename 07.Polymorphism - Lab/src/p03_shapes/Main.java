package p03_shapes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<Shape> shapes = new LinkedHashSet<>();

        int numberOfInputs = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfInputs; i++) {
            String[] tokens = reader.readLine().split(" ");

            if (tokens.length == 2) {
                Shape rectangle = new Rectangle(Double.parseDouble(tokens[0]), Double.parseDouble(tokens[1]));
                shapes.add(rectangle);
            } else {
                Shape circle = new Circle(Double.parseDouble(tokens[0]));
                shapes.add(circle);
            }
        }

        shapes.forEach(shape -> System.out.println(shape));

        //main ends here
    }
}
