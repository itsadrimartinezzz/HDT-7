package model;

/**
 * Representa un producto con SKU, precios, nombre y categoría.
 */
public class Product implements Comparable<Product> {
    private String sku;
    private double priceRetail;
    private double priceCurrent;
    private String name;
    private String category;

    public Product(String sku, double priceRetail, double priceCurrent, String name, String category) {
        this.sku = sku;
        this.priceRetail = priceRetail;
        this.priceCurrent = priceCurrent;
        this.name = name;
        this.category = category;
    }

    public String getSku() { return sku; }
    public double getPriceRetail() { return priceRetail; }
    public double getPriceCurrent() { return priceCurrent; }
    public String getName() { return name; }
    public String getCategory() { return category; }

    @Override
    public int compareTo(Product other) {
        return this.sku.compareTo(other.sku);
    }

    @Override
public String toString() {
    return "SKU: " + sku + "\n" +
           "Precio Retail: $" + priceRetail + "\n" +
           "Precio Actual: $" + priceCurrent + "\n" +
           "Nombre: " + name + "\n" +
           "Categoría: " + category;
}
}
