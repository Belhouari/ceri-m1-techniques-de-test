package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IPokedexTest {

    IPokemonMetadataProvider iPokemonMetadataProvider;
    IPokemonFactory iPokemonFactory;
    List<Pokemon> pokemons;

    IPokedex iPokedex;
    Pokemon bulbizarre;
    Pokemon aquali;

    @BeforeEach
    void initPokemon() {
        iPokemonMetadataProvider = new PokemonMetadataProvider();
        iPokemonFactory = new PokemonFactory(iPokemonMetadataProvider);
        iPokedex = new Pokedex(iPokemonMetadataProvider, iPokemonFactory);

        bulbizarre = new Pokemon(0,"Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        aquali = new Pokemon(133,"Aquali", 186, 168, 260, 2729,202,5000, 4, 100);

        pokemons = new ArrayList<>();
        pokemons.add(bulbizarre);
        pokemons.add(aquali);

        iPokedex.addPokemon(bulbizarre);
        iPokedex.addPokemon(aquali);
    }

    @Test
    void size() {
        assertEquals(pokemons.size(), iPokedex.getPokemons().size());
    }

    @Test
    void getPokemon() throws PokedexException {
        assertEquals(Pokemon.class,iPokedex.createPokemon(0,613, 64, 4000, 4).getClass());
    }

    @Test
    void getMetadata() throws PokedexException {
        assertEquals(PokemonMetadata.class, iPokedex.getPokemonMetadata(bulbizarre.getIndex()).getClass());
    }

    @Test
    void getBulbizarreMetadata() throws PokedexException {
        assertEquals(bulbizarre.getPokemonMetadata(bulbizarre.getIndex()),iPokedex.getPokemon(0).getPokemonMetadata(bulbizarre.getIndex()));
    }

    @Test
    void getAqualiMetadata() throws PokedexException {
        assertEquals(aquali.getPokemonMetadata(aquali.getIndex()),iPokedex.getPokemon(1).getPokemonMetadata(aquali.getIndex()));
    }

    @Test
    void getIndexBulbizarre() throws PokedexException {
        assertEquals(bulbizarre.getIndex(),iPokedex.getPokemon(0).getIndex());
    }

    @Test
    void getIndexAquali() throws PokedexException {
        assertEquals(aquali.getIndex(),iPokedex.getPokemon(1).getIndex());
    }

    @Test
    void getNameBulbizarreMetadata() throws PokedexException{
        assertEquals(bulbizarre.getName(),iPokedex.getPokemon(0).getName());
    }

    @Test
    void getNameAqualiMetadata() throws PokedexException{
        assertEquals(aquali.getName(),iPokedex.getPokemon(1).getName());
    }

    @Test
    void getAttackBulbizarreMetadata() throws PokedexException{
        assertEquals(bulbizarre.getAttack(),iPokedex.getPokemon(0).getAttack());
    }

    @Test
    void getAttackAqualiMetadata() throws PokedexException{
        assertEquals(aquali.getAttack(),iPokedex.getPokemon(1).getAttack());
    }

    @Test
    void getDefenseBulbizarreMetadata() throws PokedexException{
        assertEquals(bulbizarre.getDefense(),iPokedex.getPokemon(0).getDefense());
    }

    @Test
    void getDefenseAqualiMetadata() throws PokedexException{
        assertEquals(aquali.getDefense(),iPokedex.getPokemon(1).getDefense());
    }

    @Test
    void getStaminaBulbizarreMetadata() throws PokedexException{
        assertEquals(bulbizarre.getStamina(),iPokedex.getPokemon(0).getStamina());
    }

    @Test
    void getStaminaAqualiMetadata() throws PokedexException{
        assertEquals(aquali.getStamina(),iPokedex.getPokemon(1).getStamina());
    }

    @Test
    void getCPBulbizarreMetadata() throws PokedexException{
        assertEquals(bulbizarre.getCp(),iPokedex.getPokemon(0).getCp());
    }

    @Test
    void getCPAqualiMetadata() throws PokedexException{
        assertEquals(aquali.getCp(),iPokedex.getPokemon(1).getCp());
    }

    @Test
    void getHPBulbizarreMetadata() throws PokedexException{
        assertEquals(bulbizarre.getHp(),iPokedex.getPokemon(0).getHp());
    }

    @Test
    void getHPAqualiMetadata() throws PokedexException{
        assertEquals(aquali.getHp(),iPokedex.getPokemon(1).getHp());
    }

    @Test
    void getDustBulbizarreMetadata() throws PokedexException{
        assertEquals(bulbizarre.getDust(),iPokedex.getPokemon(0).getDust());
    }

    @Test
    void getDustAqualiMetadata() throws PokedexException{
        assertEquals(aquali.getDust(),iPokedex.getPokemon(1).getDust());
    }

    @Test
    void getCandyBulbizarreMetadata() throws PokedexException{
        assertEquals(bulbizarre.getCandy(),iPokedex.getPokemon(0).getCandy());
    }

    @Test
    void getCandyAqualiMetadata() throws PokedexException{
        assertEquals(aquali.getCandy(),iPokedex.getPokemon(1).getCandy());
    }

    @Test
    void getPokemons() throws PokedexException {
        assertEquals(pokemons.get(0).getPokemonMetadata(bulbizarre.getIndex()), iPokedex.getPokemons().get(0).getPokemonMetadata(bulbizarre.getIndex()));
        assertEquals(pokemons.get(1).getPokemonMetadata(aquali.getIndex()), iPokedex.getPokemons().get(1).getPokemonMetadata(aquali.getIndex()));
    }

    @Test
    void getPokemonComparator() throws PokedexException {
        Comparator<Pokemon> order = (o1, o2) -> 0;
        assertEquals(iPokedex.getPokemons(order),pokemons);
        assertEquals(iPokedex.getPokemons(PokemonComparators.INDEX).get(0).getIndex(),0);
        assertEquals(iPokedex.getPokemons(PokemonComparators.NAME).get(0).getName(),"Aquali");
        assertEquals(iPokedex.getPokemons(PokemonComparators.CP).get(0).getCp(),613);
    }

    @Test
    void getPokedexException() {
        for(int i=-10; i <= -1; i++) {
            int negatif = i;
            assertThrows(PokedexException.class, () -> iPokedex.getPokemon(negatif));
        }
        for(int i=151; i <= 160; i++) {
            int auDessus = i;
            assertThrows(PokedexException.class, () -> iPokedex.getPokemon(auDessus));
        }
    }
}