package com.experiment.travel.controller;

import com.experiment.travel.model.City;
import com.experiment.travel.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }


    @PostMapping(value = "/cities")
    public ResponseEntity<?> create(@RequestBody City city) {
        cityService.create(city);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/cities/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody City city) {
        final boolean updated = cityService.update(city, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/cities/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = cityService.delete(id);
        System.out.println("!!!!!!!!!!!");
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}

