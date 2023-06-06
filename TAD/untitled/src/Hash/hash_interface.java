package Hash;
import java.util.LinkedList;

public interface hash_interface<K,V> {
    void put(K key, V value);
    V get(K key);
    void remove(K key);
    boolean contains(K key);
    int size();
    boolean isEmpty();
    LinkedList<K> keys();
    LinkedList<V> values();
}