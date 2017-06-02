package com.asid.algorithms.graph;

import com.asid.algorithms.database.DataLoader;
import com.asid.algorithms.database.DataLoaderImpl;
import com.asid.algorithms.database.InmemmoryDataBase;
import com.asid.algorithms.entity.Airport;
import com.asid.algorithms.entity.Route;
import com.asid.algorithms.mapper.AirportMapper;
import com.asid.algorithms.mapper.RouteMapper;
import com.asid.foundation.datastructure.graph.AirportEdgeFactory;
import com.asid.foundation.datastructure.graph.CustomDirectedWeightGraphAdapter;
import com.asid.foundation.datastructure.graph.DefaultEdge;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by tnt9 on 02.06.17.
 */
public class ShortestRouteFindingTest {

    private static String FROM;
    private static String TO;
    private CustomDirectedWeightGraphAdapter graph;
    @Before
    public void pre() {

        DataLoader loader = new DataLoaderImpl();

        loader.loadAllData("/home/tnt9/Downloads/airlineroute/algorithms/resources/airports.dat",
                "/home/tnt9/Downloads/airlineroute/algorithms/resources/airlines.dat",
                "/home/tnt9/Downloads/airlineroute/algorithms/resources/routes.dat");

        List<Airport> airports = new LinkedList<>();
        AirportMapper airportMapper = new AirportMapper();
        airportMapper.toAirports((InmemmoryDataBase.getInstance().getAirports()), airports);

        List<Route> routes = new LinkedList<>();
        RouteMapper routeMapper = new RouteMapper();
        routeMapper.toRoutes(InmemmoryDataBase.getInstance().getRoutes(), routes); // Nie ładuje ostatniego

        AirportEdgeFactory airportEdgeFactory = new AirportEdgeFactory();
        graph = new CustomDirectedWeightGraphAdapter(airportEdgeFactory, true);

        for (int i = 0; i < airports.size(); i++){
            graph.addVertex(airports.get(i));
        }
        for (int i = 0; i < routes.size(); i++){
            double weight = Math.sqrt(Math.pow((routes.get(i).getOrigin().getLongitude() - routes.get(i).getDestination().getLongitude()), 2) +
                    Math.pow((routes.get(i).getOrigin().getLatitude() - routes.get(i).getDestination().getLatitude()), 2));
            graph.addEdgeAndWeight(routes.get(i).getOrigin(), routes.get(0).getDestination(), (long) weight);
        }
    }

    @Test
    public void shouldDoSth(){

        ShortestPathService shortestPathService = new ShortestPathService();
        shortestPathService.searchShortestPathUsingDijkstraAlg(graph, "AAA", "AAE");
    }

}
