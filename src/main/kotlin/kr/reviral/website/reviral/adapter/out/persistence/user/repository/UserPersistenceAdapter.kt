package kr.reviral.website.reviral.adapter.out.persistence.user.repository

import kr.reviral.website.reviral.domain.port.user.out.UserRepository
import org.springframework.stereotype.Repository

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



}