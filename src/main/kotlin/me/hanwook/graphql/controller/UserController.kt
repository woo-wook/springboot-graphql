package me.hanwook.graphql.controller

import me.hanwook.graphql.domain.Gender
import me.hanwook.graphql.service.UserService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class UserController(val userService: UserService) {

    @QueryMapping
    fun getUsers() = userService.getUsers()

    @MutationMapping
    fun createUser(@Argument("name") name: String?, @Argument("gender") gender: Gender?) =
        userService.createUser(name, gender)

    @MutationMapping
    fun updateUser(@Argument("id") id: Long, @Argument("name") name: String?, @Argument("gender") gender: Gender?) =
        userService.updateUser(id, name, gender)
}