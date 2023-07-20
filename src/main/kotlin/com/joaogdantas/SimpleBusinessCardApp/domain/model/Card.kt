package com.joaogdantas.SimpleBusinessCardApp.domain.model

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import java.util.*

@Entity(name = "card")
@Table(name = "cards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
data class Card(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    var id: UUID,

    @Column(name = "company")
    var company: String,

    @Column(name = "name")
    var name: String,

    @Column(name = "phoneNumber")
    var phoneNumber: String,

    @Column(name = "email")
    var email: String,

    @Column(name = "site")
    var site: String,
)
