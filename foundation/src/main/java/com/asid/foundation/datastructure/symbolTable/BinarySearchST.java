package com.asid.foundation.datastructure.symbolTable;

import java.util.*;

/**
 * Created by tnt9 on 08.04.17.
 */
public class BinarySearchST<K, V> extends AbstractSymbolTable {

    ArrayList<Node> list;
    Comparator<K> comparator;

    BinarySearchST(ArrayList list, Comparator comparator){

        this.list = list;
        this.comparator = comparator;
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
        if(comparator.compare((K) key, list.get(0).getKey()) == -1 ||
                comparator.compare((K) key, list.get(list.size() - 1).getKey()) == 1) {
            return false;
        }
        if (comparator.compare((K) key, list.get(0).getKey()) == 0) return true;
        return findIndex(list, comparator, (K) key) != 0;
    }

    @Override
    public Object get(Object key) {

       return list.get(findIndex(list, comparator, (K) key)).getValue();
    }

    @Override
    public Object put(Object key, Object value) {
        V temp;
        Node node = new Node((K)key, (V)value);
        int index = putIndex(list, comparator,(K) key);
        if(list.size() == index ||
                list.size() == 0){
            list.add(node);
            return null;
        }
        temp = list.get(index).getValue();
        list.add(index, node);

        return temp;
    }

    public int putIndex(List<Node> list, Comparator comparator, K key){
        if (list.size() < 2){
            if (list.size() == 0) return 0;
            if (comparator.compare(key, list.get(0).getKey()) == 1){
                return 1;
            }else{
                return 0;
            }
        }
        if (comparator.compare(key, list.get(list.size() - 1).getKey()) == 1){
            return list.size();
        }else if (comparator.compare(key, list.get(0).getKey()) == -1){
            return 0;
        }
        if (comparator.compare(key, list.get(list.size()/2).getKey()) == 1 &&
                comparator.compare(key, list.get(list.size()/2 + 1).getKey()) == -1){
            return list.size()/2;
        }else if(comparator.compare(key, list.get(list.size()/2).getKey()) == -1){
            putIndex(list.subList(0, list.size()/2 - 1), comparator, key);
        }else if (comparator.compare(key, list.get(list.size()/2 + 1).getKey()) == 1) {
            putIndex(list.subList(list.size() / 2 + 2, list.size() - 1), comparator, key);
        }
        //2 4 6 8 10 12   size = 6;

        return 0;
    }

    @Override
    public Object put(Comparable key, Object value) {
        V temp = null;
        Node node = new Node((K)key, (V)value);
        if (list.size() == 0){
            list.add(node);
            return null;
        }
        int index = putIndex(list, comparator,(K) key);
        if(index == (list.size())){
            list.add(index, node);
            return null;
        }
        temp = list.get(index).getValue();
        list.add(index, node);

        return temp;
    }

    @Override
    public Object remove(Object key) {

        int index = findIndex(list, comparator,(K) key);
        V temp = list.get(index).getValue();
        list.remove(index);

        return temp;
    }

    public int findIndex(List<Node> list, Comparator comparator, K key){
        if (comparator.compare(key, list.get(list.size()/2).getKey()) == 0){
            return list.size()/2;
        }else if(comparator.compare(key, list.get(list.size()/2).getKey()) == 1){
            return list.size()/2 + 1 + findIndex(list.subList(list.size()/2 + 1, list.size()), comparator, key);
        }else if(comparator.compare(key, list.get(list.size()/2).getKey()) == -1) {
            return findIndex(list.subList(0, list.size() / 2), comparator, key);
        }
        // 2 4 6 8 10   size = 5;
        return 0;
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


        public Node(K key, V value) {
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
