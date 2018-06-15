package p08_pokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String input;
        while(!"Tournament".equals(input = reader.readLine())) {
            //“<TrainerName> <PokemonName> <PokemonElement> <PokemonHealth>
            String[] tokens = input.split(" ");

            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon currentPokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            if (!trainers.containsKey(trainerName)) {
                List<Pokemon> pokemons = new ArrayList<>();
                Trainer currentTrainer = new Trainer(trainerName, pokemons);
                trainers.put(trainerName, currentTrainer);
            }

            trainers.get(trainerName).getPokemons().add(currentPokemon);
        }

        String pokemonElement;
        while(!"End".equals(pokemonElement = reader.readLine())) {
            for (Trainer trainer : trainers.values()) {
                trainer.checkElement(pokemonElement);
            }
        }

        trainers.values().stream()
                .sorted((t1, t2) -> {
                    return Integer.compare(t2.getNumberOfBadges(), t1.getNumberOfBadges());
                }).forEach(t -> {
            System.out.printf("%s %d %d%n", t.getName(), t.getNumberOfBadges(), t.getPokemons().size());
        });

        //main ends here
    }
}
