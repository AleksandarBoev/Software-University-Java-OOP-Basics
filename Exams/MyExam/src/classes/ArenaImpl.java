package classes;

import interfaces.Arena;
import interfaces.ComicCharacter;

import java.util.ArrayList;
import java.util.List;

public class ArenaImpl implements Arena {
    private String arenaName;
    private List<ComicCharacter> heroes; //contains the heroes fighting in the THIS arena
    private List<ComicCharacter> antiheroes;
    private int capacity; //holds the maximum number of characters that can participate;

    public ArenaImpl(String arenaName, int capacity) {
        this.arenaName = arenaName;
        this.heroes = new ArrayList<>();
        this.antiheroes = new ArrayList<>();
        this.capacity = capacity;
    }

    @Override
    public String getArenaName() {
        return this.arenaName;
    }

    @Override
    public boolean isArenaFull() {
        int charactersCount = this.heroes.size() + this.antiheroes.size();

        if (this.capacity == charactersCount) {
            return true;
        } else if (this.capacity < charactersCount) {
            throw new IllegalArgumentException("You messed up somewhere! Characters count is more than the capacity!");
        } else {
            return false;
        }
    }

    @Override
    public void addHero(ComicCharacter hero) {
        this.heroes.add(hero); //validations if arena is full are made in "addHeroToArena" method in "WarManager" class
    }

    @Override
    public void addAntiHero(ComicCharacter antiHero) {
        this.antiheroes.add(antiHero);
    }

    @Override
    public boolean fightHeroes() {
        //no reason for removing dead characters after 1vs1 every battle. Its better after every team battle
        int turn;
        if (this.heroes.size() >= this.antiheroes.size()) {
            turn = 0; //every even turn the antiheroes will attack
        } else {
            turn = 1;
        }

        while (!this.heroes.isEmpty() && !this.antiheroes.isEmpty()) {
            if (turn % 2 == 0) { // antiheroes attack
                for (int i = 0; i < Math.min(this.heroes.size(), this.antiheroes.size()); i++) {
                    double attackerAttackPower = this.antiheroes.get(i).attack();
                    this.heroes.get(i).takeDamage(attackerAttackPower);
                }
                this.removeDeadHeroes();

            } else { //heroes attack
                for (int i = 0; i < Math.min(this.heroes.size(), this.antiheroes.size()); i++) {
                    double attackerAttackPower = this.heroes.get(i).attack();
                    this.antiheroes.get(i).takeDamage(attackerAttackPower);
                }
                this.removeDeadAntiHeroes();
            }

            turn++;
        }

        if (this.heroes.isEmpty()) {
            return false; //bad guys win
        } else {
            return true; //good guys win
        }

    }

    //____________________________________________MY_METHODS____________________________________________________________
    private void removeDeadHeroes() {
        List<ComicCharacter> survivors = new ArrayList<>();

        for (ComicCharacter hero : this.heroes) {
            if (!hero.isDead()) {
                survivors.add(hero);
            }
        }

        this.heroes = survivors;
    }

    private void removeDeadAntiHeroes() {
        List<ComicCharacter> survivors = new ArrayList<>();

        for (ComicCharacter antihero : this.antiheroes) {
            if (!antihero.isDead()) {
                survivors.add(antihero);
            }
        }

        this.antiheroes = survivors;
    }

    @Override
    public boolean hasHero(String heroName) {
        for (ComicCharacter hero : this.heroes) {
            if (hero.getName().equals(heroName)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean isEmpty() {
        return this.antiheroes.isEmpty() && this.heroes.isEmpty();
    }

    @Override
    public boolean hasAntihero(String antiheroName) {
        for (ComicCharacter antihero : this.antiheroes) {
            if (antihero.getName().equals(antiheroName)) {
                return true;
            }
        }

        return false;
    }
}
