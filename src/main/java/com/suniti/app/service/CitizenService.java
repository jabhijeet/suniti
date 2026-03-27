package com.suniti.app.service;

import com.suniti.app.dto.CitizenDto.CreateRequest;
import com.suniti.app.dto.CitizenDto.Response;
import com.suniti.app.model.Citizen;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CitizenService {

    private final Map<String, Citizen> citizens = new ConcurrentHashMap<>();

    public Response register(CreateRequest request) {
        Citizen citizen = new Citizen(
                request.name(), request.district(), request.category(),
                request.familySize(), request.income(), request.houseType(), request.email());
        citizens.put(citizen.getId(), citizen);
        return toResponse(citizen);
    }

    public Optional<Response> getById(String id) {
        return Optional.ofNullable(citizens.get(id)).map(this::toResponse);
    }

    private Response toResponse(Citizen citizen) {
        return new Response(
                citizen.getId(), citizen.getName(), citizen.getDistrict(),
                citizen.getCategory(), citizen.getFamilySize(), citizen.getIncome(),
                citizen.getHouseType(), citizen.getEmail()
        );
    }
}
