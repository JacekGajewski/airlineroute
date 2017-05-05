package com.asid.foundation.datastructure.symbolTable;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by tnt9 on 27.04.17.
 */
public class RedBlackBinarySearchTreeST<K extends Comparable, V> extends AbstractSymbolTable {


    private static final boolean RED   = true;
    private static final boolean BLACK = false;

    int size;
    private Node root;

    RedBlackBinarySearchTreeST(){
        size = 0;
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        if(root == null){
            return false;
        }
        return find(root, (K) key);
    }
    public boolean find(Node x, K key){
        boolean result = false;
        if (key.compareTo(x.key) == 1) {
            if(x.getRight() == null){
                return false;
            }
            x = x.getRight();
            result = find(x, key);
        }else if(key.compareTo(x.key) == -1) {
            if (x.getLeft() == null) {
                return false;
            }
            x = x.getLeft();
            result = find(x, key);
        }else if(key.compareTo(x.key) == 0){
            return true;
        }
        return result;
    }

    @Override
    public Object get(Object key) {
        if(!containsKey(key)) return null;
        return get(root, (K) key);
    }

    private V get(Node x, K key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else              return x.value;
        }
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        if (key == null) return null;

        root = put(root,(K) key,(V) value);
        root.color = BLACK;
        size++;
        return null;
    }

    @Override
    public Object put(Comparable key, Object value) {
        if (key == null) return null;

        root = put(root,(K) key,(V) value);
        root.color = BLACK;
        size++;
        return null;
    }
    private Node put(Node h, K key, V val) {
        if (h == null) return new Node(key, val, RED);

        int cmp = key.compareTo(h.key);
        if      (cmp < 0) h.left  = put(h.left,  key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else              h.value   = val;

        if (isRed(h.right) && !isRed(h.left))      h = rotateLeft(h);
        if (isRed(h.left)  &&  isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left)  &&  isRed(h.right))     flipColors(h);

        return h;
    }

    @Override
    public Object remove(Object key) {
        if (key == null ||!containsKey(key)) return null;

        Object temp = get(key);
        size--;
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }
        root = delete(root,(K) key);
        if (!isEmpty()) root.color = BLACK;
        return temp;
    }
    private Node delete(Node x, K key) {

        if (key.compareTo(x.key) < 0)  {
            if (!isRed(x.left) && !isRed(x.left.left))
                x = moveRedLeft(x);
            x.left = delete(x.left, key);
        }
        else {
            if (isRed(x.left))
                x = rotateRight(x);
            if (key.compareTo(x.key) == 0 && (x.right == null))
                return null;
            if (!isRed(x.right) && !isRed(x.right.left))
                x = moveRedRight(x);
            if (key.compareTo(x.key) == 0) {
                Node temp = min(x.right);
                x.key = temp.key;
                x.value = temp.value;
                // x.val = get(x.right, min(x.right).key);
                // x.key = min(x.right).key;
                x.right = deleteMin(x.right);
            }
            else x.right = delete(x.right, key);
        }
        return balance(x);
    }
    private Node deleteMin(Node h) {
        if (h.left == null)
            return null;

        if (!isRed(h.left) && !isRed(h.left.left))
            h = moveRedLeft(h);

        h.left = deleteMin(h.left);
        return balance(h);
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = x.right.color;
        x.right.color = RED;
        return x;
    }
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = x.left.color;
        x.left.color = RED;
        return x;
    }

    private void flipColors(Node h) {
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    private Node moveRedLeft(Node h) {
        flipColors(h);
        if (isRed(h.right.left)) {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
            flipColors(h);
        }
        return h;
    }
    private Node moveRedRight(Node h) {
        flipColors(h);
        if (isRed(h.left.left)) {
            h = rotateRight(h);
            flipColors(h);
        }
        return h;
    }

    private Node balance(Node h) {
        if (isRed(h.right))                      h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right))     flipColors(h);
        return h;
    }
    private Node min(Node x) {
        if (x.left == null) return x;
        else{
            return min(x.left);
        }
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
        boolean color = true;

        public void seColor(boolean color) {
            this.color = color;
        }

        public boolean isRed(Node x) {

            return x.color;
        }
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public Node(K key, V value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
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

