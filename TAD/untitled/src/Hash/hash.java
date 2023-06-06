package Hash;
import java.util.Arrays;
import java.util.LinkedList;

public class hash<K,V> implements hash_interface<K,V> {
    V[] elems = null;
    
    public hash(int tamaño){
        elems = (V[]) new Object [tamaño];
    }

    
    public int hashVal(K key){
        //crear una funcion hash para insertar en el arreglo varios valores
        int hash = 0;
        hash = key.hashCode();
        hash = hash % elems.length;
        return hash;
        
    }

    @Override
    public void put(K key, V value) {
        elems[hashVal(key)] = value;
    }

    @Override
    public V get(K key) {
        V value = null;
        value = elems[hashVal(key)];
        return value;
    }

    @Override
    public void remove(K key) {
        elems[hashVal(key)] = null;
    }

    @Override
    public boolean contains(K key) {
        boolean contains = false;
        if(elems[hashVal(key)] != null){
            contains = true;
        }
        return contains;
    }

    @Override
    public int size() {
        return elems.length;
    }

    @Override
    public boolean isEmpty() {
        boolean empty = true;
        for(int i=0; i<elems.length; i++){
            if(elems[i] != null){
                empty = false;
            }
        }
        return empty;
    }


    @Override
    public LinkedList<V> values() {
        LinkedList<V> values = new LinkedList<V>();
        for(int i=0; i<elems.length; i++){
            values.add((V) elems[i]);
        }
        return values;
        
    }

    @Override
    public LinkedList<K> keys() {
        LinkedList<K> keys = new LinkedList<K>();
        for(int i=0; i<elems.length; i++){
            keys.add((K) elems[i]);
        }
        return keys;
    }

    
}
