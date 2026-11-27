package com.anuj.FirstSpringBootProject.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class WeatherResponse {
    public Current current;

    @Getter
    @Setter
    public static class Current {
        @JsonProperty("observation_time")
        public String observationTime;

        public int temperature;

        @JsonProperty("weather_code")
        public int weatherCode;

        @JsonProperty("weather_icons")
        public String[] weatherIcons;

        @JsonProperty("weather_descriptions")
        public String[] weatherDescriptions;

    }
}
