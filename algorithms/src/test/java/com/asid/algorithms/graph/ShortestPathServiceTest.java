package com.asid.algorithms.graph;

import com.asid.foundation.datastructure.graph.AbstractUndirectedWeightGraphAdapter;
import com.asid.foundation.datastructure.graph.AirportEdgeFactory;
import com.asid.foundation.datastructure.graph.CustomUndirectedWeightGraphAdapter;
import org.jgrapht.UndirectedGraph;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by tnt9 on 02.06.17.
 */
public class ShortestPathServiceTest {

    @Test
    public void DijkstraAlg() {

        AirportEdgeFactory airportEdgeFactory = new AirportEdgeFactory();

        AbstractUndirectedWeightGraphAdapter graph = new CustomUndirectedWeightGraphAdapter(airportEdgeFactory, true);

        Integer zero = new Integer(0);
        Integer one = new Integer(1);
        Integer two = new Integer(2);
        graph.addVertex(zero);
        graph.addVertex(one);
        graph.addVertex(two);
        graph.setEdgeWeight(graph.addEdge(one, two), 3);
        graph.setEdgeWeight(graph.addEdge(one, zero), 1);
        graph.setEdgeWeight(graph.addEdge(zero, two), 2);

        Object a = new Object();
        Object b = new Object();

        ShortestPathService shortestPathService = new ShortestPathService();
        Assert.assertEquals(1, shortestPathService.searchShortestPathUsingDijkstraAlg(graph, zero, one).getTotalWeight(), 0.01);
        Assert.assertEquals(1, shortestPathService.searchShortestPathUsingDijkstraAlg(graph, zero, one).getEgdes().size());
        Assert.assertTrue(shortestPathService.searchShortestPathUsingDijkstraAlg(graph, zero, one).getEgdes().contains(graph.getEdge(zero, one)));


        Integer three = new Integer(3);
        Integer four = new Integer(4);
        Integer five = new Integer(5);
        Integer six = new Integer(6);
        graph.addVertex(three);
        graph.addVertex(four);
        graph.addVertex(five);
        graph.addVertex(six);
        graph.setEdgeWeight(graph.addEdge(one, three), 4);
        graph.setEdgeWeight(graph.addEdge(two, four), 7);
        graph.setEdgeWeight(graph.addEdge(five, six), 6);
        graph.setEdgeWeight(graph.addEdge(five, four), 5);
        graph.setEdgeWeight(graph.addEdge(five, three), 4);
        graph.setEdgeWeight(graph.addEdge(six, four), 7);

        Assert.assertEquals(7, shortestPathService.searchShortestPathUsingDijkstraAlg(graph, four, two).getTotalWeight(), 0.01);
        Assert.assertEquals(2, shortestPathService.searchShortestPathUsingDijkstraAlg(graph, zero, one).getEgdes().size());
        Assert.assertTrue(shortestPathService.searchShortestPathUsingDijkstraAlg(graph, zero, one).getEgdes().contains(graph.getEdge(zero, one)));

    }

}
