package com.anuj.FirstSpringBootProject.service;


import com.anuj.FirstSpringBootProject.api.response.WeatherResponse;
import com.anuj.FirstSpringBootProject.cache.AppCache;
import com.anuj.FirstSpringBootProject.constants.Placeholders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${WEATHER_API_ACCESS_KEY}")
    private String WEATHER_API_ACCESS_KEY;

    @Autowired
    private AppCache appCache;

    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponse getWeatherResponse(String city) {
        String finalAPI = appCache.APP_CACHE.get(AppCache.keys.WEATHER_API.toString()).replace(Placeholders.API_KEY,WEATHER_API_ACCESS_KEY).replace(Placeholders.CITY,city);

        try {
            ResponseEntity<WeatherResponse> res = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);
            WeatherResponse resBody = res.getBody();
            return resBody;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
