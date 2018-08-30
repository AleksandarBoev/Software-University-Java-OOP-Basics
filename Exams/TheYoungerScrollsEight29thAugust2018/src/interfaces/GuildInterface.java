package interfaces;

public interface GuildInterface {
    String getName();

    String addHero(Hero hero);

    String removeHero(Hero hero);

    Hero getHeroByName(String heroName);

    Long getGuildSize();

    double getGuildPower();

    String getGuildSpecialization();
}
