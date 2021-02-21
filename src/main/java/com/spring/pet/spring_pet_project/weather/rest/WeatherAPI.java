package com.spring.pet.spring_pet_project.weather.rest;

import com.spring.pet.spring_pet_project.weather.data.entity.DataWeather;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/weather")
public class WeatherAPI {

    private final WeatherService weatherService;

    public WeatherAPI(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public DataWeather getWeather(
            /*@RequestParam(name = "id") String idCity,
              @RequestParam(name = "appid") String key*/
    ) {
        DataWeather weather = weatherService.getWeather(/*idCity, key*/);
        return weather;
    }

    @GetMapping("/{id}")
    public DataWeather getWeather(@PathVariable(name = "id") long id) {
        return weatherService.getWeather(id);
    }

    @PostMapping("/")
    public void addWeather(@RequestBody DataWeather dataWeather) {
        weatherService.saveOrChangeWeather(dataWeather);
    }

    @PutMapping("/")
    public void changeWeather(@RequestBody DataWeather dataWeather) {
        weatherService.saveOrChangeWeather(dataWeather);
    }

    @DeleteMapping("/{id}")
    public void deleteWeather(@PathVariable(name = "id") long id) {
        weatherService.deleteWeatherById(id);
    }
}