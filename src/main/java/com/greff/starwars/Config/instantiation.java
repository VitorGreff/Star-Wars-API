package com.greff.starwars.Config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greff.starwars.DTO.PlanetDTO;
import com.greff.starwars.Repositories.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@Configuration
@Profile("dev")
public class instantiation implements CommandLineRunner {
    @Autowired
    PlanetRepository repo;

    @Override
    public void run(String... args) throws Exception {
//        repo.deleteAll();
//        Planet p1 = new Planet(null, "terra","quente","normal",0);
//        Planet p2 = new Planet(null, "mater","frio","areia",3);
//        repo.saveAll(Arrays.asList(p1,p2));

        String url = "https://swapi.dev/api/planets/1/?format=json";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            PlanetDTO planet = objectMapper.readValue(result, PlanetDTO.class);

            // Agora você tem um objeto Planet com os campos desejados
            System.out.println("Name: " + planet.getName());
            System.out.println("Climate: " + planet.getClimate());
            System.out.println("Terrain: " + planet.getTerrain());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
