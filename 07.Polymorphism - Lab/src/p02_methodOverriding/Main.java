package p02_methodOverriding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashSet<Rectangle> setOfRectangles = new LinkedHashSet<>();

        int numberOfInputs = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfInputs; i++) {
            String[] tokens = reader.readLine().split(" ");

            Rectangle rectangleOrSquare = null;

            if (tokens.length == 2) {
                rectangleOrSquare = new Rectangle(Double.parseDouble(tokens[0]), Double.parseDouble(tokens[1]));
                //rectangle can be created with just one parameter because the protected one parameter constructor is in the same package as the Main class
                //if they weren't in the same package, rectangle could be created only with the two parameter constructor
            } else {
                rectangleOrSquare = new Square(Double.parseDouble(tokens[0]));
            }

            setOfRectangles.add(rectangleOrSquare);
        }

        for (Rectangle rectangleOrSquare : setOfRectangles) {
            System.out.println(rectangleOrSquare.getArea());
        }

        //main ends here
    }
}
