package com.experiment.travel.controller;

import com.experiment.travel.model.City;
import com.experiment.travel.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class StartController {

    private final CityService cityService;

    @Autowired
    public StartController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping(value = "/cities")
    public String read(Model model) {
        model.addAttribute("cities", cityService.readAll());
        final List<City> city = cityService.readAll();

        return "read";
    }

    @GetMapping(value = "/cities/{id}")
    public String read(@PathVariable(name = "id") int id, Model model) {
        model.addAttribute("city", cityService.read(id));
        return "cityCard";
    }

}
