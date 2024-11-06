package com.iag.iagassessment.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
public class RouteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testThatCorrectAviosPointsIsReturned() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getAviosPoints?departureAirportCode=LHR&arrivalAirportCode=LAX"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$.aviosPoints").value(4500));
    }
    @Test
    public void testThatCorrectAviosPointsIsReturnedWhenAirportCodeAreChanged() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getAviosPoints?departureAirportCode=LAX&arrivalAirportCode=LHR"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$.aviosPoints").value(4500));
    }

    @Test
    public void testThatZeroAviosPointsIsReturnedWhenAirportCodesAreTheSame() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getAviosPoints?departureAirportCode=LHR&arrivalAirportCode=LHR"))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andExpect(MockMvcResultMatchers.jsonPath("$.aviosPoints").value(0));
    }

    @Test
    public void testThat500AviosPointsIsReturnedWhenRouteIsNotRecognised() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getAviosPoints?departureAirportCode=LAX&arrivalAirportCode=JFK"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$.aviosPoints").value(500));
    }

    @Test
    public void testThatDefaultAviosPointsIsReturnedWhenIncorrectCabinCodeCodeIsUsed() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getAviosPoints?departureAirportCode=LAX&arrivalAirportCode=LHR&cabinCode=U"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$.aviosPoints").value(4500));
    }

    @Test
    public void testThatErrorIsReturnedWhenThereIsNoDepartureAirportCode() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getAviosPoints?arrivalAirportCode=LHR"))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    public void testThatErrorIsReturnedWhenThereIsNoArrivalAirportCode() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getAviosPoints?departureAirportCode=LAX"))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

}
