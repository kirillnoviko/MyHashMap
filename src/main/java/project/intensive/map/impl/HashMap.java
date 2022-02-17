package project.intensive.map.impl;


import project.intensive.map.*;

import java.util.Set;

public class HashMap<K, V> implements Map<K, V> {

    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final int MAXIMUM_CAPACITY = 1000000000;
    static final float DEFAULT_LOAD_FACTOR = 0.75F;
    static final int TREEIFY_THRESHOLD = 8;
    static final int UNTREEIFY_THRESHOLD = 6;
    static final int MIN_TREEIFY_CAPACITY = 64;


    transient Node<K, V>[] table;
    transient Set<java.util.Map.Entry<K, V>> entrySet;
    transient int size;
    int threshold;
    final float loadFactor=DEFAULT_LOAD_FACTOR;


    public HashMap(){

    };

    public HashMap(Map< ? extends K, ? extends V> m){

    };

    public HashMap(int initialCapacity){
    };

    public HashMap(int initialCapacity, float loadFactor){

    };



    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public V get(Object var1) {
        return null;
    }

    @Override
    public V put(K var1, V var2) {

        return null;
    }

    @Override
    public V remove(Object var1) {
        return null;
    }

    @Override
    public void clear() {

    }

    static final int hashCode(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
