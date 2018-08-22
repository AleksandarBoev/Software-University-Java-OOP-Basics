package abstract_classes;

import contracts.Bender;
import contracts.Monument;
import contracts.Nation;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseNation implements Nation {
    private List<Bender> benders;
    private List<Monument> monuments;

    protected BaseNation() {
        this.benders = new ArrayList<>();
        this.monuments = new ArrayList<>();
    }

    protected List<Bender> getBenders() {
        return this.benders;
    }

    protected List<Monument> getMonuments() {
        return this.monuments;
    }

    @Override
    public void addBender(Bender bender) {
        this.benders.add(bender);
    }

    @Override
    public void addMonument(Monument monument) {
        this.monuments.add(monument);
    }

    @Override
    public void getWipedOut() {
        this.monuments.clear();
        this.benders.clear();
    }

    @Override
    public double getTotalPower() {
        //For example: If the Air nation has 1000 total power and you have 2 AirMonuments –
        // one with 100 airAffinity and the other with 200 airAffinity.
        // The sum of their affinities is 300 airAffinity.
        // That means you must increase the total power of the Air nation by 300%.
        //So you must increase the total power by (1000 / 100) * 300 = 3000. That would result in 1000 + 3000 = 4000.

        double totalBenderPower = this.benders.stream().mapToDouble(b -> b.calculatePower()).sum();
        long totalMonumentAffinity = this.monuments.stream().mapToLong(m -> m.getAffinity()).sum();

        return (totalBenderPower / 100.0) * totalMonumentAffinity;
    }

    @Override
    public String toString() {
        //Fire Nation
        //Benders: (None)
        //###Fire Bender: Donald, Power: 100, Heat Aggression: 214.40
        //Monuments: (None)
        //###Fire Monument: JerseyGrew, Fire Affinity: 1000

        StringBuilder sb = new StringBuilder();
        sb.append("Benders:");

        if (this.benders.isEmpty()) {
            sb.append(" None").append(System.lineSeparator());
        } else {
            sb.append(System.lineSeparator());
            for (Bender bender : this.benders) {
                sb.append(bender.toString()).append(System.lineSeparator());
            }
        }

        sb.append("Monuments:");

        if (this.monuments.isEmpty()) {
            sb.append(" None").append(System.lineSeparator());
        } else {
            sb.append(System.lineSeparator());
            for (Monument monument : this.monuments) {
                sb.append(monument.toString()).append(System.lineSeparator());
            }
        }

        return sb.toString().substring(0, sb.toString().length() - 1);
    }
}
