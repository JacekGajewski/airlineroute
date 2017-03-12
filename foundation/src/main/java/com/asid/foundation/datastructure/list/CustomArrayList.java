package com.asid.foundation.datastructure.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


/**
 * List based on the table
 *
 * @param <T>
 */
public class CustomArrayList<T> extends AbstractCustomListAdapter<T> {

    private static final int DEFAULT_CAPACITY = 10;

    Object[] array;
    int size;

    public CustomArrayList() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public CustomArrayList(int initialCapacity) {
        array = new Object[initialCapacity];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return size > 0 ? false : true;
    }

    public boolean contains(Object o) {
        for (Object object : array) {
            if (o.equals(object)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new CustomArrayListIterator<>(array, size);
        return  iterator;
    }

    @Override
    public boolean add(T t) {
        resizeUp();
        array[size++] = t;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        resizeDown();

        for (Object object : array) {
            if (o.equals(object)) {
                remove(indexOf(o));
                return true;
            }
        }
        return false;
    }
    @Override
    public void clear() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public T set(int index, T element) {
        if(index>= size)
            throw new IndexOutOfBoundsException();
        T prev = (T) array[index];
        array[index] = element;
        return  prev;
    }

    @Override
    public void add(int index, T element) {
        size++;
        resizeUp();
        addRecursive(index, element);
    }

    private void addRecursive(int index, T element) {
        T prev = (T) array[index];
        array[index] = element;
        if(index +1 < size)
        addRecursive(index+1, prev);
    }

    @Override
    public T remove(int index) {
        if(index>= size)
            throw new IndexOutOfBoundsException();
        T prev = (T)array[index];
        while(index+1 < size) {
            array[index] = array[index + 1];
            index++;
        }
        size--;
        resizeDown();
        return prev;
    }

     public int indexOf(Object o) {
        int index = -1;
         for(int i = 0 ; i < size; i++) {
            if(array[i].equals(o)) {
                index = i;
                break;
            }
        }
        return index;
    }

    private void resizeUp() {
        Object[] newArray;
        if(array.length*0.9 <= size()){
            newArray = new Object[array.length*2];
            for(int i = 0; i < size(); i++){
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    private void resizeDown(){
        Object[] newArray;
        if(array.length*0.6>size()){
            newArray = new Object[(array.length/3)*2];
            for(int i = 0; i < size(); i++){
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    /**
     * Iterator for CustomArrayList
     */
    private class CustomArrayListIterator<E> implements Iterator<E> {

        private int size;
        private Object[] arr;
        private int index;

        public CustomArrayListIterator(Object[] arr, int size) {
            this.size = size;
            this.arr = arr;
            index = 0;
        }

        @Override
        public boolean hasNext()
        {
            return index < size - 1 ? true : false;
        }

        @Override
        public E next() {
            return (E) arr[index++];
        }

        @Override
        public void remove() {
            while(index+1 < size) {
                arr[index] = arr[index + 1];
                index++;
            }
            size--;
        }
    }
}
