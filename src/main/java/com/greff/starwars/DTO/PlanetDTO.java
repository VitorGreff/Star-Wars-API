package com.greff.starwars.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.greff.starwars.Domain.Planet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanetDTO implements Serializable {
    private String name;
    private String climate;
    private String terrain;
    private List<String> films = new ArrayList<>();

    public PlanetDTO() {
    }

    public PlanetDTO(String name, String climate, String terrain) {
        this.name = name;
        this.climate = climate;
        this.terrain = terrain;
    }
    public List<String> getFilms() {
        return films;
    }
    public Integer getNumberOfFilms(){
        return getFilms().size();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public Planet fromDTO(){
        return new Planet(null, getName(),getClimate(), getTerrain(), getNumberOfFilms());
    }
}
