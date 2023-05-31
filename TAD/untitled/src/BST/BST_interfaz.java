package BST;
import linked_list.linked_list_interface;
public interface BST_interfaz <K,T>{
    void add(K key, T value);
    T find(K key);
    boolean contains(K key);
    void remove(K key);
    T findMin();
    T findMax();
    linked_list_interface<K> inOrder();
    //List<K> preOrder();
    //List<K> postOrder();
}
