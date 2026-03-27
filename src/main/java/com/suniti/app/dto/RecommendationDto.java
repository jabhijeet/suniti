package com.suniti.app.dto;

import java.util.List;

public class RecommendationDto {
    public record RecommendResponse(List<String> schemes, String rationale) {}
}
