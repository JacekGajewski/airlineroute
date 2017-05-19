package com.asid.algorithms.graph;

import com.asid.foundation.datastructure.graph.AbstractUndirectedWeightGraphAdapter;
import com.asid.foundation.datastructure.graph.DefaultEdge;
import com.asid.foundation.datatype.CustomPriorityQueue;
import com.asid.foundation.datatype.CustomStack;
import org.jgrapht.alg.util.UnionFind;

import java.util.*;

/**
 * Created by tnt9 on 15.05.17.
 */
public class MinimumSpanningTreeService<V> implements AbstractMinimumSpanningTreeService {

    @Override
    public MSTResultDs searchMinimumSpanningTreeUsingKruskalAlg(AbstractUndirectedWeightGraphAdapter graph) {

        mst = new ArrayList<>();
        MSTResultDs mstResultDs = new MSTResultDs();

        queue = new CustomPriorityQueue<>(10, new Comparator<DefaultEdge>() {
            @Override
            public int compare(DefaultEdge o1, DefaultEdge o2) {
                if (o1.getWeight() > o2.getWeight()) return 1;
                if (o1.getWeight() < o2.getWeight()) return -1;
                else return 0;
            }
        });

        Set<DefaultEdge> set = graph.edgeSet();

        for (DefaultEdge defaultEdge : set){
            queue.add(defaultEdge);
        }

        UnionFind unionFind = new UnionFind(graph.vertexSet());

        while (!queue.isEmpty() && mst.size() < graph.vertexSet().size() - 1) {

            DefaultEdge temp = queue.poll();
            Object one = temp.getSource();
            Object two = temp.getTarget();
            if (unionFind.find(one) != unionFind.find(two)){
                unionFind.union(one, two);
                mst.add(temp);
                weight += temp.getWeight();
            }
        }

        mstResultDs.setEgdes(mst);
        mstResultDs.setTotalWeight(weight);

        return mstResultDs;
    }
    private double weight;
    private List<DefaultEdge> mst;
    private boolean[] check;
    private CustomPriorityQueue<DefaultEdge> queue;

    @Override
    public MSTResultDs searchMinimumSpanningTreeUsingPrimAlg(AbstractUndirectedWeightGraphAdapter graph) {

        mst = new ArrayList<>();
        queue = new CustomPriorityQueue<>(10, new Comparator<DefaultEdge>() {
            @Override
            public int compare(DefaultEdge o1, DefaultEdge o2) {
                if (o1.getWeight() > o2.getWeight()) return 1;
                if (o1.getWeight() < o2.getWeight()) return -1;
                else return 0;
            }
        });
        check = new boolean[graph.vertexSet().size()];
        for (int v = 0; v <graph.vertexSet().size(); v++)
            if (!check[v]) prim(graph, v);

        MSTResultDs mstResultDs = new MSTResultDs();
        mstResultDs.setEgdes(mst);
        mstResultDs.setTotalWeight(weight);

        return mstResultDs;
    }
    private void prim(AbstractUndirectedWeightGraphAdapter G, int s) {
        scan(G, s);
        while (!queue.isEmpty()) {
            DefaultEdge e = queue.poll();
            int v = (int) e.getSource();
            int w = (int) e.getTarget();
            if (check[v] && check[w]) continue;
            mst.add(e);
            weight += e.getWeight();
            if (!check[v]) scan(G, v);
            if (!check[w]) scan(G, w);
        }
    }
    private void scan(AbstractUndirectedWeightGraphAdapter G, int v) {
        check[v] = true;
        Set<DefaultEdge> set  = G.edgesOfIndex(v);
        for (DefaultEdge e : set)
            if (!check[(int) e.getTarget()]) queue.add(e);
    }
}