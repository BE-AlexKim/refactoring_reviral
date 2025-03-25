package kr.reviral.website.reviral.domain.port.user.`in`

import kr.reviral.website.reviral.adapter.`in`.user.dto.request.RequestSignUp
import kr.reviral.website.reviral.adapter.`in`.user.dto.response.ResponseUserInfo
import kr.reviral.website.reviral.domain.entity.UserEntity
import kr.reviral.website.reviral.domain.model.User

/**
 *packageName    : kr.reviral.website.reviral.domain.port.user.`in`
 * fileName       : UserUseCase
 * author         : joy58
 * date           : 2025-03-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-18        joy58       최초 생성
 */
interface UserService {

    fun save(request: RequestSignUp): ResponseUserInfo

    fun getUserInfo(userId: Long): UserEntity

    fun delete(userId: Long)

}