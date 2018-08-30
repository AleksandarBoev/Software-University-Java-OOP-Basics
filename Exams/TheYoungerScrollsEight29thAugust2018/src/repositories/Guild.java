package repositories;

import interfaces.GuildInterface;
import interfaces.Hero;

import java.util.*;
import java.util.stream.Collectors;

public class Guild implements GuildInterface {
    private static final String ADDED_HERO_MESSAGE = "Added hero: %s";
    private static final String UPDATED_HERO_MESSAGE = "Updated hero: %s";
    private static final String UPDATE_FAILED_HERO_MESSAGE = "Hero %s can not be replaced by a weaker one.";
    private static final String REMOVED_HERO_MESSAGE = "Successfully removed hero [%s] from guild %s";
    private static final String NO_SUCH_HERO_HERO_MESSAGE = "No such hero in this guild!";

    private String name;
    private Map<String, Hero> nameHero;

    public Guild(String name) {
        this.name = name;
        this.nameHero = new LinkedHashMap<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String addHero(Hero hero) {
        String heroName = hero.getName();

        if (!this.nameHero.containsKey(heroName)) {
            this.nameHero.put(heroName, hero);
            return String.format(ADDED_HERO_MESSAGE, heroName);
        } else {
            double newHeroTotalPoints = hero.getTotalPoints();
            double oldHeroTotalPoints = this.nameHero.get(heroName).getTotalPoints();

            if (newHeroTotalPoints > oldHeroTotalPoints) {
                this.nameHero.put(heroName, hero);
                return String.format(UPDATED_HERO_MESSAGE, heroName);
            } else { //newHeroTotalPoints <= oldHeroTotalPoints
                return String.format(UPDATE_FAILED_HERO_MESSAGE, heroName);
            }
        }
    }

    @Override
    public String removeHero(Hero hero) {
        String heroName = hero.getName();
        if (this.nameHero.containsKey(heroName)) {
            this.nameHero.remove(heroName);
            return String.format(REMOVED_HERO_MESSAGE, heroName, this.name);
        } else {
            return NO_SUCH_HERO_HERO_MESSAGE;
        }
    }

    @Override
    public	Hero getHeroByName(String heroName) {
        if (!this.nameHero.containsKey(heroName)) {
            return null;
        } else {
            return this.nameHero.get(heroName);
        }
    }

    @Override
    public Long getGuildSize()  { //is long because probably in the end all guilds will be summed and summing ints could overflow
        return (long)this.nameHero.size();
    }

    @Override
    public double getGuildPower() {
        return this.nameHero.values().stream()
                .mapToDouble(h -> h.getTotalPoints())
                .sum();
    }

    //TODO so... where is this method used?
    @Override
    public String getGuildSpecialization() { //there's probably a smarter, more efficient way of doing this
        Map<String, Set<Hero>> birthSignHeroes = new LinkedHashMap<>();
        birthSignHeroes.put("Willpower", new HashSet<>());
        birthSignHeroes.put("Endurance", new HashSet<>());
        birthSignHeroes.put("Strength", new HashSet<>());

        for (Hero hero : this.nameHero.values()) {
            String className = hero.getClass().getSimpleName();

            if ("Breton".equals(className) || "Dunmer".equals(className)) {
                birthSignHeroes.get("Willpower").add(hero);

            } else if ("Khajiit".equals(className) || "Redguard".equals(className)) {
                birthSignHeroes.get("Strength").add(hero);

            } else if ("Nord".equals(className) || "Orc".equals(className)) {
                birthSignHeroes.get("Endurance").add(hero);
            }
        }

        int mostHeroes = birthSignHeroes.values().stream().mapToInt(s -> s.size()).max().getAsInt();
        String result = birthSignHeroes.entrySet().stream()
                .filter(kvp -> kvp.getValue().size() == mostHeroes)
                .sorted((kvp1, kvp2) -> {
                    Double set1TotalPoints = kvp1.getValue().stream().mapToDouble(h -> h.getTotalPoints()).sum();
                    Double set2TotalPoints = kvp2.getValue().stream().mapToDouble(h -> h.getTotalPoints()).sum();

                    return set2TotalPoints.compareTo(set1TotalPoints);
                }).map(kvp -> kvp.getKey())
                .findFirst()
                .get();

        return result;
    }


    private void addHeroToBirthSignCollection(Hero hero) {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Guild: ").append(this.name).append(System.lineSeparator());

        if (this.nameHero.isEmpty()) {
            sb.append("###Heroes: None");
            return sb.toString();
        }

        this.nameHero.values().stream()
                .sorted((h1, h2) -> {
                    int comparisonResult = Double.compare(h2.getTotalPoints(), h1.getTotalPoints());

                    if (comparisonResult != 0)
                        return comparisonResult;

                    comparisonResult = h1.getName().compareTo(h2.getName());
                    return comparisonResult;
                }).forEach(h -> {
                    sb.append(this.heroToString(h)).append(System.lineSeparator());
        });

        return sb.toString().trim();
    }

    private String heroToString(Hero hero) {
        return String.format("Hero: %s, Offense: %.2f, Defense: %.2f",
                hero.getName(), hero.getOffense(), hero.getDefense());
    }
}
