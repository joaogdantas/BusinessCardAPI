package com.joaogdantas.SimpleBusinessCardApp.domain.repository

import com.joaogdantas.SimpleBusinessCardApp.domain.model.Card
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CardRepository : JpaRepository<Card, UUID> {
}