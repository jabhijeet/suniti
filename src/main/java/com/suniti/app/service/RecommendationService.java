package com.suniti.app.service;

import com.suniti.app.dto.RecommendationDto.RecommendResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {

    public RecommendResponse recommend(String citizenId) {
        // Placeholder recommendation; replace with RAG/ML output
        return new RecommendResponse(
                List.of("PMAY-G", "PMAY-U"),
                "Placeholder rationale: citizen matches baseline criteria"
        );
    }
}
