package com.asid.algorithms.graph;

import com.asid.foundation.datastructure.graph.AbstractUndirectedWeightGraphAdapter;
import com.asid.foundation.datatype.CustomPriorityQueue;
import com.sun.javafx.geom.Edge;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tnt9 on 15.05.17.
 */
public class MinimumSpanningTreeService implements AbstractMinimumSpanningTreeService {

    @Override
    public MSTResultDs searchMinimumSpanningTreeUsingKruskalAlg(AbstractUndirectedWeightGraphAdapter graph) {

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 > o2){
                    return 1;
                }else if(o1 < o2){
                    return -1;
                }else return 0;
            }
        };
        CustomPriorityQueue customPriorityQueue = new CustomPriorityQueue(graph.edgeSet().size(), comparator);













        return null;
    }

    @Override
    public MSTResultDs searchMinimumSpanningTreeUsingPrimAlg(AbstractUndirectedWeightGraphAdapter graph) {
        return null;
    }
}
