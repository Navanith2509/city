
package com.example.geohub.service;

import com.example.geohub.model.Country;
import com.example.geohub.repository.CountryJpaRepository;
import com.example.geohub.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryJpaService implements CountryRepository {
    @Autowired
    private CountryJpaRepository countryJpaRepository;

    @Override
    public ArrayList<Country> getCountries() {
        List<Country> productList = countryJpaRepository.findAll();
        ArrayList<Country> products = new ArrayList<>(productList);
        return products;
    }

    @Override
    public Country getCountryById(int countryId) {
        try {
            Country country = countryJpaRepository.findById(countryId).get();
            return country;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Country addCountry(Country country) {
        countryJpaRepository.save(country);
        return country;
    }

    @Override
    public Country updateCountry(int countryId, Country country) {
        try {
            Country newProduct = countryJpaRepository.findById(countryId).get();
            if (country.getCountryName() != null) {
                newProduct.setCountryName(country.getCountryName());
            }
            if (country.getCurrency() != null) {
                newProduct.setCurrency(country.getCurrency());
            }
            if (country.getPopulation() != 0) {
                newProduct.setPopulation(country.getPopulation());
            }

            if (country.getLatitude() != null) {
                newProduct.setLatitude(country.getLatitude());
            }
            if (country.getLongitude() != null) {
                newProduct.setLongitude(country.getLongitude());
            }

            countryJpaRepository.save(newProduct);
            return newProduct;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteCountry(int countryId) {
        try {
            countryJpaRepository.deleteById(countryId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }
}
