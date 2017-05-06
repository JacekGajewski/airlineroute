package com.asid.foundation.datastructure.graph;

import com.asid.foundation.datastructure.list.CustomArrayList;
import org.jgrapht.EdgeFactory;
import org.jgrapht.Graph;

import java.util.*;

/**
 * Created by tnt9 on 04.05.17.
 */
public class CustomUndirectedWeightGraphAdapter<K, V> extends AbstractUndirectedWeightGraphAdapter {

    List<Object> obj = new LinkedList<>();
    List<LinkedList> adj = new ArrayList<>();


    public CustomUndirectedWeightGraphAdapter(EdgeFactory edgeFactory, boolean isWeight) {
        super(edgeFactory, isWeight);

    }

    @Override
    public int degreeOf(Object o) {
        int degree = 0;
        //if (!containsVertex(o)) throw
        for(List list : adj){
            if (list.get(0).equals(o)){
                for(Object object : list) degree++;
                degree--; // minus because of counting vertex earlier
            }
        }
        return degree;
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
        defaultEdge2.setSource(v1);
        defaultEdge2.setTarget(o);

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
        if (a.getSource() == b.getTarget() &&
                a.getTarget() == b.getSource())
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
        if (o == null) return false;
        for(Object object : edgeSet()){
            if (!(object instanceof  Integer)) {
                if (equals((DefaultEdge) object, (DefaultEdge) o)) return true;
            }
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

        DefaultEdge defaultEdge1 = new DefaultEdge();
        defaultEdge1.setSource(o);
        defaultEdge1.setTarget(v1);
        DefaultEdge defaultEdge2 = new DefaultEdge();
        defaultEdge2.setSource(v1);
        defaultEdge2.setTarget(o);

        for (List list : adj){
            if (list.get(0).equals(o) || list.get(0).equals(v1)){
                for (int i = 1; i < list.size(); i++){
                    if (equals((DefaultEdge) list.get(i), defaultEdge1)) list.remove(i);
                }
            }
        }
        return defaultEdge1;
    }

    private Object getSrc(DefaultEdge defaultEdge){
        return defaultEdge.getSource();
    }
    private Object getTrg(DefaultEdge defaultEdge){
        return defaultEdge.getTarget();
    }

    @Override
    public boolean removeEdge(Object o) {
        if (!(containsEdge(o))) return false;

        for (List list : adj){
            if (list.get(0).equals(getSrc((DefaultEdge) o)) || list.get(0).equals(getTrg((DefaultEdge) o))){
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
                if (getTrg((DefaultEdge) list.get(i)).equals(o)) list.remove(i);
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
    public double getEdgeWeight(Object o) {
        if (!(containsEdge(o))) return 1.0;
        //if (!isWeight) return 1.0;
        DefaultEdge defaultEdge = (DefaultEdge) o;
        return defaultEdge.getWeight();
    }

    @Override
    public void setEdgeWeight(Object o, double v) { // Should I change isWeight to true????
        for (List list : adj){
            for (int i = 1; i < list.size(); i++){
                if (equals((DefaultEdge) list.get(i), (DefaultEdge) o)) setWght((DefaultEdge) o, v);
            }
        }

    }
    private void setWght(DefaultEdge defaultEdge, double v){
        defaultEdge.setWeight((long) v);
    }
}
