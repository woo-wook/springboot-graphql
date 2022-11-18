package me.hanwook.graphql.dto.result

import me.hanwook.graphql.domain.Gender
import me.hanwook.graphql.domain.User

/**
 * 설명:
 *
 * @author 유한욱(Doyle) / hanwook.ryu@dreamus.io
 * @since 2022/11/18
 */
data class UserResult(
    val id: Long?,
    val name: String?,
    val gender: Gender?
) {
    companion object {
        fun from(user: User) = UserResult(user.id, user.name, user.gender)
    }
}