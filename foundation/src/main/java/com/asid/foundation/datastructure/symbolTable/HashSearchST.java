package com.asid.foundation.datastructure.symbolTable;

import com.asid.foundation.datastructure.list.CustomArrayList;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tnt9 on 01.05.17.
 */
public class HashSearchST<K, V> extends AbstractSymbolTable{

    private static final int INIT_CAPACITY = 4;

    private int numberOfData;
    private int arraySize;
    private V[] values;
    private K[] keys;

    public HashSearchST(){
        this(INIT_CAPACITY);
    }


    public HashSearchST(int initCapacity) {
        arraySize = initCapacity;
        numberOfData = 0;
        values =(V[]) new Object[arraySize];
        keys =(K[]) new Object[arraySize];
    }


    @Override
    public int size() {
        return numberOfData;
    }

    @Override
    public boolean isEmpty() {
        return numberOfData == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return get(key) != null;
    }

    private int hashCode(Object key){
        return (key.hashCode() & 0x7fffffff) % arraySize;
    }

    @Override
    public Object get(Object key) {

        for(int i = hashCode(key); keys[i] != null; i = (i + 1) % arraySize) {
            if(keys[i].equals(key)){
                return values[i];
            }
        }
        return null;
    }
    private void resize(int capacity){
        HashSearchST<K, V> temp = new HashSearchST<>(capacity);
        for(int i = 0; i < arraySize; i++){
            if(keys[i] != null){
                temp.put(keys[i], values[i]);
            }
        }
        keys = temp.keys;
        values = temp.values;
        arraySize = temp.arraySize;
    }

    @Override
    public Object put(Object key, Object value) {

        V previousValue;
        if(numberOfData >= arraySize /2) resize(2* arraySize);

        int i;
        for(i = hashCode(key); keys[i] != null; i = (i + 1) % arraySize){
            if (keys[i].equals(key)){
                previousValue = values[i];
                values[i] = (V) value;
                return previousValue;
            }
        }
        keys[i] = (K) key;
        values[i] = (V) value;
        numberOfData++;
        return null;
    }

    @Override
    public Object put(Comparable key, Object value) {
        V previousValue;
        if(numberOfData >= arraySize /2) resize(2* arraySize);

        int i;
        for(i = hashCode(key); keys[i] != null; i = (i + 1) % arraySize){
            if (keys[i].equals(key)){
                previousValue = values[i];
                values[i] = (V) value;
                return previousValue;
            }
        }
        keys[i] = (K) key;
        values[i] = (V) value;
        numberOfData++;
        return null;
    }

    @Override
    public Object remove(Object key) {

        V removedValue;
        if(!containsKey(key)) return null;

        int i = hashCode(key);

        while(!key.equals(keys[i])){
            i = (i + 1) % arraySize;
        }

        keys[i] = null;
        removedValue = values[i];
        values[i] = null;

        i = (i + 1) % arraySize;
        while(keys[i] != null){

            K setKey = keys[i];
            V setValue = values[i];

            keys[i] = null;
            values[i] = null;
            numberOfData--;
            put(setKey, setValue);
            i = (i + 1) % arraySize;
        }
        numberOfData--;
        return removedValue;
    }

    @Override
    public Set keySet() {
        Set<K> set = new HashSet<>();
        for(int i = 0; i < arraySize; i++){
            if(keys[i] != null){
                set.add(keys[i]);
            }
        }
        return set;
    }
}
