package com.asid.foundation.datastructure.list;

import java.util.*;
import java.util.function.Predicate;

/**
 * Filter iterator
 */
public class FilterIterator<T> implements Iterator<T> {

    List<T> list;
    Predicate<T> predicate;
    Iterator iterator;
    T t;

    public FilterIterator(List<T> list, Predicate<T> predicate) {
         this.list = list;
         this.predicate = predicate;
    }

    public void setIterator(List<T> l){
        this.iterator = l.iterator();
    }

    @Override
    public boolean hasNext() {
        setIterator(list);
        boolean foundMatch = false;
        while (iterator.hasNext() && !foundMatch){
            t = (T) iterator.next();
            foundMatch = predicate.test(t);
        }
        return foundMatch;
    }

    @Override
    public T next() {
        if(hasNext()){
            return t;
        }
        throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
