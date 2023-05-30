package me.hanwook.graphql.config

import me.hanwook.graphql.domain.Gender
import me.hanwook.graphql.domain.User
import me.hanwook.graphql.domain.UserFavorite
import me.hanwook.graphql.domain.UserFavoriteType
import me.hanwook.graphql.repository.UserRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import javax.annotation.PostConstruct
import kotlin.random.Random

@Component
class InitDataConfig(
    val userRepository: UserRepository
) {

    @PostConstruct
    @Transactional
    fun init() {
        val names = arrayListOf("Woo", "Wook", "Ryu")
        val random = Random.Default
        val genders = Gender.values()
        val favoriteTypes = UserFavoriteType.values()

        for (i in 1..30) {
            val user = User(name = names.random(), gender = genders[random.nextInt(genders.size)])

            for (j in 0..random.nextInt(favoriteTypes.size)) {
                UserFavorite(user = user, favoriteType = favoriteTypes[j])
            }

            userRepository.save(user)
        }
    }
}