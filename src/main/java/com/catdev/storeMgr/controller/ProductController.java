package com.catdev.storeMgr.controller;

import com.catdev.storeMgr.exception.ResourceNotFoundException;
import com.catdev.storeMgr.model.Product;
import com.catdev.storeMgr.repository.ProductRepository;
import com.catdev.storeMgr.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    StoreRepository storeRepository;

    @GetMapping("/api/products/trail")
    public String allAccess() {
        return "Im on the PRODUCT CONTROLLER.";
    }
    @GetMapping("/api/stores/{storeId}/products")
    public Page<Product> getAllProducts(@PathVariable Long storeId, Pageable pageable) {
        return productRepository.findByStoreId(storeId, pageable);
    }

    @GetMapping("/api/stores/{storeId}/products/{productId}")
    public Product getProduct(@PathVariable Long storeId, @PathVariable Long productId) {
        return productRepository.findByIdAndStoreId(productId, storeId)
                .orElseThrow(()-> new ResourceNotFoundException("Product " + productId + " not found"));
    }

    @PostMapping("/api/stores/{storeId}/products/")
    public Product createProduct(@PathVariable Long storeId, @Valid @RequestBody Product newProduct) {
        return storeRepository.findById(storeId).map(store -> {
            newProduct.setStore(store);
            return productRepository.save(newProduct);
        }).orElseThrow(()-> new ResourceNotFoundException("Store " + storeId + " not found."));
    }

    @PutMapping("/api/stores/{storeId}/products/{productId}")
    public Product updateProduct(@PathVariable Long storeId, @PathVariable Long productId, @Valid @RequestBody Product newProduct) {
        if(!storeRepository.existsById(storeId)){
            throw new ResourceNotFoundException("Store " + storeId + " not found.");
        }
        return productRepository.findById(productId).map(product ->{
            product.setName(newProduct.getName());
            return productRepository.save(product);
        }).orElseThrow(() -> new ResourceNotFoundException("Product " + productId + " not found."));
    }

    @DeleteMapping("/api/stores/{storeId}/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long storeId, @PathVariable Long productId) {
        return productRepository.findByIdAndStoreId(productId, storeId).map(product -> {
            productRepository.delete(product);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Product not found with productId " + productId + " and storeId " + storeId));
    }

}
