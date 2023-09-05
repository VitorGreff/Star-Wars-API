package com.greff.starwars.Controllers;

import com.greff.starwars.Services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/planets")
public class PlanetController {
    @Autowired
    PlanetService service;
}
