package org.food.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional
import org.food.entity.Food

@ApplicationScoped
@Transactional
class FoodRepository: PanacheRepository<Food> {
}