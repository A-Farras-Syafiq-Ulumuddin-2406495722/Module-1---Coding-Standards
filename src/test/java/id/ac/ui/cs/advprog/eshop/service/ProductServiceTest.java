package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl productService;

    Product product;

    @BeforeEach
    void setUp() {
        product = new Product();
        product.setProductId("asigma-mantap");
        product.setProductName("begitukah king");
        product.setProductQuantity(10);
    }

    @Test
    void testCreateProductReturnsProduct() {
        Product result = productService.create(product);

        verify(productRepository, times(1)).create(product);
        assertEquals(product, result);
    }

    @Test
    void testFindAllReturnsProductList() {
        List<Product> mockList = Collections.singletonList(product);
        Iterator<Product> iterator = mockList.iterator();

        when(productRepository.findAll()).thenReturn(iterator);

        List<Product> result = productService.findAll();

        assertEquals(1, result.size());
        assertEquals(product, result.getFirst()); // safer than getFirst()
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testUpdateReturnsUpdatedProduct() {
        Product result = productService.update(product);

        verify(productRepository, times(1)).update(product);
        assertEquals(product, result);
    }

    @Test
    void testFindProductByIdReturnsProduct() {
        when(productRepository.findProductById("asigma-mantap")).thenReturn(product);

        Product result = productService.findProductById("asigma-mantap");

        assertEquals(product, result);
        verify(productRepository, times(1)).findProductById("asigma-mantap");
    }

    @Test
    void testDeleteByIdCallsRepository() {
        productService.deleteById("asigma-mantap");

        verify(productRepository, times(1)).deleteById("asigma-mantap");
    }
}