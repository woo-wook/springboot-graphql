package me.hanwook.graphql.dto.param

import me.hanwook.graphql.domain.Gender
import me.hanwook.graphql.domain.UserFavoriteType

data class UserCreateParam(
    val name: String,

    val gender: Gender,

    val favorites: List<UserFavoriteType>?
)