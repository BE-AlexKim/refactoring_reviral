package kr.reviral.website.reviral.domain.port.auth.`in`

import kr.reviral.website.reviral.domain.model.JwtToken

/**
 *packageName    : kr.reviral.website.reviral.domain.port.auth.`in`
 * fileName       : AuthUserCase
 * author         : joy58
 * date           : 2025-03-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-18        joy58       최초 생성
 */
interface LoginUseCase {

    fun login(loginId: String, password: String): JwtToken

    fun logout(userId: Long)

}