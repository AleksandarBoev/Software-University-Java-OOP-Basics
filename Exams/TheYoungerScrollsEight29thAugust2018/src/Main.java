import comparators.GuildComparatorByPowerDescendingNameAscending;
import engine.CreationEngine;
import factories.HeroFactory;
import interfaces.*;
import io.ConsoleReader;
import io.ConsoleWriter;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        InputReader consoleReader = new ConsoleReader();
        OutputWriter consoleWriter = new ConsoleWriter();
        Factory<Hero> heroFactory = new HeroFactory();
        Comparator<GuildInterface> guildComparator = new GuildComparatorByPowerDescendingNameAscending();

        CreationEngine engine = new CreationEngine(consoleReader, consoleWriter, heroFactory, guildComparator);
        engine.run();
    }
}
