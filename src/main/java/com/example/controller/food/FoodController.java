package com.example.controller.food;

import com.example.dto.FoodDTO;
import com.example.service.food.FoodService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodDTO> getAll() {
        return foodService.findAllMenuItens();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createFood(@RequestBody FoodDTO foodDTO) {
        foodService.createFood(foodDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public FoodDTO findFood(@PathVariable Long id) {
        return foodService.findFoodById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping
    public void editFood(@RequestBody FoodDTO foodDTO) {
         foodService.editFood(foodDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void removeFood(@PathVariable Long id) {
        foodService.removeFood(id);
    }

}
