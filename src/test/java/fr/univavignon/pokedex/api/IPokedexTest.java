package fr.univavignon.pokedex.api;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokedexTest {

	IPokedex testPokedex;
	ArrayList<Pokemon> listPokemons;

	public IPokedexTest() {
		this.testPokedex = Mockito.mock(IPokedex.class);
		this.listPokemons = new ArrayList();
		Pokemon Bouchra = new Pokemon(10, "Bouchra", 300, 300, 300, 1000, 100, 8000, 10, 100.0);
		Pokemon aquali = new Pokemon(133, "Aquali", 186, 186, 260, 2729, 202, 5000, 4, 100.0);
		Pokemon test = new Pokemon(0, "test", 126, 126, 90, 613, 64, 4000, 4, 56.0);

		this.listPokemons.add(Bouchra);this.listPokemons.add(aquali);this.listPokemons.add(test);
	}

	@Test
	public void sizeTest(){
		Mockito.doReturn(this.listPokemons.size()).when(this.testPokedex).size();
		Assert.assertEquals(3, testPokedex.size());
	}

	@Test
	public void addPokemonTest() {
		//creation pokemon qui va etre ajoute avec mock
		Pokemon bel = new Pokemon(100, "bel", 100, 100, 100, 100, 100, 100, 100, 100.0);
		//on fait +1 car on "ajoute" un pokemon
		Mockito.doReturn(this.listPokemons.size()+1).when(this.testPokedex).addPokemon(Mockito.any(Pokemon.class));
		//on attend la taille + 1
		Assert.assertEquals(this.listPokemons.size()+1, this.testPokedex.addPokemon(bel));

	}

	@Test
	public void getPokemonTest() throws PokedexException {
		//on renvoie le pokemon Bouchra quand on met lindice 0
		Mockito.doReturn(this.listPokemons.get(0)).when(this.testPokedex).getPokemon(10);
		//on renvoie le pokemon aquali quand on met lindice 1
		Mockito.doReturn(this.listPokemons.get(1)).when(this.testPokedex).getPokemon(0);
		//on renvoie le pokemon test quand on met lindice 2
		Mockito.doReturn(this.listPokemons.get(2)).when(this.testPokedex).getPokemon(133);
		//on lance exception si la tranche pour l'index n'est pas respectée
		Mockito.doThrow(new PokedexException("Un pokemon avec un tel index n'existe pas ! Tu n'es pas concentré ...")).when(this.testPokedex).getPokemon(Mockito.intThat(index -> index < 0 || index > 150));
		// si on met l'index 10 on retourne le pokement bel
		Assert.assertEquals(this.listPokemons.get(0), this.testPokedex.getPokemon(10));
		// si on met l'index 0 on retourne le pokement aquali
		Assert.assertEquals(this.listPokemons.get(1), this.testPokedex.getPokemon(0));
		// si on met l'index 2 on retourne le pokement test
		Assert.assertEquals(this.listPokemons.get(2), this.testPokedex.getPokemon(133));
		// Ici on verifie que l'exception fonctionne bien
		Assert.assertThrows(PokedexException.class, () -> this.testPokedex.getPokemon(151));
		// Ici on verifie que l'exception fonctionne bien
		Assert.assertThrows(PokedexException.class, () -> this.testPokedex.getPokemon(-1));
	}

	@Test
	public void getPokemonsTest() {
		List<Pokemon> listeNonModifiable = Collections.unmodifiableList(this.listPokemons);
		Mockito.doReturn(listeNonModifiable).when(this.testPokedex).getPokemons();
		Assert.assertEquals(listeNonModifiable.getClass(), this.testPokedex.getPokemons().getClass());
		Assert.assertEquals(3, this.testPokedex.getPokemons().size());
	}

	@Test
	public void getPokemons() {

		//On instancie nos comparators a laide de la classe PokemonComparators
		PokemonComparators name = PokemonComparators.NAME;
		PokemonComparators index = PokemonComparators.INDEX;
		PokemonComparators cp = PokemonComparators.CP;
		//On crée nos 3 listes qui seront "sort" a laide des pokemon comparators
		//donc un par nom, un avec l'index et la derniere avec le cp
		List<Pokemon> listeTrieParCP = new ArrayList<>(this.listPokemons);
		listeTrieParCP.sort(cp);
		List<Pokemon> listeTrieParNom = new ArrayList<>(this.listPokemons);
		listeTrieParNom.sort(name);
		List<Pokemon> listeTrieParIndex = new ArrayList<>(this.listPokemons);
		listeTrieParIndex.sort(index);
		Mockito.doReturn(Collections.unmodifiableList(listeTrieParCP)).when(this.testPokedex).getPokemons(cp);
		Mockito.doReturn(Collections.unmodifiableList(listeTrieParIndex)).when(this.testPokedex).getPokemons(index);
		//on renvoie la liste non modifiable trie par name lors de lapelle a la fonction avec le comparator name
		Mockito.doReturn(Collections.unmodifiableList(listeTrieParNom)).when(this.testPokedex).getPokemons(name);
		Assert.assertEquals(Collections.unmodifiableList(new ArrayList<>()).getClass(), this.testPokedex.getPokemons(index).getClass());
		Assert.assertEquals("test", this.testPokedex.getPokemons(index).get(0).getName());
		Assert.assertEquals("Aquali", this.testPokedex.getPokemons(name).get(0).getName());
		Assert.assertEquals("test", this.testPokedex.getPokemons(cp).get(0).getName());
	}



}