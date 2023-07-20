package com.joaogdantas.SimpleBusinessCardApp.service

import com.joaogdantas.SimpleBusinessCardApp.domain.model.Card
import org.springframework.stereotype.Service
import java.util.*

@Service
interface CardService : CrudService<Card, UUID> {
}