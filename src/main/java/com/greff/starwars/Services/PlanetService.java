package com.greff.starwars.Services;

import com.greff.starwars.Domain.Planet;
import com.greff.starwars.DTO.PlanetDTO;
import com.greff.starwars.Repositories.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return repo.findById(id).orElseThrow();
    }

    public Planet insert(PlanetDTO dto){
        return repo.save(fromDTO(dto));
    }

    public Planet fromDTO(PlanetDTO dto){
        Planet planet = new Planet(null, dto.getName(),dto.getClimate(), dto.getTerrain(), 0);
        return planet;
    }

    public void delete(String id){
        repo.deleteById(id);
    }


}
