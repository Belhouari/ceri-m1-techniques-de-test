package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    private static PokemonMetadata[] pokemonMetadataList;

    public PokemonMetadataProvider() {
        pokemonMetadataList = new PokemonMetadata[150];
        pokemonMetadataList[0] = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        pokemonMetadataList[133] = new PokemonMetadata(133, "Aquali", 186, 168, 260);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (index < 0 || index > 151)
            throw new PokedexException("Le pokemon est introuvable");
        try {
            return pokemonMetadataList[index];
        } catch (Exception e) {
            throw new PokedexException("Le pokemon est introuvable");
        }
    }
}