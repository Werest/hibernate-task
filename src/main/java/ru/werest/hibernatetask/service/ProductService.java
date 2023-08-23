package ru.werest.hibernatetask.service;

import org.springframework.stereotype.Service;
import ru.werest.hibernatetask.repository.OrderRepository;

import java.util.List;

@Service
public class ProductService {
    private final OrderRepository repository;

    public ProductService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<String> getProduct(String productName) {
        return repository.getProduct(productName);
    }
}
