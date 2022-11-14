package me.hanwook.graphql.repository

import me.hanwook.graphql.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long>