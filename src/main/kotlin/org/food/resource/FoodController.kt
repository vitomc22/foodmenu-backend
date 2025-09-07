package org.food.resource

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.ws.rs.DELETE
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.PUT
import jakarta.ws.rs.Path
import jakarta.ws.rs.core.Response
import org.food.entity.Food
import org.food.service.FoodService

@ApplicationScoped
@Path("/food")
class FoodController {
    @Inject
    lateinit var foodService: FoodService


    @GET
    fun getAllFoods(): Response {
        return Response.ok(foodService.getAllFoods()).build()
    }

    @POST
    fun createFood(food: Food): Response {
        foodService.createFood(food)
        return Response.status(Response.Status.CREATED).build()
    }

    @DELETE
    @Path("/{id}")
    fun deleteFood(id: Long): Response {
        foodService.deleteFood(id)
        return Response.status(Response.Status.NO_CONTENT).build()
    }

    @PUT
    fun updateFood(food: Food): Response {
        foodService.updateFood(food)
        return Response.status(Response.Status.OK).build()
    }

}