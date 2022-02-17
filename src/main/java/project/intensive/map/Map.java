package project.intensive.map;

import java.util.Collection;
import java.util.Set;

public interface Map<K, V>  {
    int size();

    boolean isEmpty();

    V get(Object key);

    V put(K key, V value);

    V remove(Object key);

    void clear();

    boolean equals(Object key);

    int hashCode();


}
