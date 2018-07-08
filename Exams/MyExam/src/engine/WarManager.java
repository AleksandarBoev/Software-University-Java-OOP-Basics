package engine;

import interfaces.Arena;
import interfaces.ComicCharacter;
import interfaces.Manager;
import interfaces.SuperPower;

import java.util.LinkedHashMap;
import java.util.Map;

public class WarManager implements Manager {
    private int heroesBattlesWonCount;
    private int antiheroesBattlesWonCount;
    private Map<String, Arena> nameArena;
    private Map<String, ComicCharacter> nameHero;
    private Map<String, ComicCharacter> nameAntihero;
    private Map<String, SuperPower> nameSuperPower;

    public WarManager() {
        this.heroesBattlesWonCount = 0;
        this.antiheroesBattlesWonCount = 0;
        this.nameArena = new LinkedHashMap<>(); //could be ordinary HashMap
        this.nameHero = new LinkedHashMap<>();
        this.nameAntihero = new LinkedHashMap<>();
        this.nameSuperPower = new LinkedHashMap<>();
    }

    @Override //checked
    public String checkComicCharacter(String characterName) { //checks heroes and antiheroes
        // "<characterName> has fallen in battle!" --> so all heroes should be save onto a single collection?
        ComicCharacter currentCharacter = this.getCharacter(characterName);

        if (currentCharacter.isDead()) {
            return String.format("%s has fallen in battle!", currentCharacter.getName());
        } else {
            return currentCharacter.toString();
        }
    }

    @Override //checked
    public String addHero(ComicCharacter hero) {
        //•	"{hero name} is ready for battle!" or
        //•	"{hero name} evolved!"

        //•	ADDS a hero with the given name
        //•	RETURNS message "<hero name> is ready for battle!"
        //•	IF a hero with the same name already exists,BOOST all of his old parameters
        // (energy,health,inteligence) with the new one, returns message "<hero name> evolved!".
        // If some of the parameters are not correct return the appropriate message.
        // The order of changing the parameters should be energy,health,intelligence.

        if (!this.nameHero.containsKey(hero.getName())) {
            this.nameHero.put(hero.getName(), hero);
            return String.format("%s is ready for battle!", hero.getName());
        } else {
            this.nameHero.get(hero.getName()).boostCharacter(hero.getEnergy(), hero.getHealth(), hero.getIntelligence());
            return String.format("%s evolved!", hero.getName());
        }
    }

    @Override //checked
    public String addAntiHero(ComicCharacter antiHero) {
        //•	"{antiHero name} is ready for destruction! or
        //•	"{hero name} is getting stronger!"

        if (!this.nameAntihero.containsKey(antiHero.getName())) {
            this.nameAntihero.put(antiHero.getName(), antiHero);
            return String.format("%s is ready for destruction!", antiHero.getName());
        } else {
            this.nameAntihero.get(antiHero.getName()).boostCharacter(antiHero.getEnergy(), antiHero.getHealth(), antiHero.getIntelligence());
            return String.format("%s is getting stronger!", antiHero.getName());
        }
    }

    @Override //checked
    public String addArena(Arena arena) {
        //•	ADDS an arena with the given name
        //•	RETURNS message "<arena name> is becoming a fighting ground!"
        //•	IF an arena with the same name already exists, returns message
        //"A battle is about to start there!"

        if (!this.nameArena.containsKey(arena.getArenaName())) { //its better to search by key, because of referant types
            this.nameArena.put(arena.getArenaName(), arena);
            return String.format("%s is becoming a fighting ground!", arena.getArenaName());
        } else {
            return String.format("A battle is about to start there!");
        }
    }

    @Override //checked
    public String addHeroToArena(String arenaName, String heroName) {
        //•	"{heroName} is fighting!" or
        //•	"{heroName} is dead!" or
        //•	"Arena is full!" or
        //•	"{heroName} is fighting for your freedom in <arenaName>!"

        //•	IF a hero is already assigned to an arena ,returns message
        //"<heroName> is fighting!"
        //•	IF the hero health is <= 0, returns message "<heroName> is dead!"
        //•	IF the arena capacity is reached , returns message "Arena is full!"
        //•	ELSE adds hero to the arena and , returns message "<heroName> is fighting for your freedom in <arenaName>!"

        Arena currentArena = this.nameArena.get(arenaName);
        ComicCharacter currentCharacter = this.nameHero.get(heroName);

        for (Arena arena : nameArena.values()) {
            if (arena.hasHero(heroName)) {
                return String.format("%s is fighting!", heroName);
            }
        }

        if (this.nameHero.get(heroName).isDead()) {
            return String.format("%s is dead!", heroName);
        }

        if (currentArena.isArenaFull()) {
            return "Arena is full!";
        }

        currentArena.addHero(currentCharacter);
        return String.format("%s is fighting for your freedom in %s!", heroName, arenaName);
    }

    @Override //checked
    public String addAntiHeroToArena(String arena, String antiHeroName) {
        //•	"{antiHeroName} is fighting!" or
        //•	"{antiHeroName} is dead!" or
        //•	"Arena is full!" or
        //•	"{antiHeroName} and his colleagues are trying to take over {arenaName}!"

        Arena currentArena = this.nameArena.get(arena);
        ComicCharacter currentCharacter = this.nameAntihero.get(antiHeroName);

        if (currentArena.hasAntihero(antiHeroName)) {
            return String.format("%s is fighting!", antiHeroName);
        }

        if (this.nameAntihero.get(antiHeroName).isDead()) {
            return String.format("%s is dead!", antiHeroName);
        }

        if (currentArena.isArenaFull()) {
            return "Arena is full!";
        }

        currentArena.addAntiHero(currentCharacter);
        return String.format("%s and his colleagues are trying to take over %s!", antiHeroName, arena);
    }

    @Override //checked
    public String loadSuperPowerToPool(SuperPower superPower) {
        //•	"{super power name} added to pool!" or
        //•	"This super power already exists!"

        //•	IF a super power already exists ,returns message
        //"This super power already exists!"
        //•	ELSE adds super power to pool , returns message "<super power name> added to pool!"
        if (this.nameSuperPower.containsKey(superPower.getName())) {
            return "This super power already exists!";
        } else {
            this.nameSuperPower.put(superPower.getName(), superPower);
            return String.format("%s added to pool!", superPower.getName());
        }
    }

    @Override //checked
    public String assignSuperPowerToComicCharacter(String comicCharacter, String superPower) {
        //•	"{super power name} already assigned!" or
        //•	"{comic character name} has a new super power!"

        //•	IF a super power is already assigned to a ComicCharacter  ,returns message
        //"<super power name> already assigned!"
        //•	ELSE adds super power to ComicCharacter , returns message "<comic character> has a new super power!"
        //•	IMPORTANT : After you assign a super power to a character you can't assign it to any other character

        ComicCharacter currentCharacter = this.getCharacter(comicCharacter);

        if (this.isSuperPowerAssigned(superPower)) {
            return String.format("%s already assigned!", superPower);
        }

        currentCharacter.addSuperPower(this.nameSuperPower.get(superPower));
        return String.format("%s has a new super power!", comicCharacter);
    }

    @Override //checked
    public String usePowers(String characterName) {
        //•	"{comi character name} has no super powers!" or
        //•	"{comic character name} used his super powers!"

        //•	IF the Comic Character doesn't have any powers ,returns message
        //"<comic character name> has no super powers!"
        //•	ELSE return message "<comic character name> used his super powers!"
        ComicCharacter currentCharacter = this.getCharacter(characterName);

        if (!currentCharacter.hasAtLeastOneSuperPower()) {
            return String.format("%s has not super powers!", characterName);
        }

        currentCharacter.useSuperPowers();

        return String.format("%s used his super powers!", characterName);
    }

    @Override //checked
    public String startBattle(String arenaName) {
        //•	"SAFE ZONE !" or
        //•	"Heroes won the battle of {arenaName}!" or
        //•	"Anti Heroes won the battle of {arenaName}!"

        //•	IF the arena has zero participants , returns message "SAFE ZONE!"
        //•	STARTS the battle in the arena
        //•	IF heroes win, returns message "Heroes won the battle of <arenaName>!"
        //•	IF anti heroes win, returns message "Anti Heroes won the battle of <arenaName>!"
        //•	REMOVES the arena

        Arena currentArena = this.nameArena.get(arenaName);
        if (currentArena.isEmpty()) {
            return "SAFE ZONE!";
        }

        this.nameArena.remove(arenaName);
        if (!currentArena.fightHeroes()) {
            this.antiheroesBattlesWonCount++;
            return String.format("Anti Heroes won the battle of %s!", arenaName);
        } else {
            this.heroesBattlesWonCount++;
            return String.format("Heroes won the battle of %s!", arenaName);
        }
    }

    @Override
    public String endWar() {
        //•	IF heroes won battles are more or equal to anti heros, returns message
        // "After <count of all battles> battles our FRIENDLY HEROES WON!"
        //•	ELSE  returns message "WE ARE DOOMED!"
        if (this.heroesBattlesWonCount >= this.antiheroesBattlesWonCount) {
            return String.format("After %d battles our FRIENDLY HEROES WON!",
                    this.antiheroesBattlesWonCount + this.heroesBattlesWonCount);
        } else {
            return "WE ARE DOOMED";
        }
    }

    //___________________________________MY_METHODS_____________________________________________________________________
    private ComicCharacter getCharacter(String characterName) {
        ComicCharacter currentCharacter = null;
        if (this.nameHero.containsKey(characterName)) {
            currentCharacter = this.nameHero.get(characterName);
        } else {
            currentCharacter = this.nameAntihero.get(characterName);
        }

        return currentCharacter;
    }

    private boolean isSuperPowerAssigned(String superPowerName) {
        for (ComicCharacter hero : nameHero.values()) {
            if (hero.hasPower(superPowerName)) {
                return true;
            }
        }

        for (ComicCharacter antihero : nameAntihero.values()) {
            if (antihero.hasPower(superPowerName)) {
                return true;
            }
        }

        return false;
    }
}
