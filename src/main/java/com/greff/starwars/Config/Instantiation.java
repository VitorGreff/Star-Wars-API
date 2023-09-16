package com.greff.starwars.Config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greff.starwars.DTO.PlanetDTO;
import com.greff.starwars.Repositories.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@Profile("test")
public class Instantiation implements CommandLineRunner {
    @Autowired
    PlanetRepository repo;
    @Override
    public void run(String... args) {
        repo.deleteAll();
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        String url = "https://swapi.dev/api/planets?page=";
        String jsonString;
        JsonNode jsonTree;
        JsonNode nodes;
        List<PlanetDTO> planets = new ArrayList<>();
        try{
            for(int i = 1; i <= 6; i++){
                jsonString = restTemplate.getForObject(url + i + "&format=json", String.class);
                jsonTree = objectMapper.readTree(jsonString);
                nodes = jsonTree.get("results");
                for (JsonNode node: nodes
                ) {
                    PlanetDTO planet = objectMapper.treeToValue(node, PlanetDTO.class);
                    planets.add(planet);
                }
            }
            repo.saveAll(planets.stream().map(x -> x.fromDTO()).collect(Collectors.toList()));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}