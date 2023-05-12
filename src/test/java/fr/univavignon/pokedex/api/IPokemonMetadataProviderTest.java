package fr.univavignon.pokedex.api;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.Assert;
import org.junit.Test;

public class IPokemonMetadataProviderTest {


	@Mock
	IPokemonMetadataProvider testProvider;

	PokemonMetadata bouchra, houari;

	public IPokemonMetadataProviderTest(){
		this.testProvider = Mockito.mock(IPokemonMetadataProvider.class);
		this.houari = new PokemonMetadata(133, "houari", 186, 168, 260);
		this.bouchra = new PokemonMetadata(0, "bouchra", 126, 126, 90);
	}

	@Test
	public void getPokemonMetadataTest() throws PokedexException {
		Mockito.doReturn(this.bouchra).when(this.testProvider).getPokemonMetadata(0);
		Mockito.doReturn(this.houari).when(this.testProvider).getPokemonMetadata(133);
		Mockito.doThrow(new PokedexException("Un pokemon avec un tel index n'existe pas ! Tu n'es pas concentré ... ")).when(testProvider).getPokemonMetadata(Mockito.intThat(index -> index < 0 || index > 150));
		Assert.assertEquals(this.bouchra, this.testProvider.getPokemonMetadata(0));
		Assert.assertEquals(this.houari, this.testProvider.getPokemonMetadata(133));
		Assert.assertThrows(PokedexException.class, () -> testProvider.getPokemonMetadata(-151));
	}





}