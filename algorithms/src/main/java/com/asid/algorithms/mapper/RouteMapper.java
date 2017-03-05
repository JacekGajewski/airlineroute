package com.asid.algorithms.mapper;

import com.asid.algorithms.entity.Route;

import java.util.List;

/**
 * Do not modify this class if it is not necessary.
 */
public class RouteMapper {
    public static Route toRoute(Route source) {
        Route target = null;
        if (source != null) {
            target = new Route();
            target.setAirline(AirlineMapper.toAirline(source.getAirline()));
            target.setOrigin(AirportMapper.toAirport(source.getOrigin()));
            target.setDestination(AirportMapper.toAirport(source.getDestination()));
        }
        return target;
    }

    public static void toRoutes(List<Route> source, List<Route> target) {
        if (target == null) {
            throw new IllegalArgumentException("Argument target must be filled!");
        }
        if (source != null) {
            for (Route route : source) {
                target.add(toRoute(route));
            }
        }
    }
}
