package abstractClasses;

import java.util.ArrayList;
import java.util.List;

public abstract class Race {
    //The basic race has the following properties: length (int), route (string),
    // a prizePool (int), and participants (Collection of Car),
    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants;

    public Race(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new ArrayList<>();
    }
}
