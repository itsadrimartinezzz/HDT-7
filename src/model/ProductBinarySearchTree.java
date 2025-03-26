package model;

public class ProductBinarySearchTree {
    private BSTNode<Product> root;
    private int size;

    public ProductBinarySearchTree() {
        root = null;
        size = 0;
    }

    public void insert(Product product) {
        root = insertRecursive(root, product);
        size++;
    }

    private BSTNode<Product> insertRecursive(BSTNode<Product> node, Product product) {
        if (node == null) {
            return new BSTNode<>(product);
        }

        int comparison = product.getSku().compareTo(node.data.getSku());
        if (comparison < 0) {
            node.left = insertRecursive(node.left, product);
        } else if (comparison > 0) {
            node.right = insertRecursive(node.right, product);
        }
        return node;
    }

    public Product searchBySku(String sku) {
        return searchBySkuRecursive(root, sku);
    }

    private Product searchBySkuRecursive(BSTNode<Product> node, String sku) {
        if (node == null) {
            return null;
        }

        int comparison = sku.compareTo(node.data.getSku());
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

    private void printInOrderRecursive(BSTNode<Product> node) {
        if (node != null) {
            printInOrderRecursive(node.left);
            System.out.println(node.data);
            printInOrderRecursive(node.right);
        }
    }
}