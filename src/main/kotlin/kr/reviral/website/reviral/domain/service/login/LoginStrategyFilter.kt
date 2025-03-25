package kr.reviral.website.reviral.domain.service.login

import kr.reviral.website.reviral.adapter.`in`.auth.dto.request.RequestLoginDTO
import kr.reviral.website.reviral.domain.model.JwtToken
import kr.reviral.website.reviral.domain.port.auth.`in`.LoginStrategy
import org.springframework.stereotype.Component

/**
 *packageName    : kr.reviral.website.reviral.application.auth
 * fileName       : LoginServiceFilter
 * author         : joy58
 * date           : 2025-03-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-25        joy58       최초 생성
 */
@Component
class LoginStrategyFilter(
    private val loginStrategy: List<LoginStrategy>
) {

    fun login(request: RequestLoginDTO): JwtToken {
        val strategy = loginStrategy.find { it.support(request) }
            ?: throw Exception()
        return strategy.login(request)
    }

}