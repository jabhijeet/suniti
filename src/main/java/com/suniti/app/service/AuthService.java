package com.suniti.app.service;

import com.suniti.app.dto.AuthRequests.LoginRequest;
import com.suniti.app.dto.AuthRequests.RegisterRequest;
import com.suniti.app.dto.AuthResponses.LoginResponse;
import com.suniti.app.dto.AuthResponses.RegisterResponse;
import com.suniti.app.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AuthService {

    private final Map<String, User> usersByEmail = new ConcurrentHashMap<>();
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public RegisterResponse register(RegisterRequest request) {
        if (usersByEmail.containsKey(request.email())) {
            throw new IllegalArgumentException("Email already registered");
        }
        String hash = passwordEncoder.encode(request.password());
        User user = new User(request.name(), request.email(), hash);
        usersByEmail.put(user.getEmail(), user);
        return new RegisterResponse(user.getId(), user.getName(), user.getEmail());
    }

    public LoginResponse login(LoginRequest request) {
        Optional<User> userOpt = Optional.ofNullable(usersByEmail.get(request.email()));
        User user = userOpt.orElseThrow(() -> new IllegalArgumentException("Invalid credentials"));
        if (!passwordEncoder.matches(request.password(), user.getPasswordHash())) {
            throw new IllegalArgumentException("Invalid credentials");
        }
        // Placeholder tokens; replace with JWT in production
        String token = "token-" + user.getId();
        String refresh = "refresh-" + user.getId();
        return new LoginResponse(token, refresh, user.getName(), user.getEmail());
    }
}
