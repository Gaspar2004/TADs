package BST;

import java.text.BreakIterator;

import linked_list.linked_list_interface;

public class BST <K extends Comparable<K>, T> implements BST_interfaz<K,T>{
    private Nodo_arbol<K,T> root=null;



    @Override
    //agregar nodo arbol binario de busqueda
    public void add(K key, T value) {
        Nodo_arbol<K,T> elemento_a_agregar = new Nodo_arbol<>(key, value);
        if(root == null){
            System.out.println("primero - "+ key);
            root = elemento_a_agregar;
        }else {
            System.out.println("primero - "+ root.getKey());
            Nodo_arbol<K,T> aux = root;
            while (aux != null) {
                // Comprobamos si tenemos que insertarlo ya
                // Comprobamos si nodo hoja
                if (aux.getRight() == null && aux.getRight() == null) {
                    if (aux.getKey().compareTo(key) < 0) {
                        // Derecha
                        System.out.println(key + " 1Lo insertamos a la derecha de: " + aux.getKey());
                        aux.setRight(elemento_a_agregar);
                        aux = null;
                    } else {
                        // Izquierda
                        System.out.println(key + " 1Lo insertamos a la izquierda de: " + aux.getKey());
                        aux.setLeft(elemento_a_agregar);
                        aux = null;
                    }
                } else if (aux.getKey().compareTo(key)<0 && aux.getLeft() == null) {
                    // Lo insertamos a la derecha
                    System.out.println(key + " 2Lo insertamos a la derecha de: " + aux.getKey());
                    aux.setRight(elemento_a_agregar);
                    aux = null;
                } else if (aux.getKey().compareTo(key)>0 && aux.getRight() == null) {
                    // Lo insertamos a la izquierda
                    System.out.println(key + " 2Lo insertamos a la izquierda de: " + aux.getKey());
                    aux.setLeft(elemento_a_agregar);
                    aux = null;
                } else {
                    // Pasamos de nodo
                    if (aux.getKey().compareTo(key)<0) {
                        aux = aux.getRight();
                    } else {
                        aux = aux.getLeft();
                    }
                }
 
            }
            //root = temp;
                
        }
    }

    @Override
    public T find(K key) {
        Nodo_arbol<K,T> aux = root;
        T resultado = null;
        while (aux != null) {
            // Comprobamos si es el valor
            if (aux.getKey().compareTo(key) == 0) {
                // Hemos encontrado el elemento
                resultado = aux.getValue();
                aux = null;
            } else if (aux.getRight() == null && aux.getLeft() == null) {
                // Si hemos llegado a un nodo hoja el elemento no está en el ABB
                // El elemento no está
                aux = null;
            } else if ( aux.getKey().compareTo(key)<0 && aux.getRight() != null) {
                // Si el valor es mayor y tenemos nodo a la derecha, vamos a la derecha
                aux = aux.getRight();
            } else if (aux.getKey().compareTo(key)>0 && aux.getLeft() != null) {
                // Si el valor es menos y tenemos nodo a la izquierda, vamos a la izquierda
                aux = aux.getLeft();
            } else {
                // Si el nodo es mayor y no tenemos nodo a la derecha o es menor y no tenemos
                // nodo a la izquierda
                // El elemento no está
                aux = null;
            }

        }
 
 
        return resultado;
        
    }

    @Override
    public boolean contains(K key) {
        Nodo_arbol<K,T> aux = root;
        boolean resultado = false;
        while (aux != null) {
            // Comprobamos si es el valor
            if (aux.getKey().compareTo(key) == 0) {
                // Hemos encontrado el elemento
                resultado = true;
                aux = null;
            } else if (aux.getRight() == null && aux.getLeft() == null) {
                // Si hemos llegado a un nodo hoja el elemento no está en el ABB
                // El elemento no está
                aux = null;
            } else if ( aux.getKey().compareTo(key)<0 && aux.getRight() != null) {
                // Si el valor es mayor y tenemos nodo a la derecha, vamos a la derecha
                aux = aux.getRight();
            } else if (aux.getKey().compareTo(key)>0 && aux.getLeft() != null) {
                // Si el valor es menos y tenemos nodo a la izquierda, vamos a la izquierda
                aux = aux.getLeft();
            } else {
                // Si el nodo es mayor y no tenemos nodo a la derecha o es menor y no tenemos
                // nodo a la izquierda
                // El elemento no está
                aux = null;
            }

        }
 
 
        return resultado;
        
    }

    @Override
    public void remove(K key) {
        boolean resultado = false;
        Nodo_arbol<K,T> aux = root;
        while (aux != null) {
            // Si es la raiz
            if (aux.getKey().compareTo(key)==0) {
                Nodo_arbol<K,T> nodoAEliminar = aux;
 
                if (aux.getRight() != null) {
                    root = aux.getRight();
                    if (nodoAEliminar.getLeft() != null) {
                        add(nodoAEliminar.getLeft().getKey(), nodoAEliminar.getLeft().getValue());
                        nodoAEliminar.setLeft(null);
                        nodoAEliminar.setRight(null);
                    }
                }else if (aux.getLeft() != null) {
                    root = aux.getLeft();
                    if (nodoAEliminar.getRight() != null) {
                        add(nodoAEliminar.getRight().getKey(), nodoAEliminar.getRight().getValue());
                        nodoAEliminar.setLeft(null);
                        nodoAEliminar.setRight(null);
                    }
                }else {
                    root = null;
                }
                 
                resultado = true;
                aux = null;
            } else if (aux.getLeft() != null && aux.getLeft().getKey().compareTo(key)==0) {
                Nodo_arbol<K,T> nodoAEliminar = aux.getLeft();
                // Si el valor está a la izquierda del nodo que estamos recorriendo
                // Miramos si tenemos izquierda en el nodo a eliminar
 
                if (aux.getLeft().getRight() != null) {
                    // Tenemos Nodo a la izquierda
                    // Apuntamos el nodo que estamos recorriendo al siguiente del nodo a eliminar
                    aux.setLeft(aux.getLeft().getLeft());
                    // Reposicionamos sus hijos
                    if (nodoAEliminar.getRight() != null) {
                        add(nodoAEliminar.getRight().getKey(), nodoAEliminar.getRight().getValue());
                    }
                    nodoAEliminar.setRight(null);
                    nodoAEliminar.setLeft(null);
                    resultado = true;
                    aux = null;
                } else {
                    // No tenemos nodo a la izquierda del elemento a eliminar
                    // Miramos si es nodo hoja
 
                    if (aux.getLeft() == null && aux.getRight() == null) {
                        aux.setLeft(null);
                    } else {
                        aux.setLeft(null);
                        if (nodoAEliminar.getLeft() != null) {
                            add(nodoAEliminar.getRight().getKey(), nodoAEliminar.getRight().getValue());
                        }
                    }
                     
                    resultado = true;
                    aux = null;
                }
 
            } else if (aux.getRight() != null && aux.getRight().getKey().compareTo(key)==0) {
                Nodo_arbol<K,T> nodoAEliminar = aux.getRight();
                // Si el valor está a la derecha del nodo que estamos recorriendo
                // Miramos si tenemos derecha en el nodo a eliminar
 
                if (aux.getRight().getRight() != null) {
                    // Tenemos Nodo a la izquierda
                    // Apuntamos el nodo que estamos recorriendo al siguiente del nodo a eliminar
                    aux.setRight(aux.getRight().getRight());
                    // Reposicionamos sus hijos
                    if (nodoAEliminar.getLeft() != null) {
                        add(nodoAEliminar.getLeft().getKey(), nodoAEliminar.getLeft().getValue());
                    }
                    nodoAEliminar.setRight(null);
                    nodoAEliminar.setLeft(null);
                    resultado = true;
                    aux = null;
                } else {
                    // No tenemos nodo a la izquierda del elemento a eliminar
                    // Miramos si es nodo hoja
 
                    if (aux.getLeft() == null && aux.getRight().getRight() == null) {
                        aux.setRight(null);
                    } else {
                        aux.setRight(null);
                        if (nodoAEliminar.getLeft() != null) {
                            add(nodoAEliminar.getLeft().getKey(), nodoAEliminar.getLeft().getValue());
                        }
 
                    }
                     
                    resultado = true;
                    aux = null;
                }
            } else {
                if (aux.getKey().compareTo(key)<0) {
                    aux = aux.getRight();
                } else {
                    aux = aux.getLeft();
                }
            }
        }
    }

    @Override
    public K findMin() {
        Nodo_arbol<K,T> aux = root;
        while(aux.getLeft()!=null)
            aux = aux.getLeft();
        K min = aux.getKey();
        return min;
    }

    @Override
    public K findMax() {
        Nodo_arbol<K,T> aux = root;
        while(aux.getRight()!=null)
            aux = aux.getRight();
        K max = aux.getKey();
        return max;
    }

    @Override
    public linked_list_interface<K> inOrder() {
        return null;
    }


}
