package com.suniti.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.suniti.app.dto.CitizenDto.CreateRequest;
import com.suniti.app.dto.EligibilityDto.CheckRequest;
import com.suniti.app.dto.EligibilityDto.PolicySnapshot;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EligibilityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void eligibilityCheckReturnsPlaceholderScore() throws Exception {
        // Register citizen first
        CreateRequest req = new CreateRequest(
                "Bob", "District-2", "OBC", 3, 150000, "pucca", "bob@example.com");
        String citizenResponse = mockMvc.perform(post("/citizen")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        String citizenId = objectMapper.readTree(citizenResponse).get("id").asText();

        CheckRequest check = new CheckRequest(citizenId, new PolicySnapshot(
                "PMAY", List.of("income <= 300000", "houseType in [kutcha, semi-pucca, pucca]")));

        mockMvc.perform(post("/eligibility/check")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(check)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.eligible").value(true))
                .andExpect(jsonPath("$.score").exists());
    }
}
