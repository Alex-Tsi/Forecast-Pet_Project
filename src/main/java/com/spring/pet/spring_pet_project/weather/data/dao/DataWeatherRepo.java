package com.spring.pet.spring_pet_project.weather.data.dao;

import com.spring.pet.spring_pet_project.weather.data.entity.DataWeather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataWeatherRepo extends JpaRepository<DataWeather, Long> {
    //    String getAllByMain(); //Спринг сам помогает создавать методы
}
