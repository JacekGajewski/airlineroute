package com.asid.algorithms.mapper;

import com.asid.algorithms.entity.Airline;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Do not modify this class if it is not necessary.
 */
public class AirlineMapperTest {
    private static final String AIRLINE1_CODE = "a1c";
    private static final String AIRLINE2_CODE = "a2c";
    private static final String AIRLINE1_NAME = "a1n";
    private static final String AIRLINE2_NAME = "a2n";

    @Test
    public void shouldCopyAirlines() {
        //Pre
        Airline airline1 = buildAirline(AIRLINE1_CODE, AIRLINE1_NAME);
        Airline airline2 = buildAirline(AIRLINE2_CODE, AIRLINE2_NAME);
        List<Airline> airlines = Arrays.asList(airline1, airline2);

        //Act
        List<Airline> result = new ArrayList<>();
        AirlineMapper.toAirlines(airlines, result);

        //Assert
        Assert.assertEquals(2, result.size());
        Assert.assertEquals(airline1, result.get(0));
        Assert.assertEquals(airline2, result.get(1));
    }

    private Airline buildAirline(String code, String name) {
        Airline airline = new Airline();
        airline.setCode(code);
        airline.setName(name);
        return airline;
    }
}