package me.hanwook.graphql.domain

import javax.persistence.*
import javax.persistence.EnumType.STRING
import javax.persistence.FetchType.LAZY
import javax.persistence.GenerationType.IDENTITY

@Entity
class UserFavorite(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null,

    @Column(length = 10)
    @Enumerated(STRING)
    var favoriteType: UserFavoriteType,

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    val user: User
)