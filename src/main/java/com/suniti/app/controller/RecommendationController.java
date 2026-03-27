package com.suniti.app.controller;

import com.suniti.app.dto.RecommendationDto.RecommendResponse;
import com.suniti.app.service.RecommendationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schemes")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/recommend/{citizenId}")
    public ResponseEntity<RecommendResponse> recommend(@PathVariable String citizenId) {
        return ResponseEntity.ok(recommendationService.recommend(citizenId));
    }
}
