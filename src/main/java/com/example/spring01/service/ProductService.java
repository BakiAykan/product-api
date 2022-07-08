package com.example.spring01.service;

import com.example.spring01.model.Brand;
import com.example.spring01.model.Category;
import com.example.spring01.model.Product;
import com.example.spring01.model.api.ProductCreateRequest;
import com.example.spring01.model.api.ProductResponse;
import com.example.spring01.model.api.ProductUpdateRequest;
import com.example.spring01.model.exceptions.NotFoundException;
import com.example.spring01.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponse getProductById(Long id) {
        Product product = getOrThrow(id);
        return new ProductResponse(product.getId(), product.getName(), product.getBrand().getName(), product.getCategory().getName());
    }

    public void createProduct(ProductCreateRequest request) {
        Product product = new Product();
        product.setId(productRepository.nextProductCount());
        product.setName(request.getName());
        // request'den gelen category id, category tablosundan sorgulanır, yoksa 404 dönülür, varsa setCategory'e setlenir
        product.setCategory(new Category(0L, request.getName()));
        product.setBrand(new Brand(0L, request.getBrand()));
        productRepository.create(product);
    }

    public List<ProductResponse> getProducts() {
        List<Product> products = productRepository.getProducts();
        /*
        List<ProductResponse> productResponses = products
                .stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(), product.getBrand().getName(), product.getCategory().getName()))
                .collect(Collectors.toList());
        */
        List<ProductResponse> prs1 = new ArrayList<>();
        for (Product product : products) {
            prs1.add(new ProductResponse(product.getId(), product.getName(), product.getBrand().getName(), product.getCategory().getName()));
        }
        return prs1;
    }

    public void deleteById(Long id) {
        Product product = getOrThrow(id);
        productRepository.delete(id);
    }

    public void updateProduct(Long id, ProductUpdateRequest request) {
        Product product = getOrThrow(id);
        product.setName(request.getName());
        productRepository.update(product);
    }

    public Product getOrThrow(Long id) {
        Product product = productRepository.getProductById(id);
        if (product == null) {
            throw new NotFoundException("Product not found by id: " + id);
        }
        return product;
    }

}
