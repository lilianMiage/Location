package fr.miage.lroux.location.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import fr.miage.lroux.location.entity.Location;
import fr.miage.lroux.location.repository.RepoLocation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
public class ControllerLocationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private RepoLocation repoLocation;

    private Location location;

    @BeforeEach
    void setUp() {
        location = new Location(1, 2, 3,4);
        location = repoLocation.save(location);
    }

    @Test
    public void getLocationById() throws Exception {
        mvc.perform(get("/api/location/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.carId", is((int)location.getCarId())))
                .andExpect(jsonPath("$.userId", is((int)location.getUserId())))
                .andExpect(jsonPath("$.accessCardId", is((int)location.getAccessCardId())))
                .andExpect(jsonPath("$.stationId", is((int)location.getStationId())));
    }

    @Test
    public void creationLocation() throws Exception{
        Location locationObject = new Location(11, 22, 33,44);
        ObjectMapper om = new ObjectMapper();
        String stationJson = om.writeValueAsString(locationObject);
        mvc.perform(post("/api/location/create")
                        .contentType("application/json")
                        .content(stationJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.carId", is((int)locationObject.getCarId())))
                .andExpect(jsonPath("$.userId", is((int)locationObject.getUserId())))
                .andExpect(jsonPath("$.accessCardId", is((int)locationObject.getAccessCardId())))
                .andExpect(jsonPath("$.stationId", is((int)locationObject.getStationId())));
    }


}
