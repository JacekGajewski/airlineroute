
package com.asid.foundation.datastructure.list;

import java.util.Iterator;


/**
 * List based on recursively related objects
 *
 * @param <T>
 */

public class CustomLinkedList<T> extends AbstractCustomListAdapter<T> {

    private Node<T> head;
    private int size;


    public CustomLinkedList(){
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return  size;
    }

    @Override
    public boolean isEmpty() {

        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        Node<T> tmp = head;
        for(int i = 0; i<size; i++){
            if(tmp.data.equals(o)){
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {

        return new CustomLinkedListIterator<>();
    }

    @Override
    public boolean add(T t) {
        if(head == null){
            addFirst(t);
        }else{
            Node<T> tmp = head;
            while(tmp.next != null){
                tmp=tmp.next;
            }
            tmp.next = new Node<T>(t, null);
        }
            size++;
        return true;
    }
    public void addFirst(T t){
        head = new Node<T>(t, head);
    }

    @Override
    public boolean remove(Object o) {
        if(contains(o)) {

            Node<T> tmp = head;
            for (int i = 0; i < size; i++) {
                if (o.equals(tmp.data)) {
                    if(tmp.next == null){
                        tmp = null;
                        size--;
                        return true;
                    }else {
                        tmp.data = tmp.next.data;
                        tmp.next = tmp.next.next;
                        size--;
                        return true;
                    }
                }
                tmp = tmp.next;
            }
        }
        return false;
    }

    @Override
    public void clear() {

        head = null;
        size = 0;

    }

    @Override
    public T get(int index) {
        Node<T> tmp = head;
        for(int i = 0; i<index; i++){
            tmp = tmp.next;
        }
        return  tmp.data;
    }

    @Override
    public T set(int index, T element) {
        if(index>= size)
            throw new IndexOutOfBoundsException();
        Node<T> tmp = head;
        for(int i = 0; i<index; i++){
            tmp = tmp.next;
        }
        Node<T> prev = tmp;
        tmp.data = element;
        return (T) prev;
    }

    @Override
    public void add(int index, T element) {
        Node<T> tmp = head;
        for (int i = 0; i<(index-1); i++){
            tmp = tmp.next;
        }
        Node<T> cos = new Node(element, tmp.next);
        tmp.next = cos;
        size++;

    }

    @Override
    public T remove(int index) {
        if(index>= size)
            throw new IndexOutOfBoundsException();
        Node<T> tmp = head;

        for(int i = 0; i < (index-1); i++){
            tmp = tmp.next;
        }
        Node<T> prev = tmp.next;
        tmp.next = tmp.next.next;
        size--;
        return  prev.data;
    }

    @Override
    public int indexOf(Object o) {
        if(contains(o)) {
            Node<T> tmp = head;
            for (int i = 0; i < size; i++) {
                if(tmp.equals(o)){
                    return i;
                }
                tmp = tmp.next;
            }
        }
            return -1;
    }

     //* Iterator for CustomLinkedList


    private class CustomLinkedListIterator<E> implements Iterator<E> {

        private Node<T> nextNode;

        public CustomLinkedListIterator(){
            nextNode = head;
        }

        @Override
        public boolean hasNext() {

            return nextNode != null;

        }

        @Override
        public E next() {

            T nex = nextNode.data;
            nextNode = nextNode.next;
            return  (E) nex;
        }

        @Override
        public void remove() {

        }
    }
}

