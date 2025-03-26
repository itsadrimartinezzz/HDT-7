package uvg.edu.gt;

// Esta clase define un Árbol Binario de Búsqueda genérico (BST),
// que solo permite elementos que puedan ser comparados (implementen Comparable).
public class BinarySearchTree<E extends Comparable<E>> {
    // Nodo raíz del árbol
    private Node<E> root;

    // Método público para insertar un valor en el árbol
    public void insert(E value) {
        root = insertRecursive(root, value);
    }

    // Método privado recursivo que inserta un valor en el árbol en su posición correcta
    private Node<E> insertRecursive(Node<E> node, E value) {
        if (node == null) return new Node<>(value);  // Si el nodo actual es nulo, se crea uno nuevo

        int cmp = value.compareTo(node.data); // Se compara el nuevo valor con el valor actual del nodo

        if (cmp < 0) {
            // Si el nuevo valor es menor, se inserta en el subárbol izquierdo
            node.left = insertRecursive(node.left, value);
        } else if (cmp > 0) {
            // Si es mayor, se inserta en el subárbol derecho
            node.right = insertRecursive(node.right, value);
        } else {
            // Si es igual (misma clave), se verifica si es un producto para reemplazar si el precio actual es menor
            if (value instanceof Product) {
                Product nuevo = (Product) value;
                Product existente = (Product) node.data;

                // Solo se reemplaza si el nuevo producto tiene menor precio actual
                if (nuevo.priceCurrent < existente.priceCurrent) {
                    node.data = value;
                }
            }
        }

        return node; // Retorna el nodo (modificado o no)
    }

    // Método público para buscar un valor en el árbol
    public E search(E value) {
        Node<E> current = root; // Se comienza desde la raíz
        while (current != null) {
            int cmp = value.compareTo(current.data);

            if (cmp == 0) return current.data;     // Si lo encuentra, lo retorna
            else if (cmp < 0) current = current.left;  // Si es menor, busca en la izquierda
            else current = current.right;             // Si es mayor, busca en la derecha
        }
        return null; // Si no lo encuentra, retorna null
    }

    // Clase interna privada que representa cada nodo del árbol
    private static class Node<E> {
        E data;         // Dato almacenado (puede ser cualquier clase que implemente Comparable)
        Node<E> left;   // Referencia al hijo izquierdo
        Node<E> right;  // Referencia al hijo derecho

        // Constructor
        Node(E data) {
            this.data = data;
        }
    }
}
