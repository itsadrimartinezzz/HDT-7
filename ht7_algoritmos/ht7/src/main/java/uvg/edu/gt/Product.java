package uvg.edu.gt;

import java.util.Objects;

/**
 * Clase que representa un producto con información relevante.
 * Implementa Comparable para permitir comparación por SKU en estructuras ordenadas (como BST).
 */
public class Product implements Comparable<Product> {
    String sku;              // Código único de producto (clave de búsqueda)
    double priceRetail;      // Precio original de venta
    double priceCurrent;     // Precio actual del producto
    String productName;      // Nombre del producto
    String category;         // Categoría a la que pertenece el producto

    /**
     * Constructor parcial usado para búsquedas por SKU.
     * @param sku El SKU del producto.
     */
    public Product(String sku) {
        this.sku = sku;
    }

    /**
     * Constructor completo con todos los campos.
     * @param sku SKU del producto.
     * @param priceRetail Precio original.
     * @param priceCurrent Precio actual.
     * @param productName Nombre del producto.
     * @param category Categoría del producto.
     */
    public Product(String sku, double priceRetail, double priceCurrent, String productName, String category) {
        this.sku = sku;
        this.priceRetail = priceRetail;
        this.priceCurrent = priceCurrent;
        this.productName = productName;
        this.category = category;
    }

    /**
     * Método que permite comparar productos por SKU.
     * Es lo que permite que se ordenen correctamente en estructuras como árboles binarios.
     */
    @Override
    public int compareTo(Product o) {
        return this.sku.compareTo(o.sku);
    }

    /**
     * Representación en texto del producto, útil para imprimir detalles.
     */
    @Override
    public String toString() {
        return "Producto: " + productName +
                "\nSKU: " + sku +
                "\nPrecio Retail: $" + priceRetail +
                "\nPrecio Actual: $" + priceCurrent +
                "\nCategoría: " + category;
    }

    /**
     * Compara si dos productos son iguales según su SKU (clave principal).
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(sku, product.sku);
    }

    /**
     * Calcula el hashCode basado en el SKU, necesario si se usan estructuras tipo HashMap o HashSet.
     */
    @Override
    public int hashCode() {
        return Objects.hash(sku);
    }
}
