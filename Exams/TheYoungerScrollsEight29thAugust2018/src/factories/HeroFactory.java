package factories;

import heroes.endurance.Nord;
import heroes.endurance.Orc;
import heroes.strength.Khajiit;
import heroes.strength.Redguard;
import heroes.willpower.Breton;
import heroes.willpower.Dunmer;
import interfaces.Factory;
import interfaces.Hero;

public class HeroFactory implements Factory<Hero> {
    private static final String NO_SUCH_HERO_MESSAGE = "No such hero type!";

    //ADD_HERO: G6 Breton Lary 100 240 80
    //•	ADD_HERO: {guildName} {heroType} {heroName} {health} {fatigue} {magicka}
    @Override
    public Hero create(String... args) {
        String name = args[3];
        int health = Integer.parseInt(args[4]);
        int fatigue = Integer.parseInt(args[5]);
        int magicka = Integer.parseInt(args[6]);

        String heroType = args[2];
        switch (heroType) {
            case "Nord":
                return new Nord(name, magicka, fatigue, health);

            case "Orc":
                return new Orc(name, magicka, fatigue, health);

            case "Khajiit":
                return new Khajiit(name, magicka, fatigue, health);

            case "Redguard":
                return new Redguard(name, magicka, fatigue, health);

            case "Breton":
                return new Breton(name, magicka, fatigue, health);

            case "Dunmer":
                return new Dunmer(name, magicka, fatigue, health);

            default:
                throw new IllegalArgumentException(NO_SUCH_HERO_MESSAGE);
        }
    }
}
