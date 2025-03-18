package kr.reviral.website.reviral.application.auth

import kr.reviral.website.reviral.domain.model.JwtToken
import kr.reviral.website.reviral.domain.port.auth.`in`.LoginUseCase
import org.springframework.stereotype.Service

/**
 *packageName    : kr.reviral.website.reviral.application.auth
 * fileName       : AuthService
 * author         : joy58
 * date           : 2025-03-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-18        joy58       최초 생성
 */
@Service
class AuthService: LoginUseCase {


    override fun login(loginId: String, password: String): JwtToken {
        TODO("Not yet implemented")
    }

    override fun logout(userId: Long) {
        TODO("Not yet implemented")
    }

}