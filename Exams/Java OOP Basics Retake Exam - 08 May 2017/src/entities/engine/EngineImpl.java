package entities.engine;

import contracts.*;
import entities.managers.AvatarManager;

public class EngineImpl implements Engine {
    private InputReader reader;
    private OutputWriter writer;
    private Manager manager;

    public EngineImpl(InputReader reader, OutputWriter writer,
                      Factory<Bender> benderFactory, Factory<Monument> monumentFactory) {
        this.reader = reader;
        this.writer = writer;

        this.manager = new AvatarManager(benderFactory, monumentFactory); //looks bad //TODO fix
    }

    @Override
    public void run() {
        String line;

        while (!"Quit".equals(line = this.reader.readLine())) {
            String[] args = line.split(" ");

            String command = args[0];

            switch (command) {
                case "Bender":
                    this.manager.bender(args);
                    break;

                case "Monument":
                    this.manager.monument(args);
                    break;

                case "War":
                    this.manager.war(args);
                    break;

                case "Status":
                    this.writer.writeLine(this.manager.status(args));
                    break;
            }
        }

        this.writer.writeLine(this.manager.quit());
    }
}
