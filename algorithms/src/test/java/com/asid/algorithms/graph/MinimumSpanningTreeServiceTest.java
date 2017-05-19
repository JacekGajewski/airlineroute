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

        }

}
