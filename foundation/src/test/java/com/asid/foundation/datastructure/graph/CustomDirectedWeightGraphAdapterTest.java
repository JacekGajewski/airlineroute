package com.asid.foundation.datastructure.graph;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by tnt9 on 07.05.17.
 */
public class CustomDirectedWeightGraphAdapterTest {

    private CustomDirectedWeightGraphAdapter createEmptyGraph() {
        AirportEdgeFactory airportEdgeFactory = new AirportEdgeFactory();
        return new CustomDirectedWeightGraphAdapter(airportEdgeFactory, true);
    }
    @Test
    public void shouldAddEdgeAndVertex() {

        CustomDirectedWeightGraphAdapter customDirectedWeightGraphAdapter = createEmptyGraph();

        Assert.assertNull(customDirectedWeightGraphAdapter.getEdge(new Integer(1), new Integer(2)));
        Assert.assertEquals((0), customDirectedWeightGraphAdapter.edgeSet().size());
        Assert.assertTrue(customDirectedWeightGraphAdapter.vertexSet().isEmpty());
        Assert.assertFalse(customDirectedWeightGraphAdapter.containsEdge((new Integer(1))));
        Assert.assertFalse(customDirectedWeightGraphAdapter.containsEdge((new Integer(1)), new Integer(2)));
        Assert.assertFalse(customDirectedWeightGraphAdapter.containsVertex((new Integer(1))));


        Integer one = new Integer(1);
        Integer two = new Integer(2);
        customDirectedWeightGraphAdapter.addVertex(one);
        customDirectedWeightGraphAdapter.addVertex(two);
        customDirectedWeightGraphAdapter.addEdge(one, two);

        Assert.assertNull(customDirectedWeightGraphAdapter.getEdge(two, one));
        Assert.assertEquals((1), customDirectedWeightGraphAdapter.edgeSet().size()); //!!!!IS THIS RIGHT?????
        Assert.assertFalse(customDirectedWeightGraphAdapter.vertexSet().isEmpty());
        Assert.assertFalse(customDirectedWeightGraphAdapter.containsEdge((new Integer(1)), new Integer(2)));
        Assert.assertTrue(customDirectedWeightGraphAdapter.containsVertex(one));


        Integer three = new Integer(3);
        Integer four = new Integer(4);
        customDirectedWeightGraphAdapter.addVertex(three);
        customDirectedWeightGraphAdapter.addVertex(four);
        customDirectedWeightGraphAdapter.addEdge(one, three);
        customDirectedWeightGraphAdapter.addEdge(one, four);
        customDirectedWeightGraphAdapter.addEdge(two, three);

        Assert.assertEquals((4), customDirectedWeightGraphAdapter.edgeSet().size()); // SAME HERE!!!!!!!
        Assert.assertFalse(customDirectedWeightGraphAdapter.vertexSet().isEmpty());
        Assert.assertEquals((4), customDirectedWeightGraphAdapter.vertexSet().size());

    }
    @Test
    public void shouldCheckIfContains() {

        CustomDirectedWeightGraphAdapter customDirectedWeightGraphAdapter = createEmptyGraph();

        Assert.assertFalse(customDirectedWeightGraphAdapter.containsEdge(null));
        Assert.assertFalse(customDirectedWeightGraphAdapter.containsVertex(new Integer(69)));

        Integer one = new Integer(1);
        Integer two = new Integer(2);
        customDirectedWeightGraphAdapter.addVertex(one);
        customDirectedWeightGraphAdapter.addVertex(two);
        customDirectedWeightGraphAdapter.addEdge(one, two);

        Assert.assertTrue(customDirectedWeightGraphAdapter.containsEdge(customDirectedWeightGraphAdapter.getEdge(one, two)));
        Assert.assertFalse(customDirectedWeightGraphAdapter.containsEdge(customDirectedWeightGraphAdapter.getEdge(two, one)));
        Assert.assertFalse(customDirectedWeightGraphAdapter.containsVertex(new Integer(69)));
        Assert.assertTrue(customDirectedWeightGraphAdapter.containsVertex(one));
        Assert.assertTrue(customDirectedWeightGraphAdapter.containsVertex(two));


        Integer three = new Integer(3);
        Integer four = new Integer(4);
        customDirectedWeightGraphAdapter.addVertex(three);
        customDirectedWeightGraphAdapter.addVertex(four);
        customDirectedWeightGraphAdapter.addEdge(one, three);
        customDirectedWeightGraphAdapter.addEdge(one, four);
        customDirectedWeightGraphAdapter.addEdge(two, three);

        Assert.assertTrue(customDirectedWeightGraphAdapter.containsEdge(customDirectedWeightGraphAdapter.getEdge(two, three)));
        Assert.assertTrue(customDirectedWeightGraphAdapter.containsEdge(customDirectedWeightGraphAdapter.getEdge(one, four)));
        Assert.assertFalse(customDirectedWeightGraphAdapter.containsEdge(customDirectedWeightGraphAdapter.getEdge(four, two)));
        Assert.assertFalse(customDirectedWeightGraphAdapter.containsVertex(new Integer(5)));
        Assert.assertTrue(customDirectedWeightGraphAdapter.containsVertex(four));
    }
    @Test
    public void shouldCheckDegreeOfVertexAndEdges() {

        CustomDirectedWeightGraphAdapter customDirectedWeightGraphAdapter = createEmptyGraph();

        Assert.assertEquals(0, customDirectedWeightGraphAdapter.outDegreeOf(new Integer(1)));
        Assert.assertEquals(0, customDirectedWeightGraphAdapter.inDegreeOf(new Integer(1)));


        Integer one = new Integer(1);
        Integer two = new Integer(2);
        customDirectedWeightGraphAdapter.addVertex(one);
        customDirectedWeightGraphAdapter.addVertex(two);
        customDirectedWeightGraphAdapter.addEdge(one, two);

        Assert.assertEquals(0, customDirectedWeightGraphAdapter.inDegreeOf(one));
        Assert.assertEquals(1, customDirectedWeightGraphAdapter.outDegreeOf(one));
        Assert.assertEquals(1, customDirectedWeightGraphAdapter.inDegreeOf(two));
        Assert.assertEquals(0, customDirectedWeightGraphAdapter.outDegreeOf(two));
        Assert.assertEquals(0, customDirectedWeightGraphAdapter.incomingEdgesOf(one).size());
        Assert.assertEquals(1, customDirectedWeightGraphAdapter.outgoingEdgesOf(one).size());
        Assert.assertEquals(1, customDirectedWeightGraphAdapter.incomingEdgesOf(two).size());
        Assert.assertEquals(0, customDirectedWeightGraphAdapter.outgoingEdgesOf(two).size());


        Integer three = new Integer(3);
        Integer four = new Integer(4);
        customDirectedWeightGraphAdapter.addVertex(three);
        customDirectedWeightGraphAdapter.addVertex(four);
        customDirectedWeightGraphAdapter.addEdge(one, three);
        customDirectedWeightGraphAdapter.addEdge(one, four);
        customDirectedWeightGraphAdapter.addEdge(two, three);

        Assert.assertEquals(3, customDirectedWeightGraphAdapter.outDegreeOf(one));
        Assert.assertEquals(1, customDirectedWeightGraphAdapter.outDegreeOf(two));
        Assert.assertEquals(0, customDirectedWeightGraphAdapter.outDegreeOf(three));
        Assert.assertEquals(1, customDirectedWeightGraphAdapter.inDegreeOf(four));
        Assert.assertEquals(1, customDirectedWeightGraphAdapter.incomingEdgesOf(two).size());
        Assert.assertEquals(2, customDirectedWeightGraphAdapter.incomingEdgesOf(three).size());
        Assert.assertEquals(3, customDirectedWeightGraphAdapter.outgoingEdgesOf(one).size());
        Assert.assertEquals(0, customDirectedWeightGraphAdapter.outgoingEdgesOf(four).size());
    }

    @Test
    public void shouldRemoveEdgeOrVertex() {

        CustomDirectedWeightGraphAdapter customDirectedWeightGraphAdapter = createEmptyGraph();

        Assert.assertFalse(customDirectedWeightGraphAdapter.removeEdge(customDirectedWeightGraphAdapter.getEdge(new Integer(1), new Integer(2))));
        Assert.assertFalse(customDirectedWeightGraphAdapter.removeVertex(new Integer(5)));

        Integer one = new Integer(1);
        Integer two = new Integer(2);        customDirectedWeightGraphAdapter.addVertex(one);
        customDirectedWeightGraphAdapter.addVertex(two);
        customDirectedWeightGraphAdapter.addEdge(one, two);

        Assert.assertTrue( customDirectedWeightGraphAdapter.removeEdge(customDirectedWeightGraphAdapter.getEdge(one, two)));
        Assert.assertTrue(customDirectedWeightGraphAdapter.removeVertex(two));

        Integer three = new Integer(3);
        Integer four = new Integer(4);
        customDirectedWeightGraphAdapter.addVertex(three);
        customDirectedWeightGraphAdapter.addVertex(four);
        customDirectedWeightGraphAdapter.addEdge(one, three);
        customDirectedWeightGraphAdapter.addEdge(one, four);

        Assert.assertEquals(2, customDirectedWeightGraphAdapter.edgeSet().size());
        Assert.assertEquals(3, customDirectedWeightGraphAdapter.vertexSet().size());
        Assert.assertFalse(customDirectedWeightGraphAdapter.removeEdge(customDirectedWeightGraphAdapter.getEdge(one, two)));
        Assert.assertFalse(customDirectedWeightGraphAdapter.removeVertex(two));

        Assert.assertTrue(customDirectedWeightGraphAdapter.removeVertex(one));
        Assert.assertFalse(customDirectedWeightGraphAdapter.removeEdge(customDirectedWeightGraphAdapter.getEdge(one, three)));
    }
    @Test
    public void shouldChangeWeight() {

        CustomDirectedWeightGraphAdapter customDirectedWeightGraphAdapter = createEmptyGraph();

        Integer one = new Integer(1);
        Integer two = new Integer(2);
        customDirectedWeightGraphAdapter.addVertex(one);
        customDirectedWeightGraphAdapter.addVertex(two);
        customDirectedWeightGraphAdapter.addEdge(one, two);
        customDirectedWeightGraphAdapter.setEdgeWeight(customDirectedWeightGraphAdapter.getEdge(one, two), 2.0);

        Assert.assertEquals(2, customDirectedWeightGraphAdapter.getEdgeWeight(customDirectedWeightGraphAdapter.getEdge(one, two)), 0.01);
        Assert.assertEquals(1, customDirectedWeightGraphAdapter.getEdgeWeight(customDirectedWeightGraphAdapter.getEdge(two, one)), 0.01);


    }
}
