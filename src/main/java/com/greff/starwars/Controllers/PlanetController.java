package com.greff.starwars.Controllers;
import com.greff.starwars.DTO.PlanetDTO;
import com.greff.starwars.Domain.Planet;
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

    @GetMapping(value = "/find")
    public ResponseEntity<Planet> finByName(@RequestParam("name") String name){
        Planet planet = service.findByName(name);
        return ResponseEntity.ok().body(planet);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Planet> findById(@PathVariable String id){
        Planet planet = service.findById(id);
        return ResponseEntity.ok().body(planet);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody PlanetDTO planetDTO){
        Planet newPlanet = service.insert(planetDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(newPlanet.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody PlanetDTO planetDTO, @PathVariable String id){
        service.update(id, planetDTO);
        return ResponseEntity.ok().build();
    }

}
