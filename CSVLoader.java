package util;

import model.Product;
import java.io.*;
import java.util.*;
import java.nio.file.*;

/**
 * Cargador de productos desde archivo CSV.
 */
public class CSVLoader {

    public static List<Product> loadProducts(String csvPath) {
        List<Product> products = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(csvPath))) {
            String line;
            br.readLine(); // Saltar encabezado
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length < 6) continue;

                String sku = tokens[0].trim();
                double priceRetail = Double.parseDouble(tokens[2]);
                double priceCurrent = Double.parseDouble(tokens[3]);
                String name = tokens[4];
                String category = tokens[5];

                products.add(new Product(sku, priceRetail, priceCurrent, name, category));
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error leyendo archivo: " + e.getMessage());
        }
        return products;
    }
}
