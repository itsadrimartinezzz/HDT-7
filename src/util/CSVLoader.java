package util;

import model.Product;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVLoader {

    public static List<Product> loadProducts(String csvPath) {
        List<Product> products = new ArrayList<>();

        if (!Files.exists(Paths.get(csvPath))) {
            System.err.println("El archivo CSV no existe: " + csvPath);
            return products;
        }

        try (BufferedReader br = Files.newBufferedReader(Paths.get(csvPath))) {
            String line;
            br.readLine(); // Saltar encabezado

            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",", -1);

                if (tokens.length < 19) {
                    System.err.println("Línea inválida: " + line);
                    continue;
                }

                try {
                    String category = tokens[0].trim();
                    String sku = tokens[6].trim();
                    // Manejar valores vacíos asignando 0.0 por defecto
                    String priceRetailStr = tokens[9].trim();
                    double priceRetail = priceRetailStr.isEmpty() ? 0.0 : Double.parseDouble(priceRetailStr);
                    String priceCurrentStr = tokens[10].trim();
                    double priceCurrent = priceCurrentStr.isEmpty() ? 0.0 : Double.parseDouble(priceCurrentStr);
                    String name = tokens[18].trim();

                    if (sku.isEmpty() || name.isEmpty()) {
                        System.err.println("SKU o nombre inválido en línea: " + line);
                        continue;
                    }

                    products.add(new Product(sku, priceRetail, priceCurrent, name, category));
                } catch (NumberFormatException e) {
                    System.err.println("Error al convertir números en línea: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error leyendo archivo: " + e.getMessage());
        }

        return products;
    }
}