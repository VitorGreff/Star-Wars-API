package com.greff.starwars.Services;

import com.greff.starwars.Repositories.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanetService {
    @Autowired
    PlanetRepository repo;
}
