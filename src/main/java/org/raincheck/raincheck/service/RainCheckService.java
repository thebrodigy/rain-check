package org.raincheck.raincheck.service;

import org.raincheck.raincheck.client.dto.WeatherApiResponse;
import org.raincheck.raincheck.dto.RainPrediction;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RainCheckService {
    private final WeatherService weatherService;

    public RainCheckService(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Cacheable(value = "predictions", key = "#location")
    public RainPrediction getPrediction(String location) {
        WeatherApiResponse weatherInfo = weatherService.checkRain(location);

        if (weatherInfo == null
                || weatherInfo.getForecast() == null
                || weatherInfo.getForecast().getForecastDay().isEmpty()) {
            throw new IllegalArgumentException("No forecast data available for location: " + location);
        }

        WeatherApiResponse.ForecastDay forecastDay = weatherInfo.getForecast().getForecastDay().getFirst();
        WeatherApiResponse.Day day = forecastDay.getDay();

        return new RainPrediction(location, day.isDailyWillItRain(), day.getDailyChanceOfRain()
        );
    }
}