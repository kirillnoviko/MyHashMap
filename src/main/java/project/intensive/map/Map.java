package project.intensive.map;

import java.util.Collection;
import java.util.Set;

public interface Map<K, V>  {
    int size();

    boolean isEmpty();

    V get(Object var1);

    V put(K var1, V var2);

    V remove(Object var1);

    void clear();

    boolean equals(Object var1);

    int hashCode();


}
