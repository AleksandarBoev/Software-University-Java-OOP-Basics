package interfaces;

public interface Manager {
    String checkComicCharacter(String characterName);

    String addHero(ComicCharacter hero);

    String addAntiHero(ComicCharacter antiHero);

    String addArena(Arena arenaName);

    String addHeroToArena(String arenaName, String heroName);

    String addAntiHeroToArena(String arena, String antiHeroName);

    String loadSuperPowerToPool(SuperPower superPower);

    String assignSuperPowerToComicCharacter(String comicCharacter, String superPower);

    String usePowers(String characterName);

    String startBattle(String arenaName);

    String endWar();

    //_______________________________ADDITIONAL_METHODS_________________________________________________________________

}
