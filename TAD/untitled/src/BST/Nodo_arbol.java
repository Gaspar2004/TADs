package BST;
import linked_list.Linked_list;
import linked_list.linked_list_interface;
public class Nodo_arbol <K extends Comparable <K>, V> {
    private K key;
    private V value;
    private Nodo_arbol<K, V> left;
    private Nodo_arbol<K, V> right;

    public Nodo_arbol(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void add(K key, V value) {
        Nodo_arbol<K, V> elemento_a_agregar = new Nodo_arbol<>(key, value);
        if (key.compareTo(this.key) > 0) {
            if (right == null) {
                right = elemento_a_agregar;
            } else {
                right.add(key, value);
            }
        } else {
            if (left == null) {
                left = elemento_a_agregar;
            } else {
                left.add(key, value);
            }
        }}
    public Nodo_arbol<K, V> remove(K key){
            Nodo_arbol<K, V> elemento_a_retornar = this;
            if (key.compareTo(this.key) > 0) {
                if (right != null) {
                    right = right.remove(key);
                }
            } else if (key.compareTo(this.key) < 0) {
                if (left != null) {
                    left = left.remove(key);

                } else if (left != null && right != null) {
                    Nodo_arbol<K, V> minimo = right.findMin();
                    this.key = minimo.getKey();
                    this.value = minimo.getValue();
                    right = right.remove(this.key);
                } else {
                    if (left != null) {
                        elemento_a_retornar = left;
                    } else {
                        elemento_a_retornar = right;
                    }
                }

            }
            return elemento_a_retornar;
        }

    public void inOrder(linked_list_interface<K> lista) {
        if (left != null) {
            left.inOrder(lista);
        }
        lista.add(key);
        if (right != null) {
            right.inOrder(lista);
        }
    }
    public K getKey() {
        return key;
    }


    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Nodo_arbol<K, V> getLeft() {
        return left;
    }

    public void setLeft(Nodo_arbol<K, V> left) {
        this.left = left;
    }

    public Nodo_arbol<K, V> getRight() {
        return right;
    }

    public void setRight(Nodo_arbol<K, V> right) {
        this.right = right;
    }
    public Nodo_arbol<K, V> findMin() {
        Nodo_arbol<K, V> minimo = this;
        if (left != null) {
            minimo = left.findMin();
        }
        return minimo;
    }

}
