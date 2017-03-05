package com.asid.algorithms.mapper;

import com.asid.algorithms.entity.Airport;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Do not modify this class if it is not necessary.
 */
public class AirportMapperTest {
    @Test
    public void shouldCopyAirports() {
        //Pre
        Airport airport1 = buildAirport("a", "b", 1, 2);
        Airport airport2 = buildAirport("c", "d", 3, 4);
        List<Airport> airports = Arrays.asList(airport1, airport2);

        //Act
        List<Airport> result = new ArrayList<>();
        AirportMapper.toAirports(airports, result);

        //Assert
        Assert.assertEquals(2, result.size());
        Assert.assertEquals(airport1, result.get(0));
        Assert.assertEquals(airport2, result.get(1));
    }

    private Airport buildAirport(String iataCode, String name, int longitude, long latitude) {
        Airport airport = new Airport();
        airport.setIataCode(iataCode);
        airport.setName(name);
        airport.setLongitude(longitude);
        airport.setLatitude(latitude);
        return airport;
    }
}