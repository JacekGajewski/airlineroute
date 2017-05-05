package com.asid.foundation.datastructure.graph;

import com.asid.foundation.datastructure.list.CustomArrayList;
import org.jgrapht.EdgeFactory;
import org.jgrapht.Graph;

import java.util.*;

/**
 * Created by tnt9 on 04.05.17.
 */
public class CustomUndirectedWeightGraphAdapter<K, V> extends AbstractUndirectedWeightGraphAdapter {


    int e; // number of edges
    AirportEdgeFactory airportEdgeFactory;
    DefaultEdge defaultEdge;


    int v; // number of vertices
    List<Object> obj = new LinkedList<>();
    List<LinkedList> adj = new ArrayList<>();


    public CustomUndirectedWeightGraphAdapter(EdgeFactory edgeFactory, boolean isWeight, int n) {
        super(edgeFactory, isWeight);
        v = n;

    }

    @Override
    public int degreeOf(Object o) {
        int degree = 0;
        for(List list : adj){
            if (list.get(0).equals(o)){
                for(Object object : list) degree++;
            }
        }
        return degree;
    }
    @Override
    public Object getEdge(Object o, Object v1) {
        DefaultEdge defaultEdge = new DefaultEdge();
        defaultEdge.setSource(o);
        defaultEdge.setTarget(v1);
        for(LinkedList list : adj){
            if (list.get(0).equals(o)){
                for(Object object : list){
                    if(object.equals(defaultEdge)) return object;
                }
            }
        }
        return null;
    }

    @Override
    public EdgeFactory getEdgeFactory() {
        return edgeFactory;
    }

    @Override
    public Object addEdge(Object o, Object v1) {

        if(containsEdge(o, v1)) return false;

        DefaultEdge defaultEdge1 = new DefaultEdge();
        defaultEdge1.setSource(o);
        defaultEdge1.setTarget(v1);
        DefaultEdge defaultEdge2 = new DefaultEdge();
        defaultEdge1.setSource(v1);
        defaultEdge1.setTarget(o);

        for(List list : adj){
            if (list.get(0).equals(o)){
                list.add(defaultEdge1);
            }
            if (list.get(0).equals(v1)){
                list.add(defaultEdge2);
            }
        }

        return defaultEdge1;
    }

    @Override
    public boolean addVertex(Object o) {
        if (containsVertex(o)) return false;
        LinkedList list = new LinkedList();
        list.add(o);
        adj.add(list);
        return true;
    }
    public boolean equals(DefaultEdge a, DefaultEdge b){

        if (a.getSource() == b.getSource() &&
                a.getTarget() == b.getTarget())
            return true;

        return false;
    }

    @Override
    public boolean containsEdge(Object o, Object v1) {
        DefaultEdge defaultEdge1 = new DefaultEdge();
        defaultEdge1.setSource(o);
        defaultEdge1.setTarget(v1);
        for(List list : adj){
            if(list.get(0).equals(o)){
                for(int i = 1; i < list.size(); i++){
                    if(equals((DefaultEdge) list.get(i), defaultEdge1)) return true;
                }
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean containsEdge(Object o) {

        for(Object object : edgeSet()){
            if (equals((DefaultEdge) object, (DefaultEdge) o)) return true;
        }

        return false;
    }

    @Override
    public boolean containsVertex(Object o) {
        for(List list : adj) {
            if (list.get(0).equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Set edgeSet() {

        Set set = new HashSet();
        for(List list : adj) {
            for (int i = 1; i < list.size(); i++){
                set.add(list.get(i));
            }
        }
        return set;
    }

    @Override
    public Set edgesOf(Object o) {
        return null;
    }

    @Override
    public Object removeEdge(Object o, Object v1) {
        return null;
    }

    @Override
    public boolean removeEdge(Object o) {
        return false;
    }

    @Override
    public boolean removeVertex(Object o) {

        for(List list : adj) {
            if(list.get(0).equals(o)){
                list.clear();
            }
            for(Object object : list){
                if (object.equals(o)) list.remove(object);
            }
        }
        return false;
    }

    @Override
    public Set vertexSet() {
        Set set = new HashSet();
        for(List list : adj) {
            set.add(list.get(0));
        }
        return set;
    }

    @Override
    public double getEdgeWeight(Object o) {
        return 0;
    }

    @Override
    public void setEdgeWeight(Object o, double v) {

    }
}
