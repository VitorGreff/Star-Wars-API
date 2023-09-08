package com.greff.starwars.Config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.greff.starwars.DTO.PlanetDTO;
import com.greff.starwars.Repositories.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@Configuration
@Profile("dev")
public class Instantiation implements CommandLineRunner {
    @Autowired
    PlanetRepository repo;
    @Override
    public void run(String... args) {
        repo.deleteAll();
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        String url1 = "https://swapi.dev/api/planets/?format=json";
        String url2 = "https://swapi.dev/api/planets/";
        try{
            String json1 = restTemplate.getForObject(url1, String.class);
            JsonObject jsonObject = JsonParser.parseString(json1).getAsJsonObject();
            String json2;

            for(int i = 1; i <= jsonObject.get("count").getAsInt(); i++){
                try {
                    json2 = restTemplate.getForObject(url2 + i + "/?format=json", String.class);
                    repo.save(objectMapper.readValue(json2, PlanetDTO.class).fromDTO());
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
