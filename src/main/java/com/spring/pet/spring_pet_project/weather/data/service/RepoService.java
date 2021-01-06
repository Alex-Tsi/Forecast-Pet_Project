package com.spring.pet.spring_pet_project.weather.data.service;

import com.spring.pet.spring_pet_project.weather.data.entity.DataWeather;

public interface RepoService {

    DataWeather getWeather(long id);

    void addWeather(DataWeather dataWeather);

    void deleteWeather(long id);
}

