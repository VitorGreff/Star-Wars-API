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
public class instantiation implements CommandLineRunner {
    @Autowired
    PlanetRepository repo;

    @Override
    public void run(String... args) throws Exception {
        repo.deleteAll();
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        String url1 = "https://swapi.dev/api/planets/?format=json";
        Integer count = null;
        String url2 = "https://swapi.dev/api/planets/";
        String result2;

        try{
            String result1 = restTemplate.getForObject(url1, String.class);
            JsonObject jsonObject = JsonParser.parseString(result1).getAsJsonObject();
            count = jsonObject.get("count").getAsInt();

        }catch (Exception e){
            e.printStackTrace();
        }

        if(count != null){
            PlanetDTO planet;
            for(int i = 1; i <= 10; i++){
                result2 = restTemplate.getForObject(url2 + i + "/?format=json", String.class);
                planet = objectMapper.readValue(result2,PlanetDTO.class);
                repo.save(planet.fromDTO());
            }
        }
    }
}
