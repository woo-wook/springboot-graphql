package me.hanwook.graphql.dto.result

import me.hanwook.graphql.domain.Gender
import me.hanwook.graphql.domain.User

data class UserResult(
    val id: Long?,
    val name: String?,
    val gender: Gender?,
    val userFavorites: List<UserFavoriteResult>
) {
    companion object {
        fun from(user: User) = UserResult(user.id, user.name, user.gender, user.favorites.map(UserFavoriteResult::from))
    }
}