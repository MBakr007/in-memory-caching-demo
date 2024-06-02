package com.example.inmemorycaching.service;

import com.example.inmemorycaching.model.City;
import com.example.inmemorycaching.repo.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.concurrent.TimeUnit.SECONDS;


@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    private Logger logger = LoggerFactory.getLogger(CityService.class);

    @Cacheable(value = "cities")
    public List<City> getCities() {
        sleep();
        logger.info("fetching data from h2");
        return cityRepository.findAll();
    }

    @CacheEvict(value = "cities", allEntries = true)
    public City create(City city) {
        return cityRepository.save(city);
    }

    @Cacheable(key = "#id", cacheNames = "city")
    public Optional<City> getCity(Integer id) {
        sleep();
        logger.info("fetching data from h2");
        return cityRepository.findById(id);
    }

    private void sleep() {
        try {
            SECONDS.sleep(1);
        } catch (InterruptedException e) {
            logger.info(String.valueOf(e));
        }
    }}