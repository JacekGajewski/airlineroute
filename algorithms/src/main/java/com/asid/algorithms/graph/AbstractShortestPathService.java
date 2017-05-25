package com.asid.algorithms.graph;

import com.asid.foundation.datastructure.graph.AbstractUndirectedWeightGraphAdapter;

/**
 * Do not modify this class if it is not necessary.
 * Please see http://jgrapht.org/javadoc/org/jgrapht/UndirectedGraph.html
 */
public interface AbstractShortestPathService<V,E>  {

    public MSTResultDs<E> searchShortestPathUsingDijkstraAlg(AbstractUndirectedWeightGraphAdapter<V, E> graph, V from, V to);

    public MSTResultDs<E> searchShortestPathUsingBellmanFordAlg(AbstractUndirectedWeightGraphAdapter<V, E> graph, V from, V to);
}
