package engine;

import classes.*;
import interfaces.Arena;
import interfaces.ComicCharacter;
import interfaces.SuperPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine {
    WarManager warManager;

    public Engine() {
        this.warManager = new WarManager();
    }

    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (!"WAR_IS_OVER".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "CHECK_CHARACTER":
                    //  CHECK_CHARACTER <character name>
                    System.out.println(this.warManager.checkComicCharacter(tokens[1]));
                    break;

                case "REGISTER_HERO":
                    //	REGISTER_HERO <character name> <type> <energy> <health> <intelligence> <heroism>
                    String heroName = tokens[1];
                    String heroType = tokens[2];
                    int energy = Integer.parseInt(tokens[3]);
                    double health = Double.parseDouble(tokens[4]);
                    double intelligence = Double.parseDouble(tokens[5]);
                    double heroism = Double.parseDouble(tokens[6]);

                    ComicCharacter hero = null;

                    try {
                        switch (heroType) {
                            case "DCHero":
                                hero = new DCHero(heroName, energy, health, intelligence, heroism);
                                break;

                            case "MarvelHero":
                                hero = new MarvelHero(heroName, energy, health, intelligence, heroism);
                                break;
                        }
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                        break;
                    }

                    //TODO which is better? Catch the exception here or catch it in the method "addHero" and return the error msg
                    System.out.println(this.warManager.addHero(hero));
                    break;


                case "REGISTER_ANTI_HERO":
                    //  REGISTER_ANTI_HERO <character name> <type> <energy> <health> <intelligence> <evilness>
                    String antiheroName = tokens[1];
                    String antiheroType = tokens[2];
                    energy = Integer.parseInt(tokens[3]);
                    health = Double.parseDouble(tokens[4]);
                    intelligence = Double.parseDouble(tokens[5]);
                    double evilness = Double.parseDouble(tokens[6]);

                    ComicCharacter antihero = null;
                    try {

                        switch (antiheroType) {
                            case "Villain":
                                antihero = new Villain(antiheroName, energy, health, intelligence, evilness);
                                break;

                            case "Titan":
                                antihero = new Titan(antiheroName, energy, health, intelligence, evilness);
                                break;
                        }
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                        break;
                    }

                    System.out.println(this.warManager.addAntiHero(antihero));
                    break;

                case "BUILD_ARENA":
                    //  BUILD_ARENA <arena name> <capacity>
                    String arenaName = tokens[1];
                    int arenaCapacity = Integer.parseInt(tokens[2]);

                    Arena currentArena = new ArenaImpl(arenaName, arenaCapacity);
                    System.out.println(this.warManager.addArena(currentArena));
                    break;

                case "SEND_HERO":
                    //  SEND_HERO <arena name> <hero name>
                    arenaName = tokens[1];
                    heroName = tokens[2];

                    System.out.println(this.warManager.addHeroToArena(arenaName, heroName));
                    break;

                case "SEND_ANTI_HERO":
                    //  SEND_ANTI_HERO <arena name> <anti hero name>
                    arenaName = tokens[1];
                    antiheroName = tokens[2];

                    System.out.println(this.warManager.addAntiHeroToArena(arenaName, antiheroName));
                    break;

                case "SUPER_POWER":
                    //  SUPER_POWER <super power name> <power points>
                    String superPowerName = tokens[1];
                    double powerPoints = Double.parseDouble(tokens[2]);

                    try {
                        SuperPower currentSuperPower = new Power(superPowerName, powerPoints);
                        System.out.println(this.warManager.loadSuperPowerToPool(currentSuperPower));
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;

                case "ASSIGN_POWER":
                    //  ASSIGN_POWER <comic character name> <super power name>
                    String characterName = tokens[1];
                    superPowerName = tokens[2];

                    System.out.println(this.warManager.assignSuperPowerToComicCharacter(characterName, superPowerName));
                    break;

                case "UNLEASH":
                    //  UNLEASH <comic character name>
                    characterName = tokens[1];
                    System.out.println(this.warManager.usePowers(characterName));
                    break;

                case "COMICS_WAR":
                    //  COMICS_WAR <arena name>
                    arenaName = tokens[1];
                    System.out.println(this.warManager.startBattle(arenaName));
                    break;
            }
        }
        System.out.println(this.warManager.endWar());

        reader.close();
    }
}
