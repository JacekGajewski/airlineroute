package com.asid.algorithms.graph;

import java.util.List;
/**
 * Do not modify this class if it is not necessary.
 * Please see http://jgrapht.org/javadoc/org/jgrapht/UndirectedGraph.html
 */
public class MSTResultDs<E> {

    /* List of tree edges */
    private List<E> egdes;
    private double totalWeight;

    public List<E> getEgdes() {
        return egdes;
    }

    public void setEgdes(List<E> egdes) {
        this.egdes = egdes;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }
}
