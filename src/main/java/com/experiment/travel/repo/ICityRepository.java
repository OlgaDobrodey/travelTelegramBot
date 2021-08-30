package com.experiment.travel.repo;


import com.experiment.travel.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepository extends JpaRepository<City, Integer> {
    City findCityById(Integer id);
    City findCityByName(String name);


}
