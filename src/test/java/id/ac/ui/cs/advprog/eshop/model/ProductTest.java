package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class ProductTest {
    Product product;
    @BeforeEach
    void setUp() {
        this.product = new Product();
        this.product.setProductId("eb558e9f-eak-mantap-gaes-71af6af63bd6");
        this.product.setProductName("Ayam Geprek Silvanna");
        this.product.setProductQuantity(500);
    }

    @Test
    void testGetProductId() {
        assertEquals("eb558e9f-eak-mantap-gaes-71af6af63bd6", this.product.getProductId());
        assertNotEquals("eb558e9f-eak-mantap-gaes-begitulah", this.product.getProductId());
    }
    @Test
    void testGetProductName() {
        assertEquals("Ayam Geprek Silvanna", this.product.getProductName());
        assertNotEquals("Ayam", this.product.getProductName());
    }
    @Test
    void testGetProductQuantity() {
        assertEquals(500, this.product.getProductQuantity());
        assertNotEquals(250, this.product.getProductQuantity());
    }

}
