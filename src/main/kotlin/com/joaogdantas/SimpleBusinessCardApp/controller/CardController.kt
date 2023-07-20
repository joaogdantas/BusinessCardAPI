package com.joaogdantas.SimpleBusinessCardApp.controller

import com.joaogdantas.SimpleBusinessCardApp.controller.dto.CardDTO
import com.joaogdantas.SimpleBusinessCardApp.domain.model.Card
import com.joaogdantas.SimpleBusinessCardApp.service.CardService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.util.UUID

@RestController
@RequestMapping("/card")
class CardController(private val cardService: CardService) {

    @PostMapping
    fun create(@RequestBody cardDTO: CardDTO): ResponseEntity<CardDTO> {
        val card = cardService.create(cardDTO.toModel())
        val location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(card.id)
                .toUri()
        return ResponseEntity.created(location).body(CardDTO(card))
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<CardDTO>> {
        val cards = cardService.findAll()
        val cardsDto = cards.map { CardDTO(it) }
        return ResponseEntity.ok(cardsDto)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: UUID): ResponseEntity<CardDTO> {
        val card = cardService.findById(id)
        return ResponseEntity.ok(CardDTO(card))
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: UUID, @RequestBody cardDTO: CardDTO): ResponseEntity<String> {
        val card = cardService.update(id, cardDTO.toModel())
        return ResponseEntity.status(HttpStatus.OK).body("Card atualizado com sucesso!")
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: UUID): ResponseEntity<String> {
        cardService.delete(id)
        return ResponseEntity.status(HttpStatus.OK).body("Card deletado com sucesso!")
    }
}