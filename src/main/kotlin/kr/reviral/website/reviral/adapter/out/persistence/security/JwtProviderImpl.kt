package kr.reviral.website.reviral.adapter.out.persistence.security

import kr.reviral.website.reviral.domain.model.JwtToken
import kr.reviral.website.reviral.domain.port.auth.out.JwtProvider
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component

/**
 *packageName    : kr.reviral.website.reviral.adapter.out.persistence.security
 * fileName       : JwtProviderImpl
 * author         : joy58
 * date           : 2025-03-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-18        joy58       최초 생성
 */
@Component
class JwtProviderImpl(

): JwtProvider {

    override fun getToken(): JwtToken {
        TODO("Not yet implemented")
    }

    override fun getAuthentication(): Authentication {
        TODO("Not yet implemented")
    }

    override fun validation() {
        TODO("Not yet implemented")
    }
}