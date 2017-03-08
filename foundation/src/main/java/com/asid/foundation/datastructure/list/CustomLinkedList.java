package com.asid.foundation.datastructure.list;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * List based on recursively related objects
 *
 * @param <T>
 */
public class CustomLinkedList<T> extends AbstractCustomListAdapter<T> {

    LinkedList<T> linkedList = new LinkedList<>();

    @Override
    public int size() {

        if(linkedList.size()>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }

        else{

            return linkedList.size();
        }
    }

    @Override
    public boolean isEmpty() {

        return linkedList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {

        return linkedList.contains(o);
    }

    @Override
    public Iterator<T> iterator() {

        return new CustomLinkedListIterator<>().it;
    }

    @Override
    public boolean add(T t) {
        linkedList.add(t);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if(linkedList.contains(o)){
            linkedList.remove(o);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void clear() {
        linkedList.clear();
    }

    @Override
    public T get(int index) {

        return linkedList.get(index);
    }

    @Override
    public T set(int index, T element) {
        T prev = (T)linkedList.get(index);
        linkedList.set(index, element);
        return prev;
    }

    @Override
    public void add(int index, T element) {

        linkedList.add(index, element);
    }

    @Override
    public T remove(int index) {
        T prev = (T)linkedList.get(index);
        linkedList.remove(index);
        return prev;
    }

    @Override
    public int indexOf(Object o) {
        if(linkedList.contains(o)){
            return linkedList.indexOf(o);
        }
        else{
            return -1;
        }
    }

    /**
     * Iterator for CustomLinkedList
     */
    private class CustomLinkedListIterator<E> implements Iterator<E> {

        Iterator it = linkedList.iterator();

        @Override
        public boolean hasNext() {

            return it.hasNext();
        }

        @Override
        public E next() {

            return (E)it.next();
        }

        @Override
        public void remove() {
              it.remove();
        }
    }
}
