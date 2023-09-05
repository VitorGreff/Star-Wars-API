package com.greff.starwars.Services;

import com.greff.starwars.Domain.Planet;
import com.greff.starwars.Repositories.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetService {
    @Autowired
    PlanetRepository repo;

    public List<Planet> findAll(){
        return repo.findAll();
    }
    public Planet findByName(@Param("name") String name){
        return repo.findByName(name);
    }
    public Planet findById(String id){
        return repo.findById(id).orElseThrow();
    }

}
