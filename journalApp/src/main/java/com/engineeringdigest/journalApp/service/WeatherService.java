package com.engineeringdigest.journalApp.service;


import com.engineeringdigest.journalApp.api.response.WeatherResponse;
import com.engineeringdigest.journalApp.cache.AppCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;
//    private static final String API = "http://api.weatherapi.com/v1/current.json?key=APIKEY&q=";
    // now we don't need this hard coded api url we will call AppCache which will get data from database and then store it in cache

    @Autowired
    private AppCache appCache;

    private String API;



    @Autowired
    private RestTemplate restTemplate;


    public WeatherResponse getWeather(String city) {

        if (city == null || city.isEmpty()) {
            throw new IllegalArgumentException("City cannot be null or empty");
        }
        API = appCache.appCache.get(AppCache.keys.WEATHER_API.toString());
        String encodedCity = URLEncoder.encode(city, StandardCharsets.UTF_8);
        String finalKey = API.replace("<API_KEY>",apiKey) + encodedCity + "&aqi=no";

        WeatherResponse weatherResponse = restTemplate.getForObject(finalKey, WeatherResponse.class);

        ResponseEntity<String> response = restTemplate.getForEntity(finalKey, String.class);


        log.info("Weather Api Called and the response has been generated");
        return weatherResponse;
    }
}
