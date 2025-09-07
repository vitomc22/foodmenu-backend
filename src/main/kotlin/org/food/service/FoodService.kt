package org.food.service

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import org.food.entity.Food
import org.food.repository.FoodRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@ApplicationScoped
class FoodService {

    @Inject
    lateinit var foodRepository: FoodRepository

    companion object {
        private val LOG: Logger = LoggerFactory.getLogger(FoodService::class.java)
    }

    fun getAllFoods(): List<Food> {
        LOG.info("Getting all foods")
        return foodRepository.findAll().list()
    }

    fun createFood(food: Food) {
        LOG.info("Creating food {}", food)
        foodRepository.persist(food)
    }

    fun deleteFood(id: Long) {
        LOG.info("Deleting food {}", id)
        foodRepository.deleteById(id)
    }

    @Transactional
    fun updateFood(food: Food) {
        var oldFood = foodRepository.findById(food.id) ?: return createFood(food)
        LOG.info("Updating food {}", food)
        oldFood.name= food.name
        oldFood.price = food.price
        oldFood.image = food.image
        return foodRepository.flush()
    }
}