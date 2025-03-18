package kr.reviral.website.reviral.adapter.out.persistence.user.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

/**
 *packageName    : kr.reviral.website.reviral.adapter.out.persistence.user.entity
 * fileName       : User
 * author         : joy58
 * date           : 2025-03-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-18        joy58       최초 생성
 */
@Entity
class UserEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}