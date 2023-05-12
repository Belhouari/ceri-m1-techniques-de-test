package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class IPokemonTrainerFactoryTest {

	@Mock
	IPokedex testpokedex;
	@Mock
	IPokedexFactory testpokedexfactory;
	@Mock
	IPokemonTrainerFactory testpokemontrainerfactory;


	public IPokemonTrainerFactoryTest() {
		this.testpokedex = Mockito.mock(IPokedex.class);
		this.testpokedexfactory = Mockito.mock(IPokedexFactory.class);
		this.testpokemontrainerfactory = Mockito.mock(IPokemonTrainerFactory.class);
	}


	@Test
	public void createTrainerTest() {
		PokemonTrainer pokemonTrainerTest = new PokemonTrainer("test", Team.VALOR, this.testpokedex);
		Mockito.doReturn(pokemonTrainerTest).when(this.testpokemontrainerfactory).createTrainer("test", Team.VALOR, this.testpokedexfactory);
		Assert.assertEquals(pokemonTrainerTest.getClass(), this.testpokemontrainerfactory.createTrainer("test", Team.VALOR, this.testpokedexfactory).getClass());
		Assert.assertEquals("test", this.testpokemontrainerfactory.createTrainer("test", Team.VALOR, this.testpokedexfactory).getName());
	}
}