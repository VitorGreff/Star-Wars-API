package com.greff.starwars.Config;

import com.greff.starwars.Domain.Planet;
import com.greff.starwars.Repositories.PlanetRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;

@Configuration
@Profile("dev")
public class instantiation implements CommandLineRunner {
    @Autowired
    PlanetRepository repo;

    @Override
    public void run(String... args) throws Exception {
        repo.deleteAll();
        Planet p1 = new Planet(null, "terra","quente","normal",0);
        Planet p2 = new Planet(null, "mater","frio","areia",3);
        repo.saveAll(Arrays.asList(p1,p2));
    }
}
