package org.example.ex5.services;

import org.example.ex5.model.IProduct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    // warning: race status
    private List<IProduct> products = new ArrayList<>();

    public void addProduct(IProduct p) {
        products.add(p);
    }

    public List<IProduct> findAll() {
        return products;
    }
}
