package com.suniti.app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class CitizenDto {
    public record CreateRequest(
            @NotBlank String name,
            @NotBlank String district,
            @NotBlank String category,
            @PositiveOrZero int familySize,
            @PositiveOrZero long income,
            @NotBlank String houseType,
            @Email String email
    ) {}

    public record Response(
            String id,
            String name,
            String district,
            String category,
            int familySize,
            long income,
            String houseType,
            String email
    ) {}
}
