package com.asid.foundation.datastructure.graph;

import com.asid.foundation.datastructure.list.CustomLinkedList;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by tnt9 on 05.05.17.
 */
public class CustomUndirectedWeightGraphAdapterTest {

    private CustomUndirectedWeightGraphAdapter createEmptyGraph() {
        AirportEdgeFactory airportEdgeFactory = new AirportEdgeFactory();
        return new CustomUndirectedWeightGraphAdapter(airportEdgeFactory, true);
    }
    @Test
    public void shouldAddEdgeAndVertex() {

        CustomUndirectedWeightGraphAdapter customUndirectedWeightGraphAdapter = createEmptyGraph();

        Assert.assertNull(customUndirectedWeightGraphAdapter.getEdge(new Integer(1), new Integer(2)));
        Assert.assertEquals((0), customUndirectedWeightGraphAdapter.edgeSet().size());
        Assert.assertTrue(customUndirectedWeightGraphAdapter.vertexSet().isEmpty());
        Assert.assertFalse(customUndirectedWeightGraphAdapter.containsEdge((new Integer(1))));
        Assert.assertFalse(customUndirectedWeightGraphAdapter.containsEdge((new Integer(1)), new Integer(2)));
        Assert.assertFalse(customUndirectedWeightGraphAdapter.containsVertex((new Integer(1))));


        Integer one = new Integer(1);
        Integer two = new Integer(2);
        customUndirectedWeightGraphAdapter.addVertex(one);
        customUndirectedWeightGraphAdapter.addVertex(two);
        customUndirectedWeightGraphAdapter.addEdge(one, two);

        Assert.assertNull(customUndirectedWeightGraphAdapter.getEdge(new Integer(1), new Integer(2)));
        Assert.assertEquals((2), customUndirectedWeightGraphAdapter.edgeSet().size()); //!!!!IS THIS RIGHT?????
        Assert.assertFalse(customUndirectedWeightGraphAdapter.vertexSet().isEmpty());
        Assert.assertFalse(customUndirectedWeightGraphAdapter.containsEdge((new Integer(1)), new Integer(2)));
        Assert.assertTrue(customUndirectedWeightGraphAdapter.containsVertex(one));


        Integer three = new Integer(3);
        Integer four = new Integer(4);
        customUndirectedWeightGraphAdapter.addVertex(three);
        customUndirectedWeightGraphAdapter.addVertex(four);
        customUndirectedWeightGraphAdapter.addEdge(one, three);
        customUndirectedWeightGraphAdapter.addEdge(one, four);
        customUndirectedWeightGraphAdapter.addEdge(two, three);

        Assert.assertEquals((8), customUndirectedWeightGraphAdapter.edgeSet().size()); // SAME HERE!!!!!!!
        Assert.assertFalse(customUndirectedWeightGraphAdapter.vertexSet().isEmpty());
        Assert.assertEquals((4), customUndirectedWeightGraphAdapter.vertexSet().size());

    }
    @Test
    public void shouldCheckIfContains() {

        CustomUndirectedWeightGraphAdapter customUndirectedWeightGraphAdapter = createEmptyGraph();

        Assert.assertFalse(customUndirectedWeightGraphAdapter.containsEdge(null));
        Assert.assertFalse(customUndirectedWeightGraphAdapter.containsVertex(new Integer(69)));

        Integer one = new Integer(1);
        Integer two = new Integer(2);
        customUndirectedWeightGraphAdapter.addVertex(one);
        customUndirectedWeightGraphAdapter.addVertex(two);
        customUndirectedWeightGraphAdapter.addEdge(one, two);

        Assert.assertTrue(customUndirectedWeightGraphAdapter.containsEdge(customUndirectedWeightGraphAdapter.getEdge(one, two)));
        Assert.assertFalse(customUndirectedWeightGraphAdapter.containsVertex(new Integer(69)));
        Assert.assertTrue(customUndirectedWeightGraphAdapter.containsVertex(one));
        Assert.assertTrue(customUndirectedWeightGraphAdapter.containsVertex(two));


        Integer three = new Integer(3);
        Integer four = new Integer(4);
        customUndirectedWeightGraphAdapter.addVertex(three);
        customUndirectedWeightGraphAdapter.addVertex(four);
        customUndirectedWeightGraphAdapter.addEdge(one, three);
        customUndirectedWeightGraphAdapter.addEdge(one, four);
        customUndirectedWeightGraphAdapter.addEdge(two, three);

        Assert.assertTrue(customUndirectedWeightGraphAdapter.containsEdge(customUndirectedWeightGraphAdapter.getEdge(two, three)));
        Assert.assertTrue(customUndirectedWeightGraphAdapter.containsEdge(customUndirectedWeightGraphAdapter.getEdge(one, four)));
        Assert.assertFalse(customUndirectedWeightGraphAdapter.containsEdge(customUndirectedWeightGraphAdapter.getEdge(four, two)));
        Assert.assertFalse(customUndirectedWeightGraphAdapter.containsVertex(new Integer(5)));
        Assert.assertTrue(customUndirectedWeightGraphAdapter.containsVertex(four));
    }
    @Test
    public void shouldCheckDegreeOfVertex() {

        CustomUndirectedWeightGraphAdapter customUndirectedWeightGraphAdapter = createEmptyGraph();

        Assert.assertEquals(0, customUndirectedWeightGraphAdapter.degreeOf(new Integer(1)));

        Integer one = new Integer(1);
        Integer two = new Integer(2);
        customUndirectedWeightGraphAdapter.addVertex(one);
        customUndirectedWeightGraphAdapter.addVertex(two);
        customUndirectedWeightGraphAdapter.addEdge(one, two);

        Assert.assertEquals(1, customUndirectedWeightGraphAdapter.degreeOf(one));
        Assert.assertEquals(1, customUndirectedWeightGraphAdapter.degreeOf(two));


        Integer three = new Integer(3);
        Integer four = new Integer(4);
        customUndirectedWeightGraphAdapter.addVertex(three);
        customUndirectedWeightGraphAdapter.addVertex(four);
        customUndirectedWeightGraphAdapter.addEdge(one, three);
        customUndirectedWeightGraphAdapter.addEdge(one, four);
        customUndirectedWeightGraphAdapter.addEdge(two, three);

        Assert.assertEquals(3, customUndirectedWeightGraphAdapter.degreeOf(one));
        Assert.assertEquals(2, customUndirectedWeightGraphAdapter.degreeOf(two));
        Assert.assertEquals(2, customUndirectedWeightGraphAdapter.degreeOf(three));
        Assert.assertEquals(1, customUndirectedWeightGraphAdapter.degreeOf(four));
    }

    @Test
    public void shouldRemoveEdgeOrVertex() {

        CustomUndirectedWeightGraphAdapter customUndirectedWeightGraphAdapter = createEmptyGraph();

        Assert.assertFalse(customUndirectedWeightGraphAdapter.removeEdge(customUndirectedWeightGraphAdapter.getEdge(new Integer(1), new Integer(2))));
        Assert.assertFalse(customUndirectedWeightGraphAdapter.removeVertex(new Integer(5)));

        Integer one = new Integer(1);
        Integer two = new Integer(2);
        customUndirectedWeightGraphAdapter.addVertex(one);
        customUndirectedWeightGraphAdapter.addVertex(two);
        customUndirectedWeightGraphAdapter.addEdge(one, two);

        Assert.assertTrue( customUndirectedWeightGraphAdapter.removeEdge(customUndirectedWeightGraphAdapter.getEdge(one, two)));
        Assert.assertTrue(customUndirectedWeightGraphAdapter.removeVertex(two));

        Integer three = new Integer(3);
        Integer four = new Integer(4);
        customUndirectedWeightGraphAdapter.addVertex(three);
        customUndirectedWeightGraphAdapter.addVertex(four);
        customUndirectedWeightGraphAdapter.addEdge(one, three);
        customUndirectedWeightGraphAdapter.addEdge(one, four);

        Assert.assertEquals(4, customUndirectedWeightGraphAdapter.edgeSet().size());
        Assert.assertEquals(3, customUndirectedWeightGraphAdapter.vertexSet().size());
        Assert.assertFalse(customUndirectedWeightGraphAdapter.removeEdge(customUndirectedWeightGraphAdapter.getEdge(one, two)));
        Assert.assertFalse(customUndirectedWeightGraphAdapter.removeVertex(two));

    }
    @Test
    public void shouldChangeWeight() {

        CustomUndirectedWeightGraphAdapter customUndirectedWeightGraphAdapter = createEmptyGraph();

        Integer one = new Integer(1);
        Integer two = new Integer(2);
        customUndirectedWeightGraphAdapter.addVertex(one);
        customUndirectedWeightGraphAdapter.addVertex(two);
        customUndirectedWeightGraphAdapter.addEdge(one, two);
        customUndirectedWeightGraphAdapter.setEdgeWeight(customUndirectedWeightGraphAdapter.getEdge(one, two), 2.0);

        Assert.assertEquals(2, customUndirectedWeightGraphAdapter.getEdgeWeight(customUndirectedWeightGraphAdapter.getEdge(one, two)), 0.01);
       
    }
}
