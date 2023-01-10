package com.example.demo.service;

import com.example.demo.dto.BrandDTO;
import com.example.demo.model.Brand;
import com.example.demo.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    @Transactional
    public void createBrand(BrandDTO brandDTO) {
        Brand brand = Brand.builder()
                .name(brandDTO.getName())
                .slug(brandDTO.getSlug()).build();
        brandRepository.save(brand);
    }
}
