package com.asid.algorithms.graph;

import com.asid.foundation.datastructure.graph.AbstractUndirectedWeightGraphAdapter;
import com.asid.foundation.datastructure.graph.DefaultEdge;
import com.asid.foundation.datatype.CustomPriorityQueue;
import com.asid.foundation.datatype.CustomStack;

import java.util.*;

/**
 * Created by tnt9 on 15.05.17.
 */
public class MinimumSpanningTreeService implements AbstractMinimumSpanningTreeService {

    @Override
    public MSTResultDs searchMinimumSpanningTreeUsingKruskalAlg(AbstractUndirectedWeightGraphAdapter graph) {

        MSTResultDs mstResultDs = new MSTResultDs();
        List<DefaultEdge> result = new ArrayList<>();
        Set<DefaultEdge> set = graph.edgeSet();
        CustomStack<DefaultEdge> customStack = new CustomStack(new LinkedList());
        DefaultEdge temp = null;
        double weight;

        int i = set.size();
        long j = 0;

        Set<Object> joint = new HashSet<>();

        for (Object object : graph.vertexSet()){
            joint.add(object);
        }

        while (i != 0){
            for (DefaultEdge defaultEdge : set) {
                if (defaultEdge.getWeight() > j){
                    j = defaultEdge.getWeight();
                    temp = defaultEdge;
                }
            }
            set.remove(temp);
            i--;
            if (temp.getTarget() != temp.getSource()){
                customStack.push(temp);
            }
            j = 0;
        }


        while (!customStack.isEmpty()){
            temp = customStack.pop();
            Object source = temp.getSource();
            Object target = temp.getTarget();
        }
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