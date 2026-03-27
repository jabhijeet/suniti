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
class CitizenControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void registerAndFetchCitizen() throws Exception {
        CreateRequest req = new CreateRequest(
                "Alice", "District-1", "SC", 4, 120000, "kutcha", "alice@example.com");
        String location = mockMvc.perform(post("/citizen")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("alice@example.com"))
                .andReturn().getResponse().getContentAsString();

        String id = objectMapper.readTree(location).get("id").asText();
        mockMvc.perform(get("/citizen/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id));
    }
}
