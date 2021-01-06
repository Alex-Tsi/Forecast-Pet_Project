package com.spring.pet.spring_pet_project.weather.rest;

import com.spring.pet.spring_pet_project.weather.data.dto.DTOWeather;
import com.spring.pet.spring_pet_project.weather.data.entity.DataWeather;
import com.spring.pet.spring_pet_project.weather.data.service.RepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@EnableScheduling
public class WeatherService {
    @Value("http://api.openweathermap.org/data/2.5/weather?id=${api.weather.city.id}&appid=${api.weather.appid}")
    private String URL;
    private final RestTemplate template;
    private final RepoService repoService;

    @Autowired
    public WeatherService(@Qualifier("template") RestTemplate template,
                          @Qualifier("repoServiceImplementation") RepoService service) {
        this.template = template;
        this.repoService = service;
    }

    public DataWeather getWeather(/*String cityId, String key*/) {
        DataWeather weather = getWeatherData();
        return weather;
    }

    @Scheduled(fixedRate = 60 * 60 * 1000)
    private void saveInDbEveryHour() {
        DataWeather weather = getWeatherData();
        repoService.addWeather(weather);
        System.out.println(weather);
    }

    private DataWeather getWeatherData() {
        DTOWeather data = template.getForObject(URL, DTOWeather.class);
        System.out.println(data);
        Map<String, Double> tempMainWeather = data.getMain();
        DTOWeather.Wind tempWindWeather = data.getWind();
        DTOWeather.Weather tempWeatherData = data.getWeatherList().get(0);
        DataWeather weather = new DataWeather(
                tempWeatherData.getMain(),
                tempWeatherData.getDescription(),
                tempMainWeather.get("temp"),
                tempMainWeather.get("feels_like"),
                tempMainWeather.get("temp_min"),
                tempMainWeather.get("temp_max"),
                tempWindWeather.getSpeed(),
                data.getName()
        );
        return weather;
    }

    public DataWeather getWeather(long id) {
        DataWeather weather = repoService.getWeather(id);
        return weather;
    }

    public void saveOrChangeWeather(DataWeather weather) {
        repoService.addWeather(weather);
    }

    public void deleteWeatherById(long id) {
        repoService.deleteWeather(id);
    }
}