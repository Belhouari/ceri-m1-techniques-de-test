package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IPokemonTrainerFactoryTest {

    IPokemonMetadataProvider iPokemonMetadataProvider;
    IPokemonFactory iPokemonFactory;
    IPokedexFactory iPokedexFactory;
    IPokedex iPokedex;
    IPokemonTrainerFactory iPokemonTrainerFactory;
    PokemonTrainer trainer;

    @BeforeEach
    void initPokemonTrainer() {
        iPokemonMetadataProvider = new PokemonMetadataProvider();
        iPokemonFactory = new PokemonFactory(iPokemonMetadataProvider);
        iPokedexFactory = new PokedexFactory();
        iPokedex = new Pokedex(iPokemonMetadataProvider, iPokemonFactory);

        trainer = new PokemonTrainerFactory().createTrainer("Sacha", Team.INSTINCT, iPokedexFactory);
    }

    @Test
    void getTrainer() {
        assertEquals(PokemonTrainer.class,new PokemonTrainerFactory().createTrainer("Mysterious man", Team.MYSTIC, iPokedexFactory).getClass());
    }

    @Test
    void getTrainerName() {
        assertEquals(trainer.getName(),trainer.getName());
    }

    @Test
    void getTrainerTeam() {
        assertEquals(trainer.getTeam(),trainer.getTeam());
    }

    @Test
    void getPokedexTeam() {
        assertEquals(trainer.getPokedex(),trainer.getPokedex());
    }
}