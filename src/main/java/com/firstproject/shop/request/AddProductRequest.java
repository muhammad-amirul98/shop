package com.firstproject.shop.request;

import com.firstproject.shop.model.Category;
import lombok.Data;

import java.math.BigDecimal;

@Data //should only be used on non-entities
public class AddProductRequest {
    private Long id;
    private String name;
    private String brand;
    private String description;
    private BigDecimal price;
    private int inventory;
    private Category category;
}
