package org.raincheck.raincheck.service;

import lombok.extern.slf4j.Slf4j;
import org.raincheck.raincheck.client.dto.WeatherApiResponse;
import org.raincheck.raincheck.client.WeatherApiClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class WeatherService {

    private final WeatherApiClient weatherApiClient;

    private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);

    @Value("${weather.api.key}")
    private String apiKey;

    public WeatherService(WeatherApiClient weatherApiClient) {
        this.weatherApiClient = weatherApiClient;
    }

    public WeatherApiResponse checkRain(String location) {
        ResponseEntity<WeatherApiResponse> response = weatherApiClient.getForecast(apiKey, location, "1");
        if(response.getStatusCode() == HttpStatus.OK && Objects.nonNull(response.getBody())) {
            logger.info("response: {}", response.getBody().toString());
            return response.getBody();
        }
        throw new IllegalArgumentException();
    }
}