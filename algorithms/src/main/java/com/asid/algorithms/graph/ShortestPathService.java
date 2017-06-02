package com.asid.algorithms.graph;

import com.asid.algorithms.entity.Airport;
import com.asid.foundation.datastructure.graph.AbstractDirectedWeightGraphAdapter;
import com.asid.foundation.datastructure.graph.AbstractUndirectedWeightGraphAdapter;
import com.asid.foundation.datastructure.graph.DefaultEdge;

import java.util.*;

/**
 * Created by tnt9 on 25.05.17.
 */
public class ShortestPathService implements AbstractShortestPathService {

    double[] distTo;          // distTo[v] = distance  of shortest s->v path
    DefaultEdge[] edgeTo;    // edgeTo[v] = last edge on shortest s->v path
    IndexMinPQ<Double> pq;

    @Override
    public MSTResultDs searchShortestPathUsingDijkstraAlg(AbstractUndirectedWeightGraphAdapter graph, Object from, Object to) {

        List<Object> temp = new ArrayList<>();

        MSTResultDs mstResultDs = new MSTResultDs();
        List<DefaultEdge> list = new ArrayList<>();
        double totalWeight = 0;

        for (Object object : graph.vertexSet()){
            temp.add(object);
        }
        ObjectToIndex objectToIndex = new ObjectToIndex(temp);
        int start =  objectToIndex.getIndexOfObject(from);
        int end = objectToIndex.getIndexOfObject(to);

        distTo = new double[graph.vertexSet().size()];
        edgeTo = new DefaultEdge[graph.vertexSet().size()];

        for (int i = 0; i < graph.vertexSet().size(); i++)
            distTo[i] = Double.POSITIVE_INFINITY;
        distTo[start] = 0.0;

        // relax vertices in order of distance from s
        pq = new IndexMinPQ<>(graph.vertexSet().size());

        pq.insert(start, distTo(start));
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            Set<DefaultEdge> set = graph.edgesOf(objectToIndex.getObjectofIndex(v));
            for (DefaultEdge e : set)
                relax(e, objectToIndex);
        }

        //Stack<DefaultEdge> path = new Stack<>();
        for (DefaultEdge e = edgeTo[end]; e != null; e = edgeTo[objectToIndex.getIndexOfObject(e.getSource())]) {
            //path.push(e);
            totalWeight += e.getWeight();
            list.add(e);
        }
        mstResultDs.setEgdes(list);
        mstResultDs.setTotalWeight(totalWeight);
        return mstResultDs;
    }
    // relax edge e and update pq if changed
    private void relax(DefaultEdge e, ObjectToIndex o) {
        int v = o.getIndexOfObject(e.getSource());//(int) e.getSource();
        int w = o.getIndexOfObject(e.getTarget());//(int)  e.getTarget();
        if (distTo[w] > distTo[v] + e.getWeight()) {
            distTo[w] = distTo[v] + e.getWeight();
            edgeTo[w] = e;
            if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
            else                pq.insert(w, distTo[w]);
        }
    }
    private double distTo(int v) {
        return distTo[v];
    }

    @Override
    public MSTResultDs searchShortestPathUsingBellmanFordAlg(AbstractUndirectedWeightGraphAdapter graph, Object from, Object to) {
        return null;
    }

    public MSTResultDs searchShortestPathUsingDijkstraAlg(AbstractDirectedWeightGraphAdapter graph, Object from, Object to) {

        List<Object> temp = new ArrayList<>();

        MSTResultDs mstResultDs = new MSTResultDs();
        List<DefaultEdge> list = new ArrayList<>();
        double totalWeight = 0;

        for (Object object : graph.vertexSet()){
            temp.add(object);
        }
        ObjectToIndex objectToIndex = new ObjectToIndex(temp);
        int start =  objectToIndex.getIndexOfObject(from);
        int end = objectToIndex.getIndexOfObject(to);

        distTo = new double[graph.vertexSet().size()];
        edgeTo = new DefaultEdge[graph.vertexSet().size()];

        for (int i = 0; i < graph.vertexSet().size(); i++)
            distTo[i] = Double.POSITIVE_INFINITY;
        distTo[start] = 0.0;

        // relax vertices in order of distance from s
        pq = new IndexMinPQ<>(graph.vertexSet().size());

        pq.insert(start, distTo(start));
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            Set<DefaultEdge> set = graph.edgesOf(objectToIndex.getObjectofIndex(v));
            for (DefaultEdge e : set)
                relax(e, objectToIndex);
        }

        //Stack<DefaultEdge> path = new Stack<>();
        for (DefaultEdge e = edgeTo[end]; e != null; e = edgeTo[objectToIndex.getIndexOfObject(e.getSource())]) {
            //path.push(e);
            totalWeight += e.getWeight();
            list.add(e);
        }
        mstResultDs.setEgdes(list);
        mstResultDs.setTotalWeight(totalWeight);
        return mstResultDs;
    }

    private class ObjectToIndex{

         List<Object> x;

        public ObjectToIndex(List x) {
            this.x = x;
        }
        public int getIndexOfObject(Object object){
            int index = 0;
            for (Object o : x){
                if (o instanceof Airport) {
                    if (((Airport) o).getIataCode().equals(object)) return index;
                    index++;
                    continue;
                }
                if (o.equals(object)) return index;
                else index++;
            }
            return index;
        }
        public Object getObjectofIndex(int index){
            return x.get(index);
        }
    }
}