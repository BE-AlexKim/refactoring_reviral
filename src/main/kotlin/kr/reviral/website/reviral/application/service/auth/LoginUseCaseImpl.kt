package kr.reviral.website.reviral.application.service.auth

import kr.reviral.website.reviral.adapter.`in`.auth.dto.request.RequestLoginDTO
import kr.reviral.website.reviral.application.usecase.auth.LoginUseCase
import kr.reviral.website.reviral.domain.model.JwtToken
import kr.reviral.website.reviral.domain.service.login.LoginStrategyFilter
import org.springframework.stereotype.Service

/**
 *packageName    : kr.reviral.website.reviral.application.auth
 * fileName       : LoginService
 * author         : joy58
 * date           : 2025-03-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-25        joy58       최초 생성
 */
@Service
class LoginUseCaseImpl(
    private val loginStrategyFilter: LoginStrategyFilter
): LoginUseCase {

    override fun login(request: RequestLoginDTO): JwtToken {
        return loginStrategyFilter.login(request)
    }

    override fun logout(userId: Long) {
        TODO("Not yet implemented")
    }
}