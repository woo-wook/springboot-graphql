package me.hanwook.graphql.dto.result

import me.hanwook.graphql.domain.User

/**
 * 설명:
 *
 * @author 유한욱(Doyle) / hanwook.ryu@dreamus.io
 * @since 2022/11/18
 */
data class UserListResult(
    val id: Long?,
    val name: String?
) {
    companion object {
        fun from(user: User) = UserListResult(user.id, user.name)
    }
}