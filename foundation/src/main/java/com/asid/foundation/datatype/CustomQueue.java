package com.asid.foundation.datatype;

import java.util.List;

/**
 * FIFO queue
 */
public class CustomQueue<T> extends AbstractCustomQueueAdapter<T> {
    List<T> storage = null;

    /* (TODO Lab No. 2) Please introduce a sensible implementation */
    public CustomQueue(List<T> storage) {
        this.storage = storage;
    }
    
    @Override
    public int size() {
          /* (TODO Lab No. 2) Please introduce a sensible implementation */
        return 0;
    }

    @Override
    public boolean isEmpty() {
          /* (TODO Lab No. 2) Please introduce a sensible implementation */
        return false;
    }

    @Override
    public boolean add(T t) {
          /* (TODO Lab No. 2) Please introduce a sensible implementation */
        return false;
    }

    @Override
    public T poll() {
          /* (TODO Lab No. 2) Please introduce a sensible implementation */
        return null;
    }

    @Override
    public T peek() {
          /* (TODO Lab No. 2) Please introduce a sensible implementation */
        return null;
    }
}
