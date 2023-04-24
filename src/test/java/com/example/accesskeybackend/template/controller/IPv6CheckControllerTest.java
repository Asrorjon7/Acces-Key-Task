package com.example.accesskeybackend.template.controller;

import com.example.accesskeybackend.template.dto.IPv6CheckResponse;
import com.example.accesskeybackend.template.service.IPv6CheckService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class IPv6CheckControllerTest {
    @Mock
    private IPv6CheckService iPv6CheckService;
    @InjectMocks
    private IPv6CheckController iPv6CheckController;
    MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(iPv6CheckController).build();
    }

    @Test
    void ischeckIPv6() throws Exception {
        Mockito.lenient().when(iPv6CheckService.ipCheckResponse("google.com")).thenReturn(new IPv6CheckResponse(true));

        mockMvc.perform(get("/api/public/checkIpv6Support")
                        .queryParam("siteUrl", "google.com"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true));
    }

}