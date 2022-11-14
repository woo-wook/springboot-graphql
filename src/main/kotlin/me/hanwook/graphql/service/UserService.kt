package me.hanwook.graphql.service

import me.hanwook.graphql.domain.Gender
import me.hanwook.graphql.domain.User
import me.hanwook.graphql.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) {

    fun getUsers(): List<User> = userRepository.findAll()

    fun getUser(id: Long) =
        userRepository.findById(id).orElseThrow { throw IllegalArgumentException() }

    fun createUser(name: String?, gender: Gender?) =
        userRepository.save(User(name = name, gender = gender))

    fun updateUser(id: Long, name: String?, gender: Gender?) {
        val user = userRepository.findById(id)
            .orElseThrow { throw IllegalArgumentException() }

        user.update(name, gender)
    }

    fun deleteUser(id: Long) = userRepository.deleteById(id)
}