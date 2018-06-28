package p00_shapesDrawing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Drawable circle = new Circle(5);
        Drawable rectangle = new Rectangle(8, 10);

        circle.draw();
        rectangle.draw();

        //main ends here
    }
}
