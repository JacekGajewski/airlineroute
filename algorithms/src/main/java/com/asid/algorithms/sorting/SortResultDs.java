package com.asid.algorithms.sorting;

import java.util.List;

/**
 * Do not modify this class if it is not necessary.
 */
public class SortResultDs<T> {
    private List<T> result;
    private long estimatedTime;
 
    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public long getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(long estimatedTime) {
        this.estimatedTime = estimatedTime;
    }
}
