package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private String name;
    @JsonProperty("short_description")
    private String shortDescription;
    private Long price;
    private Integer stock;
    private Integer sold;
    @JsonProperty("brand_name")
    private String brandName;
    @JsonProperty("brand_slug")
    private String brandSlug;
}
