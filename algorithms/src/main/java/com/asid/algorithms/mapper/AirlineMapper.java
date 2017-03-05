package com.asid.algorithms.mapper;

import com.asid.algorithms.entity.Airline;

import java.util.List;

/**
 * Do not modify this class if it is not necessary.
 */
public class AirlineMapper {
    public static Airline toAirline(Airline source) {
        Airline target = null;
        if (source != null) {
            target = new Airline();
            target.setCode(source.getCode());
            target.setName(source.getName());
        }
        return target;
    }

    public static void toAirlines(List<Airline> source, List<Airline> target) {
        if (target == null) {
            throw new IllegalArgumentException("Argument target must be filled!");
        }
        if (source != null) {
            for (Airline airline : source) {
                target.add(toAirline(airline));
            }
        }
    }
}
