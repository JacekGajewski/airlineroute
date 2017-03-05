package com.asid.algorithms.mapper;

import com.asid.algorithms.entity.Airport;

import java.util.List;

/**
 * Do not modify this class if it is not necessary.
 */
public class AirportMapper {
    public static Airport toAirport(Airport source) {
        Airport target = null;
        if (source != null) {
            target = new Airport();
            target.setIataCode(source.getIataCode());
            target.setName(source.getName());
            target.setLatitude(source.getLatitude());
            target.setLongitude(source.getLongitude());
        }
        return target;
    }

    public static void toAirports(List<Airport> source, List<Airport> target) {
        if (target == null) {
            throw new IllegalArgumentException("Argument target must be filled!");
        }
        if (source != null) {
            for (Airport airport : source) {
                target.add(toAirport(airport));
            }
        }
    }
}
