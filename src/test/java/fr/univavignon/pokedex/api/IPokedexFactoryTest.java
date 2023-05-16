package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IPokedexFactoryTest {

    IPokemonMetadataProvider iPokemonMetadataProvider;
    IPokemonFactory iPokemonFactory;
    IPokedexFactory iPokedexFactory;

    @BeforeEach
    void initPokemon() {

        iPokemonMetadataProvider = new PokemonMetadataProvider();
        iPokemonFactory = new PokemonFactory(iPokemonMetadataProvider);
        iPokedexFactory = new PokedexFactory();
    }

    @Test
    void createPokedex() {
        assertEquals(Pokedex.class, iPokedexFactory.createPokedex(iPokemonMetadataProvider, iPokemonFactory).getClass());
    }

}