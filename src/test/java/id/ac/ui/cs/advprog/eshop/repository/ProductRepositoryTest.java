package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {

    Product product;
    Product product1;
    Product product2;

    @InjectMocks
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-9990-71af6af63bd6");
        product1.setProductName("Sampo Cap Acid");
        product1.setProductQuantity(500);
        productRepository.create(product1);

        product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde90b9");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);
    }

    @Test
    void testCreateAndFindID() {
        Iterator<Product> productIterator = productRepository.findAll();
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
    }
    @Test
    void testCreateAndFindName() {
        Iterator<Product> productIterator = productRepository.findAll();
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductName(), savedProduct.getProductName());
    }
    @Test
    void testCreateAndFindQuantity() {
        Iterator<Product> productIterator = productRepository.findAll();
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> productIterator = productRepository.findAll();
        productRepository.deleteById(product.getProductId());
        productRepository.deleteById(product1.getProductId());
        productRepository.deleteById(product2.getProductId());
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        Iterator<Product> productIterator = productRepository.findAll();
        productIterator.next();
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
    }
    @Test
    void testNextNullProduct() {
        Iterator<Product> productIterator = productRepository.findAll();
        productIterator.next(); productIterator.next(); productIterator.next();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testEditProduct() {
        product.setProductName("Sigma Cap Alpha");
        productRepository.update(product);
        Product updatedProduct = productRepository.findProductById(product.getProductId());
        assertEquals("Sigma Cap Alpha", updatedProduct.getProductName());
    }

    @Test
    void testDeleteProduct() {
        productRepository.deleteById(product.getProductId());
        Product getProductFromRepo = productRepository.findProductById(product.getProductId());
        assertNull(getProductFromRepo);
    }

    @Test
    void testFindProductByIDNull() {
        assertNull(productRepository.findProductById("abc"));
    }

    @Test
    void testFindProductByIDNullTwo() {
        assertNull(productRepository.findProductById(null));
    }

    @Test
    void testUpdateProductNull() {
        Product productX = new Product();
        productX.setProductId("eb558e9f");
        productX.setProductName("Sampo");
        productX.setProductQuantity(1);

        assertNull(productRepository.update(productX));
    }

    @Test
    void testDeleteProductBasedNull() {
        productRepository.deleteById(null);
    }

    @Test
    void testDeleteProductBasedEmptyRepo() {
        productRepository.deleteById(product.getProductId());
        productRepository.deleteById(product1.getProductId());
        productRepository.deleteById(product2.getProductId());
        productRepository.deleteById("abc");
    }

    @Test
    void testDeleteProductNotInRepo() {
        Product productX = new Product();
        productX.setProductId("eb558e9f");
        productX.setProductName("Sampo");
        productX.setProductQuantity(1);
        productRepository.create(productX);

        productRepository.deleteById("123123");
    }

}