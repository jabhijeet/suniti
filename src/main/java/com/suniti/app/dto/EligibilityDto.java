package com.suniti.app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.List;

public class EligibilityDto {
    public record CheckRequest(
            @NotBlank String citizenId,
            @NotNull PolicySnapshot policy
    ) {}

    public record PolicySnapshot(
            String policyName,
            List<String> rules
    ) {}

    public record CheckResponse(
            boolean eligible,
            double score,
            List<String> reasons
    ) {}
}
