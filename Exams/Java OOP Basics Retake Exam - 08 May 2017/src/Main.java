import contracts.*;
import entities.engine.EngineImpl;
import entities.factories.BenderFactory;
import entities.factories.MonumentFactory;
import entities.io.ConsoleReader;
import entities.io.ConsoleWriter;

public class Main {
    public static void main(String[] args) {
        InputReader reader = new ConsoleReader();
        OutputWriter writer = new ConsoleWriter();
        Factory<Bender> benderFactory = new BenderFactory();
        Factory<Monument> monumentFactory = new MonumentFactory();

        Engine engine = new EngineImpl(reader, writer, benderFactory, monumentFactory);
        engine.run();
    }
}
