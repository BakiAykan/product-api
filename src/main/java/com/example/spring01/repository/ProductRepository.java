package com.example.spring01.repository;

import com.example.spring01.model.Brand;
import com.example.spring01.model.Category;
import com.example.spring01.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private final Map<Long, Product> productsTable;

    public ProductRepository() {
        productsTable = new HashMap<>();
        productsTable.put(1L, new Product(1L, "Iphone", new Brand(1L, "Apple"), new Category(1L, "Telefon")));
    }

    public Product getProductById(Long id) {
        return productsTable.get(id);
    }

    public void create(Product product) {
        productsTable.put(nextProductCount(), product);
    }

    public Long nextProductCount() {
        return (long) (productsTable.size() + 1);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(productsTable.values());
    }

    public void delete(Long id) {
        productsTable.remove(id);
    }

    public void update(Product product) {
        productsTable.put(product.getId(), product);
    }
}
