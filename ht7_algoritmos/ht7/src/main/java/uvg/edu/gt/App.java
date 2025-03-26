package uvg.edu.gt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Se crea un Árbol Binario de Búsqueda (BST) que almacenará productos.
        BinarySearchTree<Product> bst = new BinarySearchTree<>();

        // Ruta al archivo CSV con los datos de los productos.
        //String path = "C:\\Users\\driva\\Desktop\\ht7_algoritmos\\ht7\\src\\main\\resources\\Datos.csv";
        String path = "colocar ruta que esta adentro de la carpeta";


        // --- CARGA MASIVA DESDE CSV ---
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine(); // Se salta la primera línea (encabezado del CSV)

            // Se lee línea por línea el archivo
            while ((line = br.readLine()) != null) {
                // Se separan los campos tomando en cuenta comas dentro de comillas
                String[] parts = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                // Solo se procesan líneas que tengan al menos 20 columnas
                if (parts.length >= 20) {
                    // Se extraen algunos campos relevantes para el producto
                    String sku = parts[6];               // SKU del producto
                    String priceRetail = parts[9];       // Precio de venta original
                    String priceCurrent = parts[10];     // Precio actual
                    String productName = parts[18];      // Nombre del producto
                    String category = parts[0];          // Categoría del producto

                    try {
                        // Se convierten los precios a double
                        double retail = Double.parseDouble(priceRetail);
                        double current = Double.parseDouble(priceCurrent);

                        // Se crea un nuevo objeto Producto
                        Product nuevo = new Product(sku, retail, current, productName, category);

                        // Se busca si ya existe ese producto en el árbol
                        Product existente = bst.search(nuevo);

                        // Si no existe, o el nuevo producto tiene un precio actual más bajo, se inserta
                        if (existente == null || current < existente.priceCurrent) {
                            bst.insert(nuevo);
                        }
                    } catch (NumberFormatException e) {
                        // Si los precios no se pueden convertir a número, se ignoran esos productos
                    }
                }
            }
        } catch (IOException e) {
            // Si ocurre un error al leer el archivo, se muestra un mensaje y termina el programa
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        // --- MENÚ INTERACTIVO ---
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // Se imprime el menú de opciones
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Buscar producto por SKU");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1":
                    // Si el usuario elige buscar por SKU
                    System.out.print("Ingrese el SKU a buscar: ");
                    String skuInput = scanner.nextLine().trim();

                    // Se busca el producto en el BST usando solo el SKU
                    Product result = bst.search(new Product(skuInput));

                    // Se muestra el resultado de la búsqueda
                    if (result != null) {
                        System.out.println("\n=== Producto encontrado ===");
                        System.out.println(result);
                    } else {
                        System.out.println("No se encontró el producto con SKU: " + skuInput);
                    }
                    break;

                case "2":
                    // Opción para salir del programa
                    System.out.println("¡Hasta luego!");
                    return;

                default:
                    // Validación para opción inválida
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }
}
