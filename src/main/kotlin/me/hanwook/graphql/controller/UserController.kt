package me.hanwook.graphql.controller

import me.hanwook.graphql.domain.Gender
import me.hanwook.graphql.dto.param.UserCreateParam
import me.hanwook.graphql.service.UserService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.Arguments
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class UserController(val userService: UserService) {

    @QueryMapping
    fun getUsers() = userService.getUsers()

    @QueryMapping
    fun getUser(@Argument("id") id: Long) = userService.getUser(id)

    @MutationMapping
    fun createUser(@Arguments param: UserCreateParam) =
        userService.createUser(param.name, param.gender)

    @MutationMapping
    fun updateUser(@Argument("id") id: Long, @Argument("name") name: String?, @Argument("gender") gender: Gender?) =
        userService.updateUser(id, name, gender)

    @MutationMapping
    fun deleteUser(@Argument("id") id: Long) = userService.deleteUser(id)
}