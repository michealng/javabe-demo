package com.example.demo.controller;

import com.example.demo.dto.BrandDTO;
import com.example.demo.model.Brand;
import com.example.demo.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brands")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @PostMapping
    public ResponseEntity createBrand(@RequestBody BrandDTO brandDTO) {
        brandService.createBrand(brandDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
