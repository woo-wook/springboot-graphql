package me.hanwook.graphql.repository

import me.hanwook.graphql.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.Optional

interface UserRepository: JpaRepository<User, Long> {
    @Query("""
        select u
          from User u 
          left join fetch u.favorites
         where u.id = :id
    """)
    fun findUser(id: Long): Optional<User>
}