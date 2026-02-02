package org.raincheck.raincheck.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherApiResponse {

    private Location location;
    private Current current;
    private Forecast forecast;

    @Setter
    @Getter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Location {

        private String name;
        private String region;
        private String country;
        private double lat;
        private double lon;

        @JsonProperty("tz_id")
        private String tzId;

        @JsonProperty("localtime_epoch")
        private long localtimeEpoch;

        private String localtime;

    }

    @Setter
    @Getter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Current {

        @JsonProperty("last_updated_epoch")
        private long lastUpdatedEpoch;

        @JsonProperty("last_updated")
        private String lastUpdated;

        @JsonProperty("temp_c")
        private double tempC;

        @JsonProperty("temp_f")
        private double tempF;

        @JsonProperty("is_day")
        private int isDay;

        private Condition condition;

        @JsonProperty("wind_mph")
        private double windMph;

        @JsonProperty("wind_kph")
        private double windKph;

        @JsonProperty("wind_degree")
        private int windDegree;

        @JsonProperty("wind_dir")
        private String windDir;

        @JsonProperty("pressure_mb")
        private double pressureMb;

        @JsonProperty("pressure_in")
        private double pressureIn;

        @JsonProperty("precip_mm")
        private double precipMm;

        @JsonProperty("precip_in")
        private double precipIn;

        private int humidity;
        private int cloud;

        @JsonProperty("feelslike_c")
        private double feelslikeC;

        @JsonProperty("feelslike_f")
        private double feelslikeF;

        @JsonProperty("vis_km")
        private double visKm;

        private double uv;

    }

    @Setter
    @Getter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Forecast {

        @JsonProperty("forecastday")
        private List<ForecastDay> forecastDay;

    }

    @Setter
    @Getter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Condition {

        private String text;
        private String icon;
        private int code;

    }

    @Setter
    @Getter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ForecastDay {

        private Day day;


    }

    @Setter
    @Getter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Day {

        @JsonProperty("daily_will_it_rain")
        private boolean dailyWillItRain;

        @JsonProperty("daily_chance_of_rain")
        private String dailyChanceOfRain;

    }
}