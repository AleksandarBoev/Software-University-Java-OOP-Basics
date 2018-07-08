package interfaces;

public interface Arena {
    String getArenaName();

    boolean isArenaFull();

    void addHero(ComicCharacter hero);

    void addAntiHero(ComicCharacter antiHero);

    boolean fightHeroes();

    //_________________________________MY_METHODS_____________________________________________________________
    boolean hasAntihero(String antiheroName);
    boolean hasHero(String heroName);
    boolean isEmpty();
}
