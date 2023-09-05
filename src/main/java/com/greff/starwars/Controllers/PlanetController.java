package com.greff.starwars.Controllers;

import com.greff.starwars.Domain.Planet;
import com.greff.starwars.Domain.PlanetDTO;
import com.greff.starwars.Services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping(value = "/planets")
public class PlanetController {
    @Autowired
    PlanetService service;

    @GetMapping
    public ResponseEntity<List<Planet>> findAll(){
        List<Planet> planets = service.findAll();
        return ResponseEntity.ok().body(planets);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<Planet> finByName(@PathVariable String name){
        Planet planet = service.findByName(name);
        return ResponseEntity.ok().body(planet);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Planet> findById(@PathVariable String id){
        Planet planet = service.findById(id);
        return ResponseEntity.ok().body(planet);
    }

    @PostMapping
    public ResponseEntity<Void> insertPlanet(@RequestBody PlanetDTO planetDTO){
        Planet newPlanet = service.insertPlanet(planetDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(newPlanet.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


}
