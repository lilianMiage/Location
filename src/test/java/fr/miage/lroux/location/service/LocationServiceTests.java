package fr.miage.lroux.location.service;

import fr.miage.lroux.location.entity.Location;
import fr.miage.lroux.location.repository.RepoLocation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class LocationServiceTests {

    @Mock
    private RepoLocation repoLocation;

    @InjectMocks
    private ServiceLocation locationService;

    private Location location;

    @BeforeEach
    public void setUp() {
        location = new Location(1L, 2L, 3L, 4L);
        location.setIdLocation(10L);
    }

    @Test
    public void testCreateLocation_WhenLocationDoesNotExist_ShouldSaveAndReturnLocation() throws Exception {
        // Arrange
        when(repoLocation.findById(10L)).thenReturn(Optional.empty());
        when(repoLocation.save(location)).thenReturn(location);

        // Act
        Location result = locationService.createLocation(location);

        // Assert
        assertNotNull(result);
        assertEquals(location.getIdLocation(), result.getIdLocation());
        verify(repoLocation).findById(10L);
        verify(repoLocation).save(location);
    }

    @Test
    public void testCreateLocation_WhenLocationExists_ShouldThrowException() {
        // Arrange
        when(repoLocation.findById(10L)).thenReturn(Optional.of(location));

        // Act & Assert
        Exception exception = assertThrows(Exception.class, () -> {
            locationService.createLocation(location);
        });

        assertEquals("A location with this ID 10 already exists", exception.getMessage());
        verify(repoLocation).findById(10L);
        verify(repoLocation, never()).save(any());
    }

    @Test
    public void testGetLocationById_WhenExists_ShouldReturnLocation() throws Exception {
        // Arrange
        when(repoLocation.findById(10L)).thenReturn(Optional.of(location));

        // Act
        Location result = locationService.getLocationById(10L);

        // Assert
        assertNotNull(result);
        assertEquals(10L, result.getIdLocation());
        verify(repoLocation).findById(10L);
    }

    @Test
    public void testGetLocationById_WhenNotExists_ShouldThrowException() {
        // Arrange
        when(repoLocation.findById(10L)).thenReturn(Optional.empty());

        // Act & Assert
        Exception exception = assertThrows(Exception.class, () -> {
            locationService.getLocationById(10L);
        });

        assertEquals("A location with this ID 10 does not exist", exception.getMessage());
        verify(repoLocation).findById(10L);
    }
}
