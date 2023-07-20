package com.joaogdantas.SimpleBusinessCardApp.controller.dto

import com.joaogdantas.SimpleBusinessCardApp.domain.model.Card
import java.util.*

data class CardDTO(
        val id: UUID,

        val company: String,

        val name: String,

        val phoneNumber: String,

        val email: String,

        val site: String
){
    constructor(model: Card) : this(
            id = model.id,
            company = model.company,
            name = model.name,
            phoneNumber = model.phoneNumber,
            email = model.email,
            site = model.site
    )

    fun toModel(): Card {
        return Card(this.id, this.company, this.name, this.phoneNumber, this.email, this.site)
    }
}
