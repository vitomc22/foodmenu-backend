package com.example.service.food;

import com.example.dto.FoodDTO;
import com.example.model.food.FoodModel;
import com.example.repository.food.FoodRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import java.util.List;
import java.util.stream.Stream;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FoodServiceTest {

    @Mock
    FoodRepository foodRepository;
    FoodDTO foodDTO;
    FoodModel foodModel;
    @InjectMocks
    private FoodService foodService;

    @BeforeEach
    void setUp() {
        foodDTO = new FoodDTO(1L, "Podrão brabo", "teste de imagem", new BigDecimal("32.50"));
        foodModel = new FoodModel(foodDTO);
    }

    @Test
    void findAllMenuItens() {
        when(foodRepository.findAll()).thenReturn(Stream.of(foodModel).toList());
        List<FoodDTO> foodDTOS = foodService.findAllMenuItens();

        assertEquals(Stream.of(foodModel).map(FoodDTO::new).toList(), foodDTOS);
        verify(foodRepository).findAll();
        verifyNoMoreInteractions(foodRepository);

    }

    @Test
    void createFood() {
    }

    @Test
    void findFoodById() {
    }

    @Test
    void findFoodByWrongId() {
        lenient().when(foodRepository.findById(null)).thenThrow(new RuntimeException("Could not find id: null"));
        final RuntimeException e = assertThrows(RuntimeException.class, () -> {
            foodService.findFoodById(null);
        });
        assertEquals(e.getMessage(), ("Could not find id: null"));
    }

    @Test
    void editFood() {
    }

    @Test
    void removeFood() {
    }
}