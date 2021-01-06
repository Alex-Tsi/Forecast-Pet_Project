package com.spring.pet.spring_pet_project.weather.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "weathers")
//@JsonDeserialize(using = DataWeather.WeatherDeserializer.class)
public class DataWeather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "main")
    private String main;

    @Column(name = "description")
    private String description;

    @Column(name = "temp")
    private double temp;

    @Column(name = "feels_like")
    private double feelsLike;

    @Column(name = "temp_min")
    private double tempMin;

    @Column(name = "temp_max")
    private double tempMax;

    @Column(name = "wind_speed")
    private double windSpeed;

    @Column(name = "city")
    private String city;


    public DataWeather(String main, String description, double temp, double feelsLike, double tempMin, double tempMax, double windSpeed, String city) {
        this.main = main;
        this.description = description;
        this.temp = temp;
        this.feelsLike = feelsLike;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.windSpeed = windSpeed;
        this.city = city;
    }
}