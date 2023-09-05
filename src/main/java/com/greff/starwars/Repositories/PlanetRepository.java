package com.greff.starwars.Repositories;

import com.greff.starwars.Domain.Planet;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, String> {
    @Query("SELECT p FROM Planet p WHERE p.name = :name")
    Planet findByName(@Param("name") String name);
}

