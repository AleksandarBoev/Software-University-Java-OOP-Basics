package p08_pokemonTrainer;

import java.util.List;
import java.util.stream.Collectors;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemons;

    public Trainer(String name, List<Pokemon> pokemons) {
        this.name = name;
        this.numberOfBadges = 0;
        this.pokemons = pokemons;
    }

    public String getName() {
        return this.name;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public int getNumberOfBadges() {
        return this.numberOfBadges;
    }

    public void increaseBadgeCount() {
        this.numberOfBadges++;
    }

    private boolean hasElement(String pokemonElement) {
        for (Pokemon pokemon : this.pokemons) {
            if (pokemon.getElement().equals(pokemonElement)) {
                return true;
            }
        }

        return false;
    }

    private void decreaseEveryPokemonsHealthBy10() {
        for (Pokemon pokemon : this.pokemons) {
            pokemon.decreasePokemonHp();
        }
    }

    private void removeDefeatedPokemon() {
        this.pokemons = this.pokemons.stream()
                .filter(p -> p.getHealth() > 0)
                .collect(Collectors.toList());
    }

    public void checkElement(String pokemonElement) {
        if (this.hasElement(pokemonElement)) {
            this.increaseBadgeCount();
        } else {
            this.decreaseEveryPokemonsHealthBy10();
            this.removeDefeatedPokemon();
        }
    }
}
