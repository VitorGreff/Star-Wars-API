package com.greff.starwars.Domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "planet")
public class Planet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String climate;
    private String terrain;
    private int totalAppearances;

    public Planet() {
    }

    public Planet(Long id, String name, String climate, String terrain, int totalAppearances) {
        this.id = id;
        this.name = name;
        this.climate = climate;
        this.terrain = terrain;
        this.totalAppearances = totalAppearances;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getTotalAppearances() {
        return totalAppearances;
    }

    public void setTotalAppearances(int totalAppearances) {
        this.totalAppearances = totalAppearances;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return Objects.equals(id, planet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
