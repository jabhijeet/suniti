package com.suniti.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.suniti.app.dto.CitizenDto.CreateRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RecommendationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void recommendReturnsPlaceholderSchemes() throws Exception {
        CreateRequest req = new CreateRequest(
                "Charlie", "District-3", "General", 2, 200000, "semi-pucca", "charlie@example.com");
        String citizenResponse = mockMvc.perform(post("/citizen")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        String citizenId = objectMapper.readTree(citizenResponse).get("id").asText();

        mockMvc.perform(get("/schemes/recommend/" + citizenId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.schemes").isArray());
    }
}
