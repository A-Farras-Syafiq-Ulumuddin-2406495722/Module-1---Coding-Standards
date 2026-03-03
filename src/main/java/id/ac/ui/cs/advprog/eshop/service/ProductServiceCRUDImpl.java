package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceCRUDImpl implements ServiceCRUD<Product>{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        productRepository.create(product);
        return product;
    }

    @Override
    public void update(String productId, Product updatedProduct) {
        productRepository.update(updatedProduct);
    }

    @Override
    public void deleteById(String id) {
        productRepository.deleteById(id);
    }
}
