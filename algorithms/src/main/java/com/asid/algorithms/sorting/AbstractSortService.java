package com.asid.algorithms.sorting;


import java.util.Comparator;
import java.util.List;

public abstract class AbstractSortService {

    /**
     * Method compares two objects using a comparator
     *
     * @param o1
     * @param o2
     * @param comparator
     * @param <T>
     * @return
     */
    protected static <T> boolean less(T o1, T o2, Comparator<? super T> comparator) {
        /* (TODO Lab No. 3) Please introduce a sensible implementation */
        return false;
    }

    /**
     * Method swaps two objects in the list, using their position.
     *
     * @param list
     * @param o1Pos
     * @param o2Pos
     */
    protected static <T> void exch(List<T> list, int o1Pos, int o2Pos) {
        /* (TODO Lab No. 3) Please introduce a sensible implementation */
    }

    /**
     * Method swaps two objects in the list, using their references.
     *
     * @param list
     * @param o1
     * @param o2
     */
    protected static <T> void exch(List<T> list, Object o1, Object o2) {
        /* (TODO Lab No. 3) Please introduce a sensible implementation */
    }
}
