package com.pokemon.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService implements IPokemonService {


    @Autowired
    private final PokemonRepository repository;

    public PokemonService(PokemonRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Pokemon> find() {
        return this.repository.findAll();
    }

    @Override
    public Pokemon create(Pokemon pokemon) {
        return repository.save(pokemon);
    }

    @Override
    public Pokemon update(Long id, int quantity) {
        return repository.findById(id)
                .map(existingPokemon -> {
                    existingPokemon.setQuantity(quantity);
                    return this.repository.save(existingPokemon);
                }).orElse(null);
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }


}
