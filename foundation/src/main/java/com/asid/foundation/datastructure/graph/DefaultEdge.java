package com.asid.foundation.datastructure.graph;


public class DefaultEdge<V> {
    private V source;
    private V target;
    private long weight;

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public V getSource() {
        return source;
    }

    public void setSource(V source) {
        this.source = source;
    }

    public V getTarget() {
        return target;
    }

    public void setTarget(V target) {
        this.target = target;
    }
}
