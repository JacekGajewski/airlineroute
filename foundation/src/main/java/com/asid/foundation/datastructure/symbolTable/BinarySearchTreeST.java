package com.asid.foundation.datastructure.symbolTable;

import javafx.beans.binding.ObjectExpression;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * Created by tnt9 on 11.04.17.
 */
public class BinarySearchTreeST<K, V> extends AbstractSymbolTable {

    //List<Node> list;
    Comparator<K> comparator;
    Node root;
    int size;

    public BinarySearchTreeST( Comparator<K> comparator) {
        this.root = null;
        this.comparator = comparator;
        size = 0;
        //setRoot();
    }

   /* public void setRoot(){
        if(!list.isEmpty()){
            root = list.get(list.size()/2);
        }
    }*/

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean containsKey(Object key) {

        return find(root, key);
    }
    public boolean find(Node x, Object key){
        boolean result = false;
        if (comparator.compare((K) key, x.getKey()) == 1) {
            if(x.getRight() == null){
                return false;
            }
            x = x.getRight();
            result = find(x, key);
        }else if(comparator.compare((K) key, x.getKey()) == -1) {
            if (x.getLeft() == null) {
                return false;
            }
            x = x.getLeft();
            result = find(x, key);
        }else if(comparator.compare((K) key, x.getKey()) == 0){
            return true;
        }
        return result;
    }

    @Override
    public Object get(Object key) {

        return get(root, key);
    }

    public Object get(Node x, Object key){

        if (comparator.compare((K) key, x.getKey()) == 1) {
            x = x.getRight();
            return get(x,key);
        }
        else if(comparator.compare((K) key, x.getKey()) == -1){
            x = x.getLeft();
            return get(x, key);
        }
        return x.getValue();
    }

    @Override
    public Object put(Object key, Object value) {
        if(root == null){
            size++;
            root = new Node((K) key,(V) value);
            return null;
        }
        return put(root, key, value);
    }

    @Override
    public Object put(Comparable key, Object value) {

        if(root == null){
            size++;
            root = new Node((K) key,(V) value);
            return null;
        }
        return put(root, key, value);
    }

    public V put(Node x, Object key, Object value){

        if (comparator.compare((K) key, x.getKey()) == 1) {
            if(x.getRight() == null){
                x.setRight(new Node((K) key,(V) value));
                size++;
                return null;
            }
            x = x.getRight();
            put(x, key, value);
        }else if(comparator.compare((K) key, x.getKey()) == -1) {
            if (x.getLeft() == null) {
                size++;
                x.setLeft(new Node((K) key, (V) value));
                return null;
            }
            x = x.getLeft();
            put(x, key, value);
        }else if(comparator.compare((K) key, x.getKey()) == 0){
            V temp = x.getValue();
            x.setValue((V) value);
            return temp;
        }
        return null;
    }

    @Override
    public Object remove(Object key) {

        return remove(root, key);
    }

    public V remove(Node x, Object key){

        V temp = null;

        if (comparator.compare((K) key, x.getKey()) == 1) {
            x = x.getRight();
            temp = remove(x, key);
        }else if(comparator.compare((K) key, x.getKey()) == -1) {
            x = x.getLeft();
            temp = remove(x, key);
        }else if(comparator.compare((K) key, x.getKey()) == 0){
            V result = x.getValue();
            if(x.getRight() != null){
                x = x.getRight();
            }

            root = swap(root, x);

            return result;
        }

        return temp;
    }
    public Node swap(Node root, Node x){
        if(x.getRight() != null){
            x = x.getRight();
            swap(root, x);
        }else{
            x = null;
            size--;
        }
        return root;
    }

    @Override
    public Set keySet() {
        return null;
    }

    private class Node{

        K key;
        V value;
        Node left;
        Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node(K key, V value, Node left, Node right) {
            new Node(key, value);
            this.left = left;
            this.right = right;
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

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

}
