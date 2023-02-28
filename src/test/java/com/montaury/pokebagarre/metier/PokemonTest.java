package com.montaury.pokebagarre.metier;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonTest {
    Pokemon pokemon;
    Pokemon pokemon2;
    Pokemon pokemon3;
    Pokemon pokemon4;

    @BeforeEach
    void setUp() {
        pokemon = new Pokemon("Pikachu", "https://pokeapi.co/api/v2/pokemon/25/", new Stats(55, 40));
        pokemon2 = new Pokemon("Bulbizarre", "https://pokeapi.co/api/v2/pokemon/1/", new Stats(49, 49));
        pokemon3 = new Pokemon("Salamèche", "https://pokeapi.co/api/v2/pokemon/4/", new Stats(55, 41));
        pokemon4 = new Pokemon("Carapuce", "https://pokeapi.co/api/v2/pokemon/7/", new Stats(70,49));
    }

    @Test
    void pokemonEstVainqueurContrePokemon2() {
        assertTrue(pokemon.estVainqueurContre(pokemon2));
    }

    @Test
    void pokemon2EstVainqueurContrePokemon() {
        assertFalse(pokemon2.estVainqueurContre(pokemon));
    }

    @Test
    // Meme attaque
    void memeAttque() {
        assertFalse(pokemon.estVainqueurContre(pokemon3));
    }

    @Test
    // Meme defense
    void memeDefense() {
        assertTrue(pokemon4.estVainqueurContre(pokemon2));
    }

    @Test
    // Meme attaque et defense
    void memeAttqueEtDefense() {
        assertTrue(pokemon.estVainqueurContre(pokemon2));
    }


}