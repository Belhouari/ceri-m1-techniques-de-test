package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokedexFactoryTest {

	IPokedexFactory testProviderFactory;

	public IPokedexFactoryTest() {
		//on mock la classe IPokedexFactory pour la reutiliser dans la fonction de test
		this.testProviderFactory = Mockito.mock(IPokedexFactory.class);
	}

	@Test
	public void testCreatePokedex() {
		//on va ici mock la class ipokemonmetadataprovider pour pouvoir la passer en argument plus tard
		IPokemonMetadataProvider testPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
		//ici on va aussi mock la class ipokemon pour pouvoir la passer en argument dans la fonction create pokedex
		IPokemonFactory testPokemonFactory = Mockito.mock(IPokemonFactory.class);
		//on return une instance de la classe ipokedex lors de lapelle a la fonction
		Mockito.doReturn(Mockito.mock(IPokedex.class)).when(testProviderFactory).createPokedex(Mockito.any(testPokemonMetadataProvider.getClass()), Mockito.any(testPokemonFactory.getClass()));
		//on verifie que nous avons bien une instance de la classe ipokedex lors de lappel a la fonction
		Assert.assertEquals(Mockito.mock(IPokedex.class).getClass(), testProviderFactory.createPokedex(Mockito.mock(IPokemonMetadataProvider.class), Mockito.mock(IPokemonFactory.class)).getClass());
	}

}