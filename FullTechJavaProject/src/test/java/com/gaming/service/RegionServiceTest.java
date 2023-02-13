package com.gaming.service;

import com.gaming.advice.exception.NoSuchRegionException;
import com.gaming.persistence.entity.RegionEntity;
import com.gaming.persistence.repository.RegionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class RegionServiceTest {

    @InjectMocks
    private RegionService regionService;

    @Mock
    private RegionRepository regionRepository;


    @Test()
    void it_should_return_region_entity_by_id() {
        final Long id = 1L;
        RegionEntity entity = new RegionEntity();
        entity.setId(1L);
        entity.setCountry("Dummy");
        when(regionRepository.findById(id)).thenReturn(Optional.of(entity));
        regionService.getRegionEntityById(id);

    }


    @Test
    void it_should_return_exception_region_entity_by_id() throws NoSuchRegionException {
        final Long id = 1L;

        NoSuchRegionException exception = assertThrows(NoSuchRegionException.class, () -> {
            when(regionRepository.findById(id)).thenReturn(Optional.empty());
            regionService.getRegionEntityById(id);
        });

        String expectedMessage = "No Such Region !";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

}
