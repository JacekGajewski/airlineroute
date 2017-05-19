package com.asid.foundation.datatype;

import com.asid.foundation.messages.StandardMessages;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Stack, LIFO queue
 */
public class CustomStack<T> extends AbstractCustomStackAdapter<T> {
    List<T> storage = null;

    public CustomStack(List<T> storage) {
        this.storage = storage;
    }

    @Override
    public void push(T t) {
        storage.add(t);
    }

    @Override
    public T pop() {
        if (!isEmpty())  throw new NoSuchElementException();
        T t = storage.get(size()-1);
        storage.remove(size()-1);
        return t;
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public boolean isEmpty() {
        return storage.isEmpty();
    }
}
