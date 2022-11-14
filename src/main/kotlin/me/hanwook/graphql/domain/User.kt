package me.hanwook.graphql.domain

import javax.persistence.*
import javax.persistence.EnumType.STRING
import javax.persistence.GenerationType.IDENTITY

@Entity
@Table(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null,

    @Column(length = 200)
    var name: String? = null,

    @Column(length = 6)
    @Enumerated(STRING)
    var gender: Gender? = null
) {
    fun update(name: String?, gender: Gender?) {
        this.name = name
        this.gender = gender
    }
}