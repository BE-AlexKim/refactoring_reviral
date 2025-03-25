package kr.reviral.website.reviral.domain.service.login

import kr.reviral.website.reviral.adapter.`in`.auth.dto.request.RequestLoginDTO
import kr.reviral.website.reviral.adapter.`in`.auth.dto.request.RequestLoginToAdmin
import kr.reviral.website.reviral.config.exception.ReviralException
import kr.reviral.website.reviral.config.exception.message.DefaultErrorMessage
import kr.reviral.website.reviral.domain.model.JwtToken
import kr.reviral.website.reviral.domain.port.auth.`in`.JwtTokenService
import kr.reviral.website.reviral.domain.port.auth.`in`.LoginStrategy

/**
 *packageName    : kr.reviral.website.reviral.application.auth
 * fileName       : AdminLoginService
 * author         : joy58
 * date           : 2025-03-24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-24        joy58       최초 생성
 */

class LoginAdminStrategy(
    private val jwtTokenService: JwtTokenService
): LoginStrategy {

    override fun login(request: RequestLoginDTO): JwtToken {
        require(request is RequestLoginToAdmin ) {
            throw ReviralException(DefaultErrorMessage.AUTH_NOT_ADMIN)
        }

        TODO("어드민 로그인 로직")
    }

    override fun logout(userId: Long) {
        TODO("Not yet implemented")
    }

    override fun support(request: RequestLoginDTO): Boolean = request is RequestLoginToAdmin

}