package me.hanwook.graphql.controller

import me.hanwook.graphql.domain.Gender
import me.hanwook.graphql.dto.param.UserCreateParam
import me.hanwook.graphql.dto.result.UserListResult
import me.hanwook.graphql.dto.result.UserResult
import me.hanwook.graphql.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.graphql.data.method.annotation.*
import org.springframework.stereotype.Controller
import reactor.core.publisher.Flux
import java.time.Duration

@Controller
class UserController(val userService: UserService) {

    private val log = LoggerFactory.getLogger(javaClass)

    @QueryMapping
    fun getUsers(): List<UserListResult> {
        log.info("UserController :: getUsers")
        return userService.getUsers()
    }

    @QueryMapping
    fun getUser(@Argument("id") id: Long): UserResult {
        log.info("UserController :: getUsers")
        return userService.getUser(id)
    }

    @MutationMapping
    fun createUser(@Arguments param: UserCreateParam) =
        userService.createUser(param.name, param.gender, param.favorites)

    @MutationMapping
    fun updateUser(@Argument("id") id: Long, @Argument("name") name: String?, @Argument("gender") gender: Gender?) =
        userService.updateUser(id, name, gender)

    @MutationMapping
    fun deleteUser(@Argument("id") id: Long) = userService.deleteUser(id)

    @SubscriptionMapping
    fun subscribeUsers(): Flux<List<UserListResult>> = Flux.interval(Duration.ofSeconds(2)).map { userService.getUsers() }
}