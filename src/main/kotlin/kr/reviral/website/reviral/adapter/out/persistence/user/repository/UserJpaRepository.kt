package kr.reviral.website.reviral.adapter.out.persistence.user.repository

import kr.reviral.website.reviral.adapter.out.persistence.user.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

/**
 *packageName    : kr.reviral.website.reviral.adapter.out.persistence.user.repository
 * fileName       : JpaUserRepository
 * author         : joy58
 * date           : 2025-03-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-18        joy58       최초 생성
 */
interface UserJpaRepository: JpaRepository<UserEntity,Long> {
}