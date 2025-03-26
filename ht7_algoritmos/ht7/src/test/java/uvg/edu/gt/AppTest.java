package uvg.edu.gt;

import junit.framework.TestCase;

public class AppTest extends TestCase {

    public void testInsertAndSearch() {
        BinarySearchTree<Product> bst = new BinarySearchTree<>();

        Product p1 = new Product("123", 100.0, 90.0, "Fridge", "Electrodomésticos");
        Product p2 = new Product("456", 200.0, 180.0, "Washer", "Electrodomésticos");

        bst.insert(p1);
        bst.insert(p2);

        assertEquals(p1, bst.search(new Product("123")));
        assertEquals(p2, bst.search(new Product("456")));
        assertNull(bst.search(new Product("999")));
    }

    public void testUpdateLowerPrice() {
        BinarySearchTree<Product> bst = new BinarySearchTree<>();

        Product original = new Product("789", 150.0, 130.0, "Dryer", "Electrodomésticos");
        Product cheaper = new Product("789", 150.0, 120.0, "Dryer", "Electrodomésticos");

        bst.insert(original);
        bst.insert(cheaper);

        Product found = bst.search(new Product("789"));
        assertEquals(120.0, found.priceCurrent, 0.001); // <--- fix aquí
    }
}
