package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService service;

    @Test
    void testCreateProductPageReturnsView() throws Exception {
        mockMvc.perform(get("/product/create"))
                .andExpect(status().isOk())
                .andExpect(view().name("CreateProduct"))
                .andExpect(model().attributeExists("product"));
    }

    @Test
    void testCreateProductPostRedirectsToList() throws Exception {
        mockMvc.perform(post("/product/create")
                        .param("productName", "Test")
                        .param("productQuantity", "10"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("list"));

        verify(service, times(1)).create(any(Product.class));
    }

    @Test
    void testProductListPageReturnsProductListView() throws Exception {
        Product product = new Product();
        product.setProductId("1");

        when(service.findAll()).thenReturn(List.of(product));

        mockMvc.perform(get("/product/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("ProductList"))
                .andExpect(model().attributeExists("products"));

        verify(service, times(1)).findAll();
    }

    @Test
    void testEditProductPageReturnsEditViewWhenProductExists() throws Exception {
        Product product = new Product();
        product.setProductId("1");

        when(service.findProductById("1")).thenReturn(product);

        mockMvc.perform(get("/product/edit/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("EditProduct"))
                .andExpect(model().attributeExists("product"));
    }

    @Test
    void testEditProductPageRedirectsWhenProductNotFound() throws Exception {
        when(service.findProductById("1")).thenReturn(null);

        mockMvc.perform(get("/product/edit/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/product/list"));
    }

    @Test
    void testEditProductPostRedirectsToList() throws Exception {
        mockMvc.perform(post("/product/edit")
                        .param("productId", "1")
                        .param("productName", "Updated")
                        .param("productQuantity", "20"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/product/list"));

        verify(service, times(1)).update(any(Product.class));
    }

    @Test
    void testDeleteProductRedirectsToList() throws Exception {
        mockMvc.perform(get("/product/delete/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/product/list"));

        verify(service, times(1)).deleteById("1");
    }
}