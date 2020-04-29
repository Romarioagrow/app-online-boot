package app.onlineboot.controllers;
import app.onlineboot.data.Product;
import app.onlineboot.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Log
@org.springframework.web.bind.annotation.RestController
@AllArgsConstructor
@RequestMapping("/api")
public class RestController {
    private final ProductService productService;


    @GetMapping("/products")
    public Iterable<Product> sendAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/products/{productID}")
    public Iterable<Product> saveProduct(@PathVariable Long productID, @RequestBody Map<String, String> productData) {
        return productService.saveProduct(productID, productData);
    }

}
