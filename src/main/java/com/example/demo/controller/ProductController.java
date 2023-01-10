package com.example.demo.controller;

import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/{brand_id}")
    public ResponseEntity createProduct(@PathVariable("brand_id") Integer brandId, @RequestBody ProductDTO productDTO) throws Exception {
        productService.createProduct(brandId, productDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/{product_id}")
    public ResponseEntity deleteProduct(@PathVariable("product_id") Integer productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<ProductDTO> findProductById(@PathVariable("product_id") Integer productId) throws Exception {
        ProductDTO productDTO = productService.findProductById(productId);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }
}
