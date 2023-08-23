package ru.werest.hibernatetask.service;

import org.springframework.stereotype.Service;
import ru.werest.hibernatetask.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<String> getProduct(String productName) {
        return repository.getProduct(productName);
    }
}
