package com.greff.starwars.Services;

import com.greff.starwars.DTO.PlanetDTO;
import com.greff.starwars.Domain.Planet;
import com.greff.starwars.Repositories.PlanetRepository;
import com.greff.starwars.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanetService {
    @Autowired
    PlanetRepository repo;

    public List<Planet> findAll(){
        return repo.findAll();
    }
    public Planet findByName(String name){
        return repo.findByName(name);
    }
    public Planet findById(String id){
        Optional<Planet> planet = repo.findById(id);
        return planet.orElseThrow(()-> new ObjectNotFoundException("Object not found in the database!"));
    }
    public Planet insert(PlanetDTO dto){
        return repo.save(dto.fromDTO());
    }
    public void delete(String id){
        repo.deleteById(id);
    }
    public void update(String id, PlanetDTO planetDTO){
        Planet newPlanet = findById(id);
        newPlanet.setName(planetDTO.getName());
        newPlanet.setClimate(planetDTO.getClimate());
        newPlanet.setTerrain(planetDTO.getTerrain());
        newPlanet.setTotalAppearances(planetDTO.getNumberOfFilms());
        repo.save(newPlanet);
    }


}
