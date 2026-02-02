package org.raincheck.raincheck.client;

import org.raincheck.raincheck.client.dto.WeatherApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "weatherClient", url = "${weather.api.url}")
public interface WeatherApiClient {

    @GetMapping(path = "v1/forecast.json")
    ResponseEntity<WeatherApiResponse> getForecast(@RequestParam("key") String apiKey,
                                                   @RequestParam("q") String location,
                                                   @RequestParam("days") String day);
}