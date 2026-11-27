package com.anuj.FirstSpringBootProject.service;


import com.anuj.FirstSpringBootProject.api.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {
    @Value("${WEATHER_API_ACCESS_KEY}")
    private String WEATHER_API_ACCESS_KEY;

    private static final String API = "http://api.weatherstack.com/current?access_key=YOUR_ACCESS_KEY&query=CITY";

    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponse getWeatherResponse(String city) {
        String finalAPI = API.replace("YOUR_ACCESS_KEY",WEATHER_API_ACCESS_KEY).replace("CITY",city);

        try {
            ResponseEntity<WeatherResponse> res = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);
            return res.getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
