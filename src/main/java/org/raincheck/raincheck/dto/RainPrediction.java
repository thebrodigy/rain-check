package org.raincheck.raincheck.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RainPrediction {

    private String location;
    private boolean rainCheck;
    private String chanceOfRain;
}
