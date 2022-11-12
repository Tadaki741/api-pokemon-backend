package com.pokemon.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PokemonController {

    @Autowired
    private final PokemonService service;

    public PokemonController(PokemonService service) {
        this.service = service;
    }

    @GetMapping("/pokemon")
    public List<Pokemon> find() {
        return this.service.find();
    }

    @PostMapping("/pokemon")
    @ResponseStatus(HttpStatus.CREATED)
    //handle multiple post public Pokemon[] create(@RequestBody Pokemon[] pokemonList)
    public Pokemon create(@RequestBody Pokemon pokemon) {//we will use single post for pokemon app
        return this.service.create(pokemon);
    }

    /*
    *
    * public Pokemon[] create(@RequestBody Pokemon[] pokemonList) {//we will use single post for pokemon app
        for (Pokemon poke : pokemonList ) {
            this.service.create(poke);
        }
        return pokemonList;
    }
    *
    * */

    @PutMapping("/pokemon/{id}")
    public Pokemon update(@PathVariable Long id, @RequestBody Map<String, Object> payload) {
        return this.service.update(id, (int) payload.get("quantity"));
    }


    @DeleteMapping("/pokemon/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        this.service.delete(id);
    }


}
