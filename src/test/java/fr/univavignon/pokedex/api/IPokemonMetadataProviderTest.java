package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IPokemonMetadataProviderTest {

    IPokemonMetadataProvider iPokemonMetadataProvider;
    PokemonMetadata bulbizarre;
    PokemonMetadata aquali;

    @BeforeEach
    void initPokemon() {
        iPokemonMetadataProvider = new PokemonMetadataProvider();
        bulbizarre = new PokemonMetadata(0,"Bulbizarre", 126, 126, 90);
        aquali = new PokemonMetadata(133,"Aquali", 186, 168, 260);
    }

    @Test
    void getBulbizarreMetadata() throws PokedexException {
        assertEquals(bulbizarre.getClass(),iPokemonMetadataProvider.getPokemonMetadata(bulbizarre.getIndex()).getPokemonMetadata(bulbizarre.getIndex()).getClass());
    }

    @Test
    void getAqualiMetadata() throws PokedexException {
        assertEquals(aquali.getClass(),iPokemonMetadataProvider.getPokemonMetadata(aquali.getIndex()).getPokemonMetadata(aquali.getIndex()).getClass());
    }

    @Test
    void getIndexBulbizarre() throws PokedexException {
        assertEquals(bulbizarre.getIndex(),iPokemonMetadataProvider.getPokemonMetadata(bulbizarre.getIndex()).getIndex());
    }

    @Test
    void getIndexAquali() throws PokedexException {
        assertEquals(aquali.getIndex(),iPokemonMetadataProvider.getPokemonMetadata(aquali.getIndex()).getIndex());
    }

    @Test
    void getNameBulbizarreMetadata() throws PokedexException{
        assertEquals(bulbizarre.getName(),iPokemonMetadataProvider.getPokemonMetadata(bulbizarre.getIndex()).getName());
    }

    @Test
    void getNameAqualiMetadata() throws PokedexException{
        assertEquals(aquali.getName(),iPokemonMetadataProvider.getPokemonMetadata(aquali.getIndex()).getName());
    }

    @Test
    void getAttackBulbizarreMetadata() throws PokedexException{
        assertEquals(bulbizarre.getAttack(),iPokemonMetadataProvider.getPokemonMetadata(bulbizarre.getIndex()).getAttack());
    }

    @Test
    void getAttackAqualiMetadata() throws PokedexException{
        assertEquals(aquali.getAttack(),iPokemonMetadataProvider.getPokemonMetadata(aquali.getIndex()).getAttack());
    }

    @Test
    void getDefenseBulbizarreMetadata() throws PokedexException{
        assertEquals(bulbizarre.getDefense(),iPokemonMetadataProvider.getPokemonMetadata(bulbizarre.getIndex()).getDefense());
    }

    @Test
    void getDefenseAqualiMetadata() throws PokedexException{
        assertEquals(aquali.getDefense(),iPokemonMetadataProvider.getPokemonMetadata(aquali.getIndex()).getDefense());
    }

    @Test
    void getStaminaBulbizarreMetadata() throws PokedexException{
        assertEquals(bulbizarre.getStamina(),iPokemonMetadataProvider.getPokemonMetadata(bulbizarre.getIndex()).getStamina());
    }

    @Test
    void getStaminaAqualiMetadata() throws PokedexException{
        assertEquals(aquali.getStamina(),iPokemonMetadataProvider.getPokemonMetadata(aquali.getIndex()).getStamina());
    }

    @Test
    void getPokedexException() {
        for(int i=-10; i <= -1; i++) {
            int negatif = i;
            assertThrows(PokedexException.class, () ->  iPokemonMetadataProvider.getPokemonMetadata(negatif));
        }
        for(int i=151; i <= 160; i++) {
            int auDessus = i;
            assertThrows(PokedexException.class, () ->  iPokemonMetadataProvider.getPokemonMetadata(auDessus));
        }
    }

}