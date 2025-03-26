package model;

/**
 * Nodo de un Árbol Binario de Búsqueda.
 */
public class BSTNode<E> {
    E data;
    BSTNode<E> left, right;

    public BSTNode(E data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
