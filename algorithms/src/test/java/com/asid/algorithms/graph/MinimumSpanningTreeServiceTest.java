package com.asid.algorithms.graph;

import com.asid.foundation.datastructure.graph.AbstractUndirectedWeightGraphAdapter;
import com.asid.foundation.datastructure.graph.AirportEdgeFactory;
import com.asid.foundation.datastructure.graph.CustomUndirectedWeightGraphAdapter;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by tnt9 on 19.05.17.
 */
public class MinimumSpanningTreeServiceTest {

        @Test
        public void primAlg() {

            AirportEdgeFactory airportEdgeFactory = new AirportEdgeFactory();

            CustomUndirectedWeightGraphAdapter customUndirectedWeightGraphAdapter = new CustomUndirectedWeightGraphAdapter(airportEdgeFactory, true);

            Integer zero = new Integer(0);
            Integer one = new Integer(1);
            Integer two = new Integer(2);
            customUndirectedWeightGraphAdapter.addVertex(zero);
            customUndirectedWeightGraphAdapter.addVertex(one);
            customUndirectedWeightGraphAdapter.addVertex(two);
            customUndirectedWeightGraphAdapter.setEdgeWeight(customUndirectedWeightGraphAdapter.addEdge(one, two), 3);
            customUndirectedWeightGraphAdapter.setEdgeWeight(customUndirectedWeightGraphAdapter.addEdge(one, zero), 1);
            customUndirectedWeightGraphAdapter.setEdgeWeight(customUndirectedWeightGraphAdapter.addEdge(zero, two), 2);

            MinimumSpanningTreeService minimumSpanningTreeService = new MinimumSpanningTreeService();

            Assert.assertEquals(3, minimumSpanningTreeService.searchMinimumSpanningTreeUsingPrimAlg(customUndirectedWeightGraphAdapter).getTotalWeight(), 0.01);
            Assert.assertEquals(2, minimumSpanningTreeService.searchMinimumSpanningTreeUsingPrimAlg(customUndirectedWeightGraphAdapter).getEgdes().size());

            Integer three = new Integer(3);
            Integer four = new Integer(4);
            Integer five = new Integer(5);
            Integer six = new Integer(6);
            customUndirectedWeightGraphAdapter.addVertex(three);
            customUndirectedWeightGraphAdapter.addVertex(four);
            customUndirectedWeightGraphAdapter.addVertex(five);
            customUndirectedWeightGraphAdapter.addVertex(six);
            customUndirectedWeightGraphAdapter.setEdgeWeight(customUndirectedWeightGraphAdapter.addEdge(one, three), 4);
            customUndirectedWeightGraphAdapter.setEdgeWeight(customUndirectedWeightGraphAdapter.addEdge(two, four), 7);
            customUndirectedWeightGraphAdapter.setEdgeWeight(customUndirectedWeightGraphAdapter.addEdge(five, six), 6);
            customUndirectedWeightGraphAdapter.setEdgeWeight(customUndirectedWeightGraphAdapter.addEdge(five, four), 5);
            customUndirectedWeightGraphAdapter.setEdgeWeight(customUndirectedWeightGraphAdapter.addEdge(five, three), 4);
            customUndirectedWeightGraphAdapter.setEdgeWeight(customUndirectedWeightGraphAdapter.addEdge(six, four), 7);

            Assert.assertEquals(28, minimumSpanningTreeService.searchMinimumSpanningTreeUsingPrimAlg(customUndirectedWeightGraphAdapter).getTotalWeight(), 0.01);
            Assert.assertEquals(6, minimumSpanningTreeService.searchMinimumSpanningTreeUsingPrimAlg(customUndirectedWeightGraphAdapter).getEgdes().size());

        }
    @Test
    public void KruskaAlg() {

        AirportEdgeFactory airportEdgeFactory = new AirportEdgeFactory();

        CustomUndirectedWeightGraphAdapter customUndirectedWeightGraphAdapter = new CustomUndirectedWeightGraphAdapter(airportEdgeFactory, true);

        Integer zero = new Integer(0);
        Integer one = new Integer(1);
        Integer two = new Integer(2);
        customUndirectedWeightGraphAdapter.addVertex(zero);
        customUndirectedWeightGraphAdapter.addVertex(one);
        customUndirectedWeightGraphAdapter.addVertex(two);
        customUndirectedWeightGraphAdapter.setEdgeWeight(customUndirectedWeightGraphAdapter.addEdge(one, two), 3);
        customUndirectedWeightGraphAdapter.setEdgeWeight(customUndirectedWeightGraphAdapter.addEdge(one, zero), 1);
        customUndirectedWeightGraphAdapter.setEdgeWeight(customUndirectedWeightGraphAdapter.addEdge(zero, two), 2);

        MinimumSpanningTreeService minimumSpanningTreeService = new MinimumSpanningTreeService();

        Assert.assertEquals(3, minimumSpanningTreeService.searchMinimumSpanningTreeUsingKruskalAlg(customUndirectedWeightGraphAdapter).getTotalWeight(), 0.01);
        Assert.assertEquals(2, minimumSpanningTreeService.searchMinimumSpanningTreeUsingKruskalAlg(customUndirectedWeightGraphAdapter).getEgdes().size());

        Integer three = new Integer(3);
        Integer four = new Integer(4);
        Integer five = new Integer(5);
        Integer six = new Integer(6);
        customUndirectedWeightGraphAdapter.addVertex(three);
        customUndirectedWeightGraphAdapter.addVertex(four);
        customUndirectedWeightGraphAdapter.addVertex(five);
        customUndirectedWeightGraphAdapter.addVertex(six);
        customUndirectedWeightGraphAdapter.setEdgeWeight(customUndirectedWeightGraphAdapter.addEdge(one, three), 4);
        customUndirectedWeightGraphAdapter.setEdgeWeight(customUndirectedWeightGraphAdapter.addEdge(two, four), 7);
        customUndirectedWeightGraphAdapter.setEdgeWeight(customUndirectedWeightGraphAdapter.addEdge(five, six), 6);
        customUndirectedWeightGraphAdapter.setEdgeWeight(customUndirectedWeightGraphAdapter.addEdge(five, four), 5);
        customUndirectedWeightGraphAdapter.setEdgeWeight(customUndirectedWeightGraphAdapter.addEdge(five, three), 4);
        customUndirectedWeightGraphAdapter.setEdgeWeight(customUndirectedWeightGraphAdapter.addEdge(six, four), 7);

        Assert.assertEquals(28, minimumSpanningTreeService.searchMinimumSpanningTreeUsingKruskalAlg(customUndirectedWeightGraphAdapter).getTotalWeight(), 0.01);
        Assert.assertEquals(6, minimumSpanningTreeService.searchMinimumSpanningTreeUsingKruskalAlg(customUndirectedWeightGraphAdapter).getEgdes().size());

    }

}
