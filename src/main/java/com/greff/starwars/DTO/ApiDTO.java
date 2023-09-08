package com.greff.starwars.DTO;

import java.util.ArrayList;
import java.util.List;

public class ApiDTO {
    private String name;
    private Integer rotation_period;
    private Integer orbital_period;
    private Long diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private Integer surface_water;
    private Long population;
    private String created;
    private String edited;
    private String url;
    private List<String> residents = new ArrayList<>();
    private List<String> films = new ArrayList<>();

    public ApiDTO(String name, Integer rotation_period, Integer orbital_period, Long diameter,
                  String climate, String gravity, String terrain, Integer surface_water,
                  Long population, String created, String edited, String url) {
        this.name = name;
        this.rotation_period = rotation_period;
        this.orbital_period = orbital_period;
        this.diameter = diameter;
        this.climate = climate;
        this.gravity = gravity;
        this.terrain = terrain;
        this.surface_water = surface_water;
        this.population = population;
        this.created = created;
        this.edited = edited;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRotation_period() {
        return rotation_period;
    }

    public void setRotation_period(Integer rotation_period) {
        this.rotation_period = rotation_period;
    }

    public Integer getOrbital_period() {
        return orbital_period;
    }

    public void setOrbital_period(Integer orbital_period) {
        this.orbital_period = orbital_period;
    }

    public Long getDiameter() {
        return diameter;
    }

    public void setDiameter(Long diameter) {
        this.diameter = diameter;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public Integer getSurface_water() {
        return surface_water;
    }

    public void setSurface_water(Integer surface_water) {
        this.surface_water = surface_water;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getResidents() {
        return residents;
    }

    public List<String> getFilms() {
        return films;
    }

    @Override
    public String toString() {
        return "ApiDTO{" +
                "name='" + name + '\'' +
                ", rotation_period=" + rotation_period +
                ", orbital_period=" + orbital_period +
                ", diameter=" + diameter +
                ", climate='" + climate + '\'' +
                ", gravity='" + gravity + '\'' +
                ", terrain='" + terrain + '\'' +
                ", surface_water=" + surface_water +
                ", population=" + population +
                ", created='" + created + '\'' +
                ", edited='" + edited + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}


//"name": "Alderaan",
//        "rotation_period": "24",
//        "orbital_period": "364",
//        "diameter": "12500",
//        "climate": "temperate",
//        "gravity": "1 standard",
//        "terrain": "grasslands, mountains",
//        "surface_water": "40",
//        "population": "2000000000",
//        "residents": [
//        "https://swapi.dev/api/people/5/",
//        "https://swapi.dev/api/people/68/",
//        "https://swapi.dev/api/people/81/"
//        ],
//        "films": [
//        "https://swapi.dev/api/films/1/",
//        "https://swapi.dev/api/films/6/"
//        ],
//        "created": "2014-12-10T11:35:48.479000Z",
//        "edited": "2014-12-20T20:58:18.420000Z",
//        "url": "https://swapi.dev/api/planets/2/"