package project.intensive.map.impl;


import project.intensive.map.*;

import java.util.Arrays;
import java.util.Set;

public class HashMap<K, V> implements Map<K, V> {

    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75F;


    transient Node<K, V>[] table;
    transient int size;
    int threshold;
    float loadFactor;
    int initialCapacity;

    public HashMap(){
        initialCapacity=DEFAULT_INITIAL_CAPACITY;
        loadFactor = DEFAULT_LOAD_FACTOR;
        threshold= (int) (initialCapacity* loadFactor);
    };


    public HashMap(int initialCapacity){
        this.initialCapacity=initialCapacity;
        loadFactor = DEFAULT_LOAD_FACTOR;
        threshold= (int) (initialCapacity* loadFactor);

    };

    public HashMap(int initialCapacity, float loadFactor){
        this.initialCapacity=initialCapacity;
        this.loadFactor = loadFactor;
        threshold= (int) (this.initialCapacity * this.loadFactor);
    };



    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(table.length==0 || table==null){
            return true;
        }
        return false;
    }

    @Override
    public V get(Object key) {

        if(table!=null) {
            int hash = hash(key);
            int i = (table.length - 1) & hash;
            if (table[i] != null) {
                Node<K,V> node = table[i];
                while(node!=null){
                    if (node.hash == hash && (node.hash == hash || (key != null && key.equals(node.hash)))) {
                        return node.value;
                    }else{
                        node=node.next;
                    }
                }

            }
            throw new RuntimeException("нет такого элемента");
        }
        else {
            throw new RuntimeException("Map is empty");
        }

    }

    @Override
    public V put(K key, V value) {

        if (table == null || table.length == 0){
            resize();
        }
        int hash=hash(key);
        int i=(table.length -1 ) & hash;

        if (table[i] == null){
            table[i]= new Node<>(hash,key,value,null);
            if (++size > threshold)
                resize();
        }
        else {
            Node node = new Node<>(hash, key, value, null);
            Node tempNode = table[i];

            while (true) {
                if (tempNode.getHash() == hash && (tempNode.getKey() == key || (key != null && key.equals(tempNode.getKey())))) {
                    tempNode.value = value;
                    break;
                } else {
                    if (tempNode == null) {
                        tempNode.next = node;
                        if (++size > threshold)
                            resize();
                        break;
                    }
                    tempNode = tempNode.next;
                }
            }
        }

        return  value;
    }

    @Override
    public V remove(Object key) {

        if(table!=null) {
            int hash = hash(key);
            int i = (table.length - 1) & hash;
            if (table[i] != null) {
                if(table[i].next==null){
                    if (table[i].hash == hash && (table[i].hash == hash || (key != null && key.equals(table[i].hash)))) {
                        V valueTemp=table[i].value;
                        table[i]=null;
                        return valueTemp;
                    }
                }
                else{
                    Node<K,V> node = table[i].next;
                    Node<K,V> predNode =table[i];
                    while(node!=null){
                        if (node.hash == hash && (node.hash == hash || (key != null && key.equals(node.hash)))) {
                            predNode.next=node.next;
                        }else{
                            predNode=node;
                            node=node.next;
                        }
                    }
                }


            }
            throw new RuntimeException("нет такого элемента");
        }
        else {
            throw new RuntimeException("Map is empty");
        }
    }

    @Override
    public void clear() {

    }
    public void resize(){
        if(table==null){
            table = new Node[16];
        }else{
            this.table = Arrays.copyOf(this.table, table.length*2);
        }

    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
