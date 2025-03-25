package kr.reviral.website.reviral.application.service.oauth

import kr.reviral.website.reviral.adapter.out.persistence.oauth.OAuthServiceFilter
import kr.reviral.website.reviral.adapter.out.persistence.oauth.dto.ResponseOAuthUserInfo
import kr.reviral.website.reviral.domain.enums.Registration
import kr.reviral.website.reviral.domain.port.auth.`in`.OAuthService
import org.springframework.stereotype.Service

/**
 *packageName    : kr.reviral.website.reviral.application.oauth
 * fileName       : OAuthKakaoService
 * author         : joy58
 * date           : 2025-03-24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-24        joy58       최초 생성
 */
@Service
class OAuthServiceImpl(
    private val oAuthServiceFilter: OAuthServiceFilter
): OAuthService {

    override fun getRedirectUri(provider: Registration): String {
        return oAuthServiceFilter.getRedirectUri(provider)
    }

    override fun callback(code: String, provider: Registration): ResponseOAuthUserInfo {
        val accessToken = oAuthServiceFilter.getAccessToken(code, provider)
            ?: throw Exception("${provider.name.lowercase()} token not found.")

        return oAuthServiceFilter.getUserInfo(accessToken)
            ?: throw Exception("${provider.name.lowercase()} no return user information.")
    }

    override fun unlink() {
        TODO("Not yet implemented")
    }
}