package org.example.ex5.controller;

import org.example.ex5.model.Product;
import org.example.ex5.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductsController {

    private final ProductService prdServ;

    public ProductsController(ProductService prdServ) {

        this.prdServ = prdServ;
    }

    @GetMapping("/products")
    public String viewProducts(Model model) {

        var products = prdServ.findAll();

        model.addAttribute("products", products);

        return "products.html";
    }

    @PostMapping(value = "/products/add")
    public String addProducts(
            @RequestParam String name,
            @RequestParam double price,
            Model model
    ) {

        prdServ.addProduct( new Product(name, price));

        return "redirect:/products";
    }
}
