package model;

/**
 * Árbol Binario de Búsqueda (BST) genérico.
 */
public class BinarySearchTree<E extends Comparable<E>> {
    private BSTNode<E> root;

    public void insert(E value) {
        root = insertRecursive(root, value);
    }

    private BSTNode<E> insertRecursive(BSTNode<E> node, E value) {
        if (node == null) return new BSTNode<>(value);
        if (value.compareTo(node.data) < 0) node.left = insertRecursive(node.left, value);
        else if (value.compareTo(node.data) > 0) node.right = insertRecursive(node.right, value);
        return node;
    }

    public E search(E target) {
        return searchRecursive(root, target);
    }

    private E searchRecursive(BSTNode<E> node, E target) {
        if (node == null) return null;
        int cmp = target.compareTo(node.data);
        if (cmp == 0) return node.data;
        else if (cmp < 0) return searchRecursive(node.left, target);
        else return searchRecursive(node.right, target);
    }
}
