package kr.reviral.website.reviral.adapter.out.persistence.user

import kr.reviral.website.reviral.domain.entity.UserEntity
import kr.reviral.website.reviral.domain.port.user.out.UserRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

/**
 *packageName    : kr.reviral.website.reviral.adapter.out.persistence.user.repository
 * fileName       : UserPersistenceAdapter
 * author         : joy58
 * date           : 2025-03-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-18        joy58       최초 생성
 */
@Repository
class UserPersistenceAdapter constructor(
    private val userJpaRepository: UserJpaRepository
): UserRepository {

    override fun findAll(): MutableList<UserEntity> {
        return userJpaRepository.findAll()
    }

    override fun findById(userId: Long): UserEntity {
        return userJpaRepository.findById(userId).orElseThrow {
            throw Exception("User Not Found")
        }
    }

    @Transactional
    override fun save(user: UserEntity): UserEntity {
        return userJpaRepository.save(user)
    }
}