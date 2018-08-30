package comparators;

import interfaces.GuildInterface;

import java.util.Comparator;

public class GuildComparatorByPowerDescendingNameAscending implements Comparator<GuildInterface> {
    @Override
    public int compare(GuildInterface o1, GuildInterface o2) {
        int comparisonResult = Double.compare(o2.getGuildPower(), o1.getGuildPower());
        if (comparisonResult != 0) {
            return comparisonResult;
        }

        comparisonResult = o1.getName().compareTo(o2.getName());

        return comparisonResult;
    }

}
