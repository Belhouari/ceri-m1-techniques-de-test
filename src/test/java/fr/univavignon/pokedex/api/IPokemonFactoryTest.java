package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class IPokemonFactoryTest {

	@Mock
	IPokemonFactory testPokemonFactory;
	Pokemon bouchra = new Pokemon(133, "bouchra", 186, 186, 260, 2729, 202, 5000, 4, 100.0);


	public IPokemonFactoryTest() {
		//on mock la classe IPokemonFactory
		this.testPokemonFactory = Mockito.mock(IPokemonFactory.class);
	}

	@Test
	public void  createPokemonTest () {
		Mockito.when(this.testPokemonFactory.createPokemon(133,2729, 202, 5000, 4)).thenReturn(bouchra);
		Assert.assertEquals(this.bouchra, testPokemonFactory.createPokemon(133,2729, 202, 5000, 4));

	}


}