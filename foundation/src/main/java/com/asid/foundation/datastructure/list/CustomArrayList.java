package com.asid.foundation.datastructure.list;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * List based on the table
 *
 * @param <T>
 */
public class CustomArrayList<T> extends AbstractCustomListAdapter<T> {

    ArrayList arrayList = new ArrayList();

    public CustomArrayList() {
    }

    public CustomArrayList(int initialCapacity) {

        ArrayList arrayList = new ArrayList(initialCapacity);
    }

    @Override
    public int size() {

        if(arrayList.size()>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }

        else{

            return arrayList.size();
        }
    }

    @Override
    public boolean isEmpty() {

        return arrayList.isEmpty();
        }

    public boolean contains(Object o) {

        return arrayList.contains(o);

    }

    @Override
    public Iterator<T> iterator() {

        return (Iterator<T>) new CustomArrayListIterator<>().iter;
    }

    @Override
    public boolean add(T t) {

        arrayList.add(t);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if(arrayList.contains(o)) {
            arrayList.remove(o);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void clear() {

        arrayList.clear();
    }

    @Override
    public T get(int index) {

        return (T)arrayList.get(index);
    }

    @Override
    public T set(int index, T element) {
        T prev = (T)arrayList.get(index);
        arrayList.set(index, element);
        return prev;
    }

    @Override
    public void add(int index, T element) {

        arrayList.add(index, element);
    }

    @Override
    public T remove(int index) {
        T prev = (T)arrayList.get(index);
        arrayList.remove(index);
        return prev;
    }

     public int indexOf(Object o) {
        if(arrayList.contains(o)) {
            return arrayList.indexOf(o);
        }
        else{
            return -1;
        }
    }

    /**
     * Iterator for CustomArrayList
     */
    private class CustomArrayListIterator<E> implements Iterator<E> {

        Iterator<E> iter = arrayList.iterator();

        @Override
        public boolean hasNext() {
            return iter.hasNext();
        }

        @Override
        public E next() {

            return iter.next();
        }

        @Override
        public void remove() {
             iter.remove();
        }
    }
}
