package Heap;
import linked_list.linked_list_interface;

public interface heap_interfaz {
    int parent(int i);
    int leftChild(int i);
    int rightChild(int i);
    boolean isLeaf(int i);
    void insert(int element);
    int remove();
    void minHeapify(int i);
    void swap(int first, int second);
    int[] getHeap();
    
}
