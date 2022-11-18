package me.hanwook.graphql.dto.param

import me.hanwook.graphql.domain.Gender

data class UserCreateParam(
    val name: String,

    val gender: Gender,


)