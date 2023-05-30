package me.hanwook.graphql.service

import me.hanwook.graphql.domain.Gender
import me.hanwook.graphql.domain.User
import me.hanwook.graphql.domain.UserFavorite
import me.hanwook.graphql.domain.UserFavoriteType
import me.hanwook.graphql.dto.result.UserDeleteResult
import me.hanwook.graphql.dto.result.UserListResult
import me.hanwook.graphql.dto.result.UserResult
import me.hanwook.graphql.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(val userRepository: UserRepository) {

    @Transactional(readOnly = true)
    fun getUsers(): List<UserListResult> {
        val results = userRepository.findAll()

        return results.map(UserListResult::from)
    }

    @Transactional(readOnly = true)
    fun getUser(id: Long): UserResult =
        UserResult.from(
            userRepository.findUser(id)
                .orElseThrow { throw IllegalArgumentException() }
        )

    @Transactional
    fun createUser(name: String?, gender: Gender?, favorites: List<UserFavoriteType>?): UserResult {
        val user = userRepository.save(User(name = name, gender = gender))

        if(!favorites.isNullOrEmpty()) {
            favorites.forEach { UserFavorite(user = user, favoriteType = it)  }
        }

        return UserResult.from(user)
    }

    @Transactional
    fun updateUser(id: Long, name: String?, gender: Gender?): UserResult {
        val user = userRepository.findById(id)
            .orElseThrow { throw IllegalArgumentException() }

        user.update(name, gender)

        return UserResult.from(user)
    }

    @Transactional
    fun deleteUser(id: Long): UserDeleteResult {
        userRepository.deleteById(id)
        return UserDeleteResult.from(id)
    }
}