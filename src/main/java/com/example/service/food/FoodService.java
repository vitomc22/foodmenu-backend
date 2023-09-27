package com.example.service.food;

import com.example.dto.FoodDTO;
import com.example.model.food.FoodModel;
import com.example.repository.food.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<FoodDTO> findAllMenuItens() {
        return foodRepository.findAll().stream().map(FoodDTO::new).toList();
    }

    public void createFood(FoodDTO foodDTO) {
        foodRepository.save(new FoodModel(foodDTO));
    }

    public FoodDTO findFoodById(Long id) {
        return foodRepository.findById(id).map(FoodDTO::new).orElseThrow(() -> new RuntimeException("Could not find id: " + id));

    }

    public void editFood(FoodDTO foodDTO){
         FoodModel oldFoodModel =  foodRepository.findById(foodDTO.id()).orElseThrow(() -> new RuntimeException("Could not find: " + foodDTO.name()));
         oldFoodModel.setName(foodDTO.name());
         oldFoodModel.setPrice(foodDTO.price());
         oldFoodModel.setImage(foodDTO.image());
         foodRepository.save(oldFoodModel);

    }

    public void removeFood(Long id) {
        FoodModel foodModel = foodRepository.findById(id).orElseThrow(() -> new RuntimeException("Could not find id: " +id));
        foodRepository.deleteById(foodModel.getId());

    }
}
