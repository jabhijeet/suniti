package com.suniti.app.dto;

public class AuthResponses {
    public record LoginResponse(String token, String refreshToken, String name, String email) {}
    public record RegisterResponse(String id, String name, String email) {}
}
