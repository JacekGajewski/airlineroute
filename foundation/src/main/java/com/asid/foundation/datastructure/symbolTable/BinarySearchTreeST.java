package com.asid.foundation.datastructure.symbolTable;

import javafx.beans.binding.ObjectExpression;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by tnt9 on 11.04.17.
 */
public class BinarySearchTreeST<K, V> extends AbstractSymbolTable {


    Comparator<K> comparator;
    Node root;
    int size;

    public BinarySearchTreeST( Comparator<K> comparator) {
        this.root = null;
        this.comparator = comparator;
        size = 0;
    }
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
        if(root == null){
            return false;
        }
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
        if(!containsKey(key)) return null;

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
        if(!containsKey(key)) return null;
        Node temp = value(root, key);
        if(root.getKey().equals(key)){
            root = removeRoot(root);
            size--;
            return temp.getValue();
        }
        remove(root, key);
        size--;
        return temp.getValue();
    }
    public Node removeRoot(Node x){

        Node t = x;
        if(t.getRight() != null){
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }else if(t.getLeft() != null){
            x = t.getLeft();
        }else{
            x = null;
        }
        return x;
    }
    public Node remove(Node x, Object key){

       if(x == null){
           return null;
       }
       if(comparator.compare((K) key, x.getKey()) == 1){
           x.right = remove(x.right, key);
       }
       else if(comparator.compare((K) key, x.getKey()) == -1){
            x.left = remove(x.left, key);
       }
       else{

           if(x.right == null) return x.left;
           if(x.left == null) return x.right;
           Node t = x;
           x = min(t.right);
           x.right = deleteMin(t.right);
           x.left = t.left;
       }
       return x;
    }

    public Node min(Node x){
        if(x.getLeft() == null) return x;
        return min(x.getLeft());
    }

    public Node deleteMin(Node x){
        if(x.left == null) return x.right;
        x.left = deleteMin(x.left);
        return x;
    }
    public Node value(Node x, Object key){
        Node temp;
        if(x == null){
            return null;
        }
        if(comparator.compare((K) key, x.getKey()) == 1){
            x = value(x.right, key);
        }
        else if(comparator.compare((K) key, x.getKey()) == -1){
            x = value(x.left, key);
        }
        return x;
    }

    @Override
    public Set keySet() {
        Set<K> set = new HashSet<>();
        allKeys(root, set);
        return set;
    }
    public void allKeys(Node x, Set<K> set){

        if(x == null) return;

        allKeys(x.getLeft(), set);
        set.add(x.getKey());
        allKeys(x.getRight(), set);
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
