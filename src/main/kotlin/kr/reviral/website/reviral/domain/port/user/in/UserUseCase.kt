package kr.reviral.website.reviral.domain.port.user.`in`

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
interface UserUseCase {

    fun save()

    fun getUserInfo(userId: Long): User

    fun delete(userId: Long)

}