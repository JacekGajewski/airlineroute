package com.asid.algorithms.graph;

import com.asid.foundation.datastructure.graph.AbstractUndirectedWeightGraphAdapter;

/**
 * Do not modify this class if it is not necessary.
 * Please see http://jgrapht.org/javadoc/org/jgrapht/UndirectedGraph.html
 */
public interface AbstractMinimumSpanningTreeService<V,E> {

    public MSTResultDs<E> searchMinimumSpanningTreeUsingKruskalAlg(AbstractUndirectedWeightGraphAdapter<V, E> graph);

    public MSTResultDs<E> searchMinimumSpanningTreeUsingPrimAlg(AbstractUndirectedWeightGraphAdapter<V, E> graph);
}
