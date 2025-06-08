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
                .andExpect(jsonPath("$.idVoiture", is((int)location.getIdVoiture())))
                .andExpect(jsonPath("$.idUser", is((int)location.getIdUser())))
                .andExpect(jsonPath("$.idAccessCard", is((int)location.getIdAccessCard())))
                .andExpect(jsonPath("$.idStation", is((int)location.getIdStation())));
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
                .andExpect(jsonPath("$.idVoiture", is((int)locationObject.getIdVoiture())))
                .andExpect(jsonPath("$.idUser", is((int)locationObject.getIdUser())))
                .andExpect(jsonPath("$.idAccessCard", is((int)locationObject.getIdAccessCard())))
                .andExpect(jsonPath("$.idStation", is((int)locationObject.getIdStation())));
    }


}
