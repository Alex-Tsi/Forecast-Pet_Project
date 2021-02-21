package com.spring.pet.spring_pet_project.weather.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOWeather {

    @JsonProperty("name")
    private String name;

    @JsonProperty("weather")
    private List<Weather> weatherList;

    /*@JsonProperty("main")
    private Main main;*/

    @JsonProperty("main")
    @JsonIgnoreProperties(value = {"pressure", "humidity"})
    private Map<String, Double> main;


    @JsonProperty("wind")
    private Wind wind;

    @Data
    @JsonTypeName("weather")
    public static class Weather {
        private String main;

        private String description;
    }

    @Data
    @JsonTypeName("wind")
    public static class Wind {
        @JsonProperty("speed")
        private double speed;
    }
}
