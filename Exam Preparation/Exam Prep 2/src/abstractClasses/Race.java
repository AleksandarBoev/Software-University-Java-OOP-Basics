package abstractClasses;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public int getLength() {
        return this.length;
    }

    public String getRoute() {
        return this.route;
    }

    private int getPrizePool() {
        return this.prizePool;
    }

    public List<Car> getParticipants() {
        return this.participants;
    }

    public abstract Integer calculatePerformancePoints(Car car);

    public void sortParticipants() { //works
        this.participants = this.getParticipants().stream()
                .sorted((p1, p2) -> {
                    return calculatePerformancePoints(p2).compareTo(calculatePerformancePoints(p1));
                }).collect(Collectors.toList());
    }

    public int[] getPrizes() {
        //The 1st place winner takes 50 % of the race’s prize pool.
        //The 2nd place winner takes 30 % of the race’s prize pool.
        //The 3rd place winner takes 20 % of the race’s prize pool.
        //50% of X is EQUAL to (X * 50) / 100.
        int[] result = new int[3];
        result[0] = (this.getPrizePool() * 50) / 100;
        result[1] = (this.getPrizePool() * 30) / 100;
        result[2] = (this.getPrizePool() * 20) / 100;

        return result;
    }
}
