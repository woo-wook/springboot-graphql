package me.hanwook.graphql.dto.result

import me.hanwook.graphql.domain.UserFavorite
import me.hanwook.graphql.domain.UserFavoriteType


data class UserFavoriteResult(
    val favoriteType: UserFavoriteType
) {
    companion object {
        fun from(userFavorite: UserFavorite) = UserFavoriteResult(userFavorite.favoriteType)
    }
}