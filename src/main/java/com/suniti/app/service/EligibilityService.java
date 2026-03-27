package com.suniti.app.service;

import com.suniti.app.dto.EligibilityDto.CheckRequest;
import com.suniti.app.dto.EligibilityDto.CheckResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EligibilityService {

    public CheckResponse check(CheckRequest request) {
        // Placeholder rule evaluation; replace with real rules/ML
        boolean eligible = true;
        double score = 0.85;
        List<String> reasons = List.of("Placeholder rule matched", "Synthetic scoring");
        return new CheckResponse(eligible, score, reasons);
    }
}
