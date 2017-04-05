package com.asid.foundation.datatype;

import com.asid.foundation.datastructure.list.CustomLinkedList;

import java.util.LinkedList;
import java.util.List;

/**
 * FIFO queue
 */
public class CustomQueue<T> extends AbstractCustomQueueAdapter<T> {
    List<T> storage = null;

    public CustomQueue(List<T> storage) {
        this.storage = storage;
    }
    
    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean add(T t) {
          storage.add(t);
        return true;
    }

    @Override
    public T poll() {
        if(isEmpty()){
            return null;
        }else{
        T t = storage.get(0);
        storage.remove(0);
        return t;
        }
    }

    @Override
    public T peek() {
        if(isEmpty()){
            return null;
        }else{
            return storage.get(0);
        }

    }
}
