package com.example.demo.service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Brand;
import com.example.demo.model.Product;
import com.example.demo.model.Review;
import com.example.demo.repository.BrandRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ProductRepository productRepository;


    @Transactional
    public void createProduct(Integer brandId, ProductDTO productDTO) throws Exception {
        brandRepository.findById(brandId).map(brand -> {
            Product tmpProduct = Product.builder()
                    .name(productDTO.getName())
                    .shortDescription(productDTO.getShortDescription())
                    .price(productDTO.getPrice())
                    .stock(productDTO.getStock())
                    .sold(productDTO.getSold())
                    .brand(brand)
                    .build();
            return productRepository.save(tmpProduct);
        }).orElseThrow(() -> new Exception("Not found brand by id"));
    }

    @Transactional
    public void deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
    }

    public ProductDTO findProductById(Integer productId) throws Exception {
        return productRepository.findById(productId).map(product -> {
            ProductDTO productDTO = ProductDTO.builder()
                    .name(product.getName())
                    .shortDescription(product.getShortDescription())
                    .price(product.getPrice())
                    .stock(product.getStock())
                    .sold(product.getSold())
                    .brandName(product.getBrandName())
                    .brandSlug(product.getBrandSlug())
                    .build();
            return productDTO;
        }).orElseThrow(() -> new Exception("Not found product by id"));
    }
}
