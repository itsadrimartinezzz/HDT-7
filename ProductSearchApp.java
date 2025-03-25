package main;

import model.*;
import util.CSVLoader;
import java.util.Scanner;

/**
 * App principal para buscar productos por SKU.
 */
public class ProductSearchApp {

    public static void main(String[] args) {
        BinarySearchTree<Product> bst = new BinarySearchTree<>();

        // Ruta corregida (¡doble backslash!)
        String csvPath = "C:\\Users\\adria_qibhpui\\OneDrive\\Escritorio\\Estructura de Datos\\hdt#7\\Datos.csv";
        for (Product p : CSVLoader.loadProducts(csvPath)) {
            bst.insert(p);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el SKU a buscar: ");
        String skuInput = scanner.nextLine();

        Product searchKey = new Product(skuInput, 0, 0, "", "");
        Product found = bst.search(searchKey);

        if (found != null) {
            System.out.println("\n✅ Producto encontrado:\n" + found);
        } else {
            System.out.println("\n❌ Producto no encontrado.");
        }
    }
}
