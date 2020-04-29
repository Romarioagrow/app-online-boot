package app.onlineboot.services;

import app.onlineboot.data.Product;
import app.onlineboot.repos.ProductRepo;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.Map;

@Log
@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;

    public Iterable<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Iterable<Product> saveProduct(Long productID, Map<String, String> productData) {

        if (productRepo.findById(productID).isPresent()) {
            log.info("Product already exists!");
            return null;
        }

        String productName = productData.get("productName");
        String productType = productData.get("productType");
        String productInfo = productData.get("productInfo");
        Integer productPrice = Integer.parseInt(productData.get("productPrice"));

        Product product = new Product(productID);
        product.setProductName(productName);
        product.setProductType(productType);
        product.setProductInfo(productInfo);
        product.setProductPrice(productPrice);

        productRepo.save(product);
        log.info("Product saved: " + product.toString());
        return productRepo.findAll();
    }

    /*private Product constructProduct(Map<String, String> productData) {
        return null;
    }*/
}
