package com.example.model.food;

import com.example.dto.FoodDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Table(name = "foods")
@Entity(name = "foods")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class FoodModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private BigDecimal price;

    public FoodModel(FoodDTO foodDTO) {
        this.name = foodDTO.name();
        this.image = foodDTO.image();
        this.price = foodDTO.price();
    }
}
