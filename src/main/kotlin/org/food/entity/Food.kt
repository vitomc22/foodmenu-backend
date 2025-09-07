package org.food.entity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotBlank

@Entity
data class Food(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @NotBlank(message = "Name can not be blank")
    var name: String,

    var price: Double,

    @Column(length = 1024)
    var image: String
) {
    constructor() : this(0,"",0.0,"")
}
