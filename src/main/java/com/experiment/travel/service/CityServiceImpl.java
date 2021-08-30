package com.experiment.travel.service;

import com.experiment.travel.model.City;
import com.experiment.travel.repo.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private ICityRepository cityRepository;

    @Override
    public void create(City city) {
        City citySave = this.cityRepository.save(city);
    }

    @Override
    public List<City> readAll() {
        return this.cityRepository.findAll();
    }

    @Override
    public City read(int id) {
        return cityRepository.findCityById(id);
    }

    @Override
    public City readForName(String name) {
        return cityRepository.findCityByName(name);
    }

    @Override
    public boolean update(City city, int id) {
        City cityForUpdate = cityRepository.findCityById(id);
        if (cityForUpdate != null) {
            cityForUpdate.setName(city.getName());
            cityForUpdate.setInformation(city.getInformation());
            cityRepository.save(cityForUpdate);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        City cityForDelete = cityRepository.findCityById(id);
        if (cityForDelete != null) {
            this.cityRepository.delete(cityForDelete);
            return true;
        } else return false;
    }

}
