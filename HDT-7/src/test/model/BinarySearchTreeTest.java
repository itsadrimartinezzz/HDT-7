package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {

    private BinarySearchTree<Product> bst;
    private Product p1, p2, p3;

    @BeforeEach
    public void setUp() {
        bst = new BinarySearchTree<>();
        p1 = new Product("SKU123", 199.99, 149.99, "Refrigerador", "Electrodomésticos");
        p2 = new Product("SKU124", 99.99, 79.99, "Licuadora", "Electrodomésticos");
        p3 = new Product("SKU125", 299.99, 199.99, "Microondas", "Electrodomésticos");
    }   

    @Test
    public void testInsertAndSize() {
        assertEquals(0, bst.size());

        bst.insert(p1);
        assertEquals(1, bst.size());

        bst.insert(p2);
        bst.insert(p3);
        assertEquals(3, bst.size());
    }

    @Test
    public void testSearchBySkuFound() {
        bst.insert(p1);
        bst.insert(p2);
        bst.insert(p3);

        Product result = bst.searchBySku("SKU124");
        assertNotNull(result);
        assertEquals("SKU124", result.getSku());
        assertEquals("Licuadora", result.getName());
    }
    
    @Test
    public void testSearchBySkuNotFound() {
        bst.insert(p1);
        Product result = bst.searchBySku("SKU999");
        assertNull(result);
    }
}
