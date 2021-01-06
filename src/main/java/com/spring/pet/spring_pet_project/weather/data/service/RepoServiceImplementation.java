package com.spring.pet.spring_pet_project.weather.data.service;


import com.spring.pet.spring_pet_project.weather.data.dao.DataWeatherRepo;
import com.spring.pet.spring_pet_project.weather.data.entity.DataWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Optional;

@Service
public class RepoServiceImplementation implements RepoService {
    private final EntityManager manager;
    private final DataWeatherRepo repo;

    @Autowired
    public RepoServiceImplementation(DataWeatherRepo repo, @Qualifier("entityManagerFactory") EntityManager manager) {
        this.repo = repo;
        this.manager = manager;
    }

    @Override
    public DataWeather getWeather(long id) {
        DataWeather weather = null;
        Optional<DataWeather> optional = repo.findById(id);
        if (optional.isPresent()) weather = optional.get();
        return weather;
    }

    @Override
    public void addWeather(DataWeather dataWeather) {
        repo.save(dataWeather);
    }

    @Override
    public void deleteWeather(long id) {
        repo.deleteById(id);
    }
}
