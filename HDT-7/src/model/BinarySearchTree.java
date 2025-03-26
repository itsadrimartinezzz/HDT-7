package model;

public class BinarySearchTree<E extends Comparable<E>> {
    private BSTNode<E> root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public void insert(E value) {
        root = insertRecursive(root, value);
        size++;
    }

    private BSTNode<E> insertRecursive(BSTNode<E> node, E value) {
        if (node == null) {
            return new BSTNode<>(value);
        }

        int comparison = value.compareTo(node.data);
        if (comparison < 0) {
            node.left = insertRecursive(node.left, value);
        } else if (comparison > 0) {
            node.right = insertRecursive(node.right, value);
        }
        return node;
    }

    public E searchBySku(String sku) {
        return searchBySkuRecursive(root, sku);
    }

    @SuppressWarnings("unchecked")
    private E searchBySkuRecursive(BSTNode<E> node, String sku) {
        if (node == null) {
            return null;
        }

        Product product = (Product) node.data; // Casteo seguro porque E será Product
        int comparison = sku.compareTo(product.getSku());
        if (comparison == 0) {
            return node.data;
        } else if (comparison < 0) {
            return searchBySkuRecursive(node.left, sku);
        } else {
            return searchBySkuRecursive(node.right, sku);
        }
    }

    public int size() {
        return size;
    }

    public void printInOrder() {
        printInOrderRecursive(root);
    }

    private void printInOrderRecursive(BSTNode<E> node) {
        if (node != null) {
            printInOrderRecursive(node.left);
            System.out.println(node.data);
            printInOrderRecursive(node.right);
        }
    }
}