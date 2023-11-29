
package com.example.geohub.controller;

import com.example.geohub.model.City;
import com.example.geohub.model.Country;
import com.example.geohub.service.CityJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CityController {
    @Autowired
    private CityJpaService cityJpaService;

    @GetMapping("/countries/cities")
    public ArrayList<City> getCities() {
        return cityJpaService.getCities();
    }

    @GetMapping("/countries/Cities/{cityId}")
    public City getCityById(@PathVariable("cityId") int cityId) {
        return cityJpaService.getCityById(cityId);
    }

    @PostMapping("/countries/Cities")
    public City addCity(@RequestBody City city) {
        return cityJpaService.addCity(city);
    }

    @PutMapping("/countries/Cities/{cityId}")
    public City updateCity(@PathVariable("cityId") int cityId, @RequestBody City city) {
        return cityJpaService.updateCity(cityId, city);
    }

    @DeleteMapping("/products/Cities/{cityId}")
    public void deleteCity(@PathVariable("cityId") int cityId) {
        cityJpaService.deleteCity(cityId);
    }

    @GetMapping("/Cities/{cityId}/country")
    public Country getCityCountry(@PathVariable("cityId") int cityId) {
        return cityJpaService.getCityCountry(cityId);

    }
}