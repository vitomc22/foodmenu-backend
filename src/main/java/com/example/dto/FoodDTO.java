package com.example.dto;


import com.example.model.food.FoodModel;

import java.math.BigDecimal;


public record FoodDTO(Long id, String name, String image, BigDecimal price) {
    public FoodDTO(FoodModel foodModel) {
        this(foodModel.getId(), foodModel.getName(), foodModel.getImage(), foodModel.getPrice());

    }


}
