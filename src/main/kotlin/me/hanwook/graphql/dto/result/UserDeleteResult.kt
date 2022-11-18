package me.hanwook.graphql.dto.result


data class UserDeleteResult(
    val id: Long
) {
    companion object {
        fun from(id: Long) = UserDeleteResult(id)
    }
}