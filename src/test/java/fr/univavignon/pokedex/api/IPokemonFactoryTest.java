package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IPokemonFactoryTest {

    IPokemonMetadataProvider iPokemonMetadataProvider;
    IPokemonFactory iPokemonFactory;

    Pokemon bulbizarre;
    Pokemon aquali;

    RocketPokemonFactory rocketPokemonFactory;

    @BeforeEach
    void initPokemon() {
        iPokemonMetadataProvider = new PokemonMetadataProvider();
        iPokemonFactory = new PokemonFactory(iPokemonMetadataProvider);
        rocketPokemonFactory = new RocketPokemonFactory();

        bulbizarre = new Pokemon(0,"Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        aquali = new Pokemon(133,"Aquali", 186, 168, 260, 2729,202,5000, 4, 100);
    }

    @Test
    void createBulbizarre() throws PokedexException {
        assertEquals(bulbizarre.getClass(),iPokemonFactory.createPokemon(0,613, 64, 4000, 4).getClass());
    }

    @Test
    void createAqualiMetadata() throws PokedexException {
        assertEquals(aquali.getClass(),iPokemonFactory.createPokemon(133, 2729,202,5000, 4).getClass());
    }
    @Test
    void getBulbizarreMetadata() throws PokedexException {
        assertEquals(bulbizarre.getClass(),iPokemonFactory.createPokemon(0,613, 64, 4000, 4).getPokemonMetadata(bulbizarre.getIndex()).getClass());
    }

    @Test
    void getAqualiMetadata() throws PokedexException {
        assertEquals(aquali.getClass(),iPokemonFactory.createPokemon(133, 2729,202,5000, 4).getPokemonMetadata(aquali.getIndex()).getClass());
    }

    @Test
    void getIndexBulbizarre() throws PokedexException {
        assertEquals(bulbizarre.getIndex(),iPokemonFactory.createPokemon(0,613, 64, 4000, 4).getIndex());
    }

    @Test
    void getIndexAquali() throws PokedexException {
        assertEquals(aquali.getIndex(),iPokemonFactory.createPokemon(133, 2729,202,5000, 4).getIndex());
    }

    @Test
    void getNameBulbizarreMetadata() throws PokedexException{
        assertEquals(bulbizarre.getName(),iPokemonFactory.createPokemon(0,613, 64, 4000, 4).getName());
    }

    @Test
    void getNameAqualiMetadata() throws PokedexException{
        assertEquals(aquali.getName(),iPokemonFactory.createPokemon(133, 2729,202,5000, 4).getName());
    }

    @Test
    void getAttackBulbizarreMetadata() throws PokedexException{
        assertEquals(bulbizarre.getAttack(),iPokemonFactory.createPokemon(0,613, 64, 4000, 4).getAttack());
    }

    @Test
    void getAttackAqualiMetadata() throws PokedexException{
        assertEquals(aquali.getAttack(),iPokemonFactory.createPokemon(133, 2729,202,5000, 4).getAttack());
    }

    @Test
    void getDefenseBulbizarreMetadata() throws PokedexException{
        assertEquals(bulbizarre.getDefense(),iPokemonFactory.createPokemon(0,613, 64, 4000, 4).getDefense());
    }

    @Test
    void getDefenseAqualiMetadata() throws PokedexException{
        assertEquals(aquali.getDefense(),iPokemonFactory.createPokemon(133, 2729,202,5000, 4).getDefense());
    }

    @Test
    void getStaminaBulbizarreMetadata() throws PokedexException{
        assertEquals(bulbizarre.getStamina(),iPokemonFactory.createPokemon(0,613, 64, 4000, 4).getStamina());
    }

    @Test
    void getStaminaAqualiMetadata() throws PokedexException{
        assertEquals(aquali.getStamina(),iPokemonFactory.createPokemon(133, 2729,202,5000, 4).getStamina());
    }

    @Test
    void getCPBulbizarreMetadata() throws PokedexException{
        assertEquals(bulbizarre.getCp(),iPokemonFactory.createPokemon(0,613, 64, 4000, 4).getCp());
    }

    @Test
    void getCPAqualiMetadata() throws PokedexException{
        assertEquals(aquali.getCp(),iPokemonFactory.createPokemon(133, 2729,202,5000, 4).getCp());
    }

    @Test
    void getHPBulbizarreMetadata() throws PokedexException{
        assertEquals(bulbizarre.getHp(),iPokemonFactory.createPokemon(0,613, 64, 4000, 4).getHp());
    }

    @Test
    void getHPAqualiMetadata() throws PokedexException{
        assertEquals(aquali.getHp(),iPokemonFactory.createPokemon(133, 2729,202,5000, 4).getHp());
    }

    @Test
    void getDustBulbizarreMetadata() throws PokedexException{
        assertEquals(bulbizarre.getDust(),iPokemonFactory.createPokemon(0,613, 64, 4000, 4).getDust());
    }

    @Test
    void getDustAqualiMetadata() throws PokedexException{
        assertEquals(aquali.getDust(),iPokemonFactory.createPokemon(133, 2729,202,5000, 4).getDust());
    }

    @Test
    void getCandyBulbizarreMetadata() throws PokedexException{
        assertEquals(bulbizarre.getCandy(),iPokemonFactory.createPokemon(0,613, 64, 4000, 4).getCandy());
    }

    @Test
    void getCandyAqualiMetadata() throws PokedexException{
        assertEquals(aquali.getCandy(),iPokemonFactory.createPokemon(133, 2729,202,5000, 4).getCandy());
    }

    @Test
    void getIvBulbizarreMetadata() throws PokedexException{
        assertEquals(Double.class,((Double) iPokemonFactory.createPokemon(0,613, 64, 4000, 4).getIv()).getClass());
    }

    @Test
    void getIvAqualiMetadata() throws PokedexException{
        assertEquals(Double.class,((Double) iPokemonFactory.createPokemon(133, 2729,202,5000, 4).getIv()).getClass());
    }

    @Test
    void createRocketPokemonFactory() throws PokedexException{
        assertEquals(Pokemon.class, rocketPokemonFactory.createPokemon(24,613, 64, 4000, 4).getPokemonMetadata(24).getClass());
    }

    @Test
    void getPokedexException() {
        for(int i=-10; i <= -1; i++) {
            int negatif = i;
            assertThrows(PokedexException.class, () ->  iPokemonFactory.createPokemon(negatif,613, 64, 4000, 4).getPokemonMetadata(negatif));
        }
        for(int i=151; i <= 160; i++) {
            int auDessus = i;
            assertThrows(PokedexException.class, () ->  iPokemonFactory.createPokemon(auDessus,613, 64, 4000, 4).getPokemonMetadata(auDessus));
        }
    }
}