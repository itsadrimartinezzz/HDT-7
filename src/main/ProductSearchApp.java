package main;

import model.BinarySearchTree;
import model.Product;
import util.CSVLoader;
import java.util.List;
import java.util.Scanner;

public class ProductSearchApp {

    public static void main(String[] args) {
        BinarySearchTree<Product> bst = new BinarySearchTree<>(); // Usar BST genérico
        String csvPath = "Datos.csv";

        List<Product> products = CSVLoader.loadProducts(csvPath);
        for (Product p : products) {
            bst.insert(p);
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Sistema de Búsqueda de Productos ---");
            System.out.println("1. Buscar producto por SKU");
            System.out.println("2. Mostrar total de productos cargados");
            System.out.println("3. Imprimir todos los productos (Inorden)");
            System.out.println("4. Salir");
            System.out.print("Elija una opción: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Entrada inválida. Intente de nuevo.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el SKU a buscar: ");
                    String skuInput = scanner.nextLine();
                    Product found = bst.searchBySku(skuInput);
                    if (found != null) {
                        System.out.println("\nProducto encontrado:\n" + found);
                    } else {
                        System.out.println("\nProducto no encontrado.");
                    }
                    break;
                case 2:
                    System.out.println("\nTotal de productos cargados: " + bst.size());
                    break;
                case 3:
                    System.out.println("\n--- Listado de Productos ---");
                    bst.printInOrder();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }
}