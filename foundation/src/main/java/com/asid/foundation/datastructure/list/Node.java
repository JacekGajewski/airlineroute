package com.asid.foundation.datastructure.list;

/**
 * Component of linked list that stores a value and reference to the next element.
 */
public class Node {

    private Node next;
    private Object data;

    public Node(Object data){
        this.data = data;
        this.next = null;
    }

    public Node(Object data, Node next){
        this.data = data;
        this.next = next;
    }

    public Object getData(){
        return data;
    }
    public Node getNext(){
        return next;
    }
    public void setData(Object data){
        this.data = data;
    }
    public void setNext(Node next){
        this.next = next;
    }

}
