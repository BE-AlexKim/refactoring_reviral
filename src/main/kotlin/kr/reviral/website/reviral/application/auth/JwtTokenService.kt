package kr.reviral.website.reviral.application.auth

import kr.reviral.website.reviral.domain.model.JwtToken
import kr.reviral.website.reviral.domain.port.auth.`in`.JwtTokenUseCase
import org.springframework.stereotype.Service

/**
 *packageName    : kr.reviral.website.reviral.application.auth
 * fileName       : LoginService
 * author         : joy58
 * date           : 2025-03-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-18        joy58       최초 생성
 */
@Service
class JwtTokenService: JwtTokenUseCase {

    override fun reissueByRefreshToken(refreshToken: String): JwtToken {
        TODO("Not yet implemented")
    }
}