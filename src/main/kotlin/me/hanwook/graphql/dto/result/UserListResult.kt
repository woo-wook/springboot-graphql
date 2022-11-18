package me.hanwook.graphql.dto.result

import me.hanwook.graphql.domain.User

data class UserListResult(
    val id: Long?,
    val name: String?
) {
    companion object {
        fun from(user: User) =
            UserListResult(
                user.id,
                user.name
            )
    }
}