package kr.reviral.website.reviral.application.oauth

import kr.reviral.website.reviral.adapter.out.persistence.oauth.OAuthServiceAdaptor
import kr.reviral.website.reviral.adapter.out.persistence.oauth.dto.OAuthToken
import kr.reviral.website.reviral.adapter.out.persistence.oauth.dto.ResponseOAuthUserInfo
import kr.reviral.website.reviral.domain.model.Registration
import kr.reviral.website.reviral.domain.port.auth.`in`.OAuthProvider
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
class OAuthProviderImpl(
    private val oAuthServiceAdaptors: List<OAuthServiceAdaptor>
): OAuthProvider {

    override fun getRedirectUri(provider: Registration): String {
        val adaptor = oAuthServiceAdaptors.find { it.support(provider) }
            ?: throw Exception("지원하지 않는 요청입니다.")

        return adaptor.redirectUri()
    }

    override fun getAccessToken(code: String, provider: Registration): OAuthToken? {
        val adaptor = oAuthServiceAdaptors.find { it.support(provider) }
            ?: throw Exception("지원하지 않는 요청입니다.")
        return adaptor.getAccessToken(code)
    }

    override fun getUserInfo(oAuthToken: OAuthToken): ResponseOAuthUserInfo? {
        val adaptor = oAuthServiceAdaptors.find { it.support(oAuthToken.getProvider()) }
            ?: throw Exception("지원하지 않는 요청입니다.")

        return adaptor.getUserInfo(oAuthToken)
    }

    override fun unlink() {
        TODO("Not yet implemented")
    }
}