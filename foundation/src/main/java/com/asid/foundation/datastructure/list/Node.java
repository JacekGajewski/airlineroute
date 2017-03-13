package com.asid.foundation.datastructure.list;

/**
 * Component of linked list that stores a value and reference to the next element.
 */
public class Node<T> {

    public Node<T> next;
    public T data;

    public Node(T data){
        this.data = data;
        this.next = null;
    }

    public Node(T data, Node next){
        this.data = data;
        this.next = next;
    }



    public T getData(){
        return data;
    }
    public Node getNext(){
        return next;
    }
    public void setData(T data){
        this.data = data;
    }
    public void setNext(Node next){
        this.next = next;
    }

    public void addFirst(T item){

    }

}
