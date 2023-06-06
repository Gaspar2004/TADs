import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import Heap.MYheap;
public class Heap {
    @Test
    void insert() {
        MYheap <Integer> MYheap_prueba = new MYheap <> (10);
        assertEquals(0, MYheap_prueba.size());
        MYheap_prueba.insert(1);
        MYheap_prueba.insert(5);
        MYheap_prueba.insert(3);
        assertEquals(3, MYheap_prueba.size());
        assertEquals(1, MYheap_prueba.get());

    }
    @Test
    void delete() {
        MYheap <Integer> MYheap = new MYheap <> (10);
        MYheap.insert(7);
        MYheap.insert(5);
        MYheap.insert(3);
        assertEquals ( 3, MYheap.size() );

        assertEquals(3, MYheap.delete());
        assertEquals(2, MYheap.size());
        assertEquals(5, MYheap.delete());
        assertEquals(1, MYheap.size());
        assertEquals(7, MYheap.delete());
    }
    @Test
    void get() {
        MYheap <Integer> MYheap = new MYheap <> (10);
        MYheap.insert(7);
        MYheap.insert(5);
        MYheap.insert(3);
        assertEquals(3, MYheap.get());

        MYheap.delete();
        assertEquals(5, MYheap.get());
        MYheap.delete();
        assertEquals(7, MYheap.get());
    }
    @Test
    void size() {
        MYheap <Integer> MYheap = new MYheap <> (10);
        assertEquals(0, MYheap.size());
        MYheap.insert(7);
        assertEquals(1, MYheap.size());
        MYheap.insert(5);
        assertEquals(2, MYheap.size());
        MYheap.insert(3);
        assertEquals(3, MYheap.size());
        MYheap.delete();
        assertEquals(2, MYheap.size());
        MYheap.delete();
        assertEquals(1, MYheap.size());
        MYheap.delete();
        assertEquals(0, MYheap.size());
    }

}
