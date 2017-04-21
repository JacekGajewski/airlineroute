package com.asid.foundation.datastructure.symbolTable;

import java.util.*;

/**
 * Created by tnt9 on 07.04.17.
 */
public class SequentialSearchST <K, V> extends AbstractSymbolTable {

    LinkedList<Node> list;


    SequentialSearchST(LinkedList list){
        this.list = list;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {

        for(int i = 0; i < list.size(); i++){
            if (list.get(i).getKey() == key){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(Object key) {
        for(int i = 0; i < list.size(); i++){
            if (list.get(i).getKey() == key){
                return list.get(i).getValue();
            }
        }
        return null;
    }

    @Override
    public Object put(Comparable key, Object value) {
        for(int i = 0; i < list.size(); i++){
            if (list.get(i).getKey() == key){
                V temp = list.get(i).getValue();
                list.get(i).setValue((V) value);
                return temp;
            }
        }
        Node temp = new Node((K) key, (V) value);
        list.add(0, temp);
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        for(int i = 0; i < list.size(); i++){
            if (list.get(i).getKey() == key){
                V temp = list.get(i).getValue();
                list.get(i).setValue((V) value);
                return temp;
            }
        }
        Node temp = new Node((K) key, (V) value);
        list.add(0, temp);
        return null;
    }


    @Override
    public Object remove(Object key) {
        for(int i = 0; i < list.size(); i++){
            if (list.get(i).getKey() == key){
                V temp = list.get(i).getValue();
                list.remove(i);
                return temp;
            }
        }
        return null;
    }

    @Override
    public Set keySet() {
        Set<K> set = new HashSet<>();
        for(int i = 0; i < list.size(); i++){
                set.add(list.get(i).getKey());
        }
        return set;
    }

    private class Node{

        K key;
        V value;

        Node(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}

