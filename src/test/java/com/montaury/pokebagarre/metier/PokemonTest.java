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

    // Test de toutes les autres méthodes

    @Test
    void getNom() {
        assertEquals("Pikachu", pokemon.getNom());
    }

    @Test
    void getUrlImage() {
        assertEquals("https://pokeapi.co/api/v2/pokemon/25/", pokemon.getUrlImage());
    }

    @Test
    void getStats() {
        assertEquals(new Stats(55, 40), pokemon.getStats());
    }

    @Test
    void testToString() {
        assertEquals("Pikachu", pokemon.toString());
    }

    @Test
    void testEquals() {
        assertEquals(pokemon, pokemon);
        assertNotEquals(pokemon, null);
        assertNotEquals(pokemon, new Object());
        assertNotEquals(pokemon, pokemon2);
        assertEquals(pokemon, new Pokemon("Pikachu", "https://pokeapi.co/api/v2/pokemon/25/", new Stats(55, 40)));
    }

    @Test
    void testHashCode() {
        assertEquals(pokemon.hashCode(), pokemon.hashCode());
        assertNotEquals(pokemon.hashCode(), pokemon2.hashCode());
        assertEquals(pokemon.hashCode(), new Pokemon("Pikachu", "https://pokeapi.co/api/v2/pokemon/25/", new Stats(55, 40)).hashCode());
    }




}