package com.asid.foundation.datatype;

import java.util.List;

/**
 * Stack, LIFO queue
 */
public class CustomStack<T> extends AbstractCustomStackAdapter<T> {
    List<T> storage = null;

    /* (TODO Lab No. 2) Please introduce a sensible implementation */
    public CustomStack(List<T> storage) {
        this.storage = storage;
    }

    @Override
    public void push(T t) {
        /* (TODO Lab No. 2) Please introduce a sensible implementation */
    }

    @Override
    public T pop() {
        /* (TODO Lab No. 2) Please introduce a sensible implementation */
        return null;
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
}
