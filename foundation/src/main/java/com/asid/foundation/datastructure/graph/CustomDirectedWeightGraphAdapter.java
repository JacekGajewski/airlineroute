package com.asid.foundation.datastructure.graph;

import org.jgrapht.EdgeFactory;

import java.util.*;

/**
 * Created by tnt9 on 06.05.17.
 */
public class CustomDirectedWeightGraphAdapter<K, V> extends AbstractDirectedWeightGraphAdapter {

    List<LinkedList> adj = new ArrayList<>();

    public CustomDirectedWeightGraphAdapter(EdgeFactory edgeFactory, boolean isWeight) {
        super(edgeFactory, isWeight);
    }

    @Override
    public Object getEdge(Object o, Object v1) {
        if (!containsEdge(o, v1)) return null;

        DefaultEdge defaultEdge = new DefaultEdge();
        defaultEdge.setSource(o);
        defaultEdge.setTarget(v1);

        for(LinkedList list : adj){
            if (list.get(0).equals(o)){
                for(Object object : list){
                    if (!(object instanceof Integer)) {
                        if (equals((DefaultEdge) object, defaultEdge)) return object;
                    }
                }
            }
        }
        return null;
    }

    public boolean equals(DefaultEdge a, DefaultEdge b){

        if (a.getSource() == b.getSource() &&
                a.getTarget() == b.getTarget())
            return true;

        return false;
    }

    @Override
    public EdgeFactory getEdgeFactory() {
        return edgeFactory;
    }

    @Override
    public Object addEdge(Object o, Object v1) {
        if(containsEdge(o, v1)) return null;

        DefaultEdge defaultEdge = new DefaultEdge();
        defaultEdge.setSource(o);
        defaultEdge.setTarget(v1);

        for(List list : adj){
            if (list.get(0).equals(o)){
                list.add(defaultEdge);
            }
        }
        return defaultEdge;
    }
    public Object addEdgeAndWeight(Object o, Object v1, long v) {
        if(containsEdge(o, v1)) return null;

        DefaultEdge defaultEdge = new DefaultEdge();
        defaultEdge.setSource(o);
        defaultEdge.setTarget(v1);
        defaultEdge.setWeight(v);

        for(List list : adj){
            if (list.get(0).equals(o)){
                list.add(defaultEdge);
            }
        }
        return defaultEdge;
    }

    @Override
    public boolean addVertex(Object o) {
        if (containsVertex(o)) return false;
        LinkedList list = new LinkedList();
        list.add(o);
        adj.add(list);
        return true;
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
        if (o == null) return false;
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
        Set set = new HashSet();
        for(List list : adj) {
            if (o.equals(list.get(0))) {
                for (int i = 1; i < list.size(); i++) {
                    set.add(list.get(i));
                }
                return set;
            }
        }
        return set;
    }

    @Override
    public Object removeEdge(Object o, Object v1) {

        if(!containsEdge(o, v1)) return null;

        DefaultEdge defaultEdge = new DefaultEdge();
        defaultEdge.setSource(o);
        defaultEdge.setTarget(v1);

        for (List list : adj){
            if (list.get(0).equals(o)){
                for (int i = 1; i < list.size(); i++){
                    if (equals((DefaultEdge) list.get(i), defaultEdge)) list.remove(i);
                }
            }
        }
        return defaultEdge;
    }

    @Override
    public boolean removeEdge(Object o) {
        if (!(containsEdge(o))) return false;

        for (List list : adj){
            if (list.get(0).equals(getEdgeSource(o))){
                for (int i = 1; i < list.size(); i++){
                    if (equals((DefaultEdge) list.get(i), (DefaultEdge) o)) list.remove(i);
                }
            }
        }
        return true;
    }

    @Override
    public boolean removeVertex(Object o) {
        if (!(containsVertex(o))) return false;

        List temp = null;

        for(List list : adj) {
            if(list.get(0).equals(o)){
                temp = list;
            }
            for (int i = 1; i < list.size(); i++){
                if (getEdgeTarget(list.get(i)).equals(o)) list.remove(i);
            }
        }
        adj.remove(temp);
        return true;
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
    public Object getEdgeSource(Object o) {
        DefaultEdge defaultEdge = (DefaultEdge) o;
        return defaultEdge.getSource();
    }

    @Override
    public Object getEdgeTarget(Object o) {
        DefaultEdge defaultEdge = (DefaultEdge) o;
        return defaultEdge.getTarget();
    }

    @Override
    public double getEdgeWeight(Object o) {
        if (!(containsEdge(o)) || !isWeight) return DEFAULT_WEIGHT;
        DefaultEdge defaultEdge = (DefaultEdge) o;
        return defaultEdge.getWeight();
    }

    @Override
    public void setEdgeWeight(Object o, double v) {
        if (!(containsEdge(o)) || !isWeight) return;
        for (List list : adj){
            for (int i = 1; i < list.size(); i++){
                if (equals((DefaultEdge) list.get(i), (DefaultEdge) o)) setWght((DefaultEdge) o, v);
            }
        }
    }

    private void setWght(DefaultEdge defaultEdge, double v){
        defaultEdge.setWeight((long) v);
    }

    @Override
    public int outDegreeOf(Object o) {
        int degree = 0;
        for(List list : adj){
            if (list.get(0).equals(o)){
                for(Object object : list) degree++;
                degree--; // minus because of counting vertex earlier
            }
        }
        return degree;
    }

    @Override
    public Set incomingEdgesOf(Object o) {
        if (!containsVertex(o)) return null;
        Set set = new HashSet();
        for (List list : adj){
            for (int i = 1; i < list.size(); i++){
                if (getEdgeTarget(list.get(i)).equals(o)) set.add(list.get(i));
            }
        }
        return set;
    }

    @Override
    public int inDegreeOf(Object o) {
        int degree = 0;
        for(List list : adj){
            for (int i = 1; i < list.size(); i++){
                if (getEdgeTarget(list.get(i)).equals(o)) degree++;
            }
        }
        return degree;
    }

    @Override
    public Set outgoingEdgesOf(Object o) {
        if (!containsVertex(o)) return null;
        Set set = new HashSet();
        for (List list : adj){
            if (list.get(0).equals(o)){
                for (int i = 1; i < list.size(); i++){
                    set.add(list.get(i));
                }
            }
        }
        return set;
    }
}
