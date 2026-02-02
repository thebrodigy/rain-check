package org.raincheck.raincheck.controller;

import org.raincheck.raincheck.dto.RainPrediction;
import org.raincheck.raincheck.service.RainCheckService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/predictions")
public class PredictionController {

    private final RainCheckService service;

    public PredictionController(RainCheckService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<RainPrediction> rain(@RequestParam String location) {
        return ResponseEntity.ok(service.getPrediction(location));
    }
}
