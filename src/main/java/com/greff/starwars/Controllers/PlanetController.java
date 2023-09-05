package com.greff.starwars.Controllers;

import com.greff.starwars.Domain.Planet;
import com.greff.starwars.Services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
