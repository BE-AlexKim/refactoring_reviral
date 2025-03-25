package kr.reviral.website.reviral.domain.port.user.out

import kr.reviral.website.reviral.adapter.`in`.user.dto.response.ResponseUserInfo
import kr.reviral.website.reviral.domain.entity.UserEntity

/**
 *packageName    : kr.reviral.website.reviral.domain.port.out
 * fileName       : Repository
 * author         : joy58
 * date           : 2025-03-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-18        joy58       최초 생성
 */
interface UserRepository {

    fun findAll(): MutableList<UserEntity>

    fun findById(userId: Long): UserEntity

    fun save(user: UserEntity): UserEntity

    fun deleteByUserId(userId: Long)

    fun findUserAndUserInfoByUserId(userId: Long): ResponseUserInfo

}