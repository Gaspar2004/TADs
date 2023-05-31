package BST;

import java.text.BreakIterator;

import linked_list.linked_list_interface;

public class BST <K extends Comparable<K>, T> implements BST_interfaz<K,T>{
    private Nodo_arbol<K,T> root;



    @Override
    //por que nos falla cuando creamos el nodo?
    public void add(K key, T value) {
        Nodo_arbol<K,T> elemento_a_agregar = new Nodo_arbol<>(key, value);
        if (root == null) {
            root = elemento_a_agregar;
        } else {
            root.add(key, value);
        }

    }

    @Override
    public T find(K key) {
        if(root == null)
            return null;
        else if (root.getKey().equals(key))
            return root.getValue();
        else {
            if(root.getLeft()!=null)
                find(root.getLeft().getKey());
            if(root.getRight()!=null)    
                find(root.getRight().getKey());
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        if(root == null)
            return false;
        else if (root.getKey().equals(key))
            return true;
        else {
            if(root.getLeft()!=null)
                contains(root.getLeft().getKey());
            if(root.getRight()!=null)    
                contains(root.getRight().getKey());
        }
        return false;
    }

    @Override
    public void remove(K key) {
        if(root != null){
            if (root.getKey().equals(key))
                root=null;
            else {
                if(root.getLeft()!=null)
                    remove(root.getLeft().getKey());
                if(root.getRight()!=null)
                    remove(root.getRight().getKey());
            }
        }
    }

    @Override
    public T findMin() {
        if(root != null){
            Nodo_arbol<K,T> temp = root;
            while(temp.getLeft()!=null)
                temp = temp.getLeft();
            T min = root.getValue();
            return min;
        }
        return null;
    }

    @Override
    public T findMax() {
        if(root != null){
            Nodo_arbol<K,T> temp = root;
            while(temp.getRight()!=null)
                temp = temp.getRight();
            T max = root.getValue();
            return max;
        }
        return null;
    }

    @Override
    public linked_list_interface<K> inOrder() {
        return null;
    }


}
