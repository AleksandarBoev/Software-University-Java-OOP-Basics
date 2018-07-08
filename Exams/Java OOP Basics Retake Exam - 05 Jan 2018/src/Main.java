import engine.Engine;
import javafx.collections.transformation.SortedList;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        //TODO possible problem why I/O tests are not passing: some age calculations could be exclusive/inclusive
        Engine engine = new Engine();
        engine.start();
    }
}
