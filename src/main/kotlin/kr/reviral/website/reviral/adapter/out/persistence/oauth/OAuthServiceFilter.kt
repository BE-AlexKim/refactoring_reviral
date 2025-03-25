package kr.reviral.website.reviral.adapter.out.persistence.oauth

import kr.reviral.website.reviral.adapter.out.persistence.oauth.dto.OAuthToken
import kr.reviral.website.reviral.adapter.out.persistence.oauth.dto.ResponseOAuthUserInfo
import kr.reviral.website.reviral.domain.enums.Registration
import org.springframework.stereotype.Component

/**
 *packageName    : kr.reviral.website.reviral.adapter.out.persistence.oauth
 * fileName       : OAuthServiceFilter
 * author         : joy58
 * date           : 2025-03-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-25        joy58       최초 생성
 */
@Component
class OAuthServiceFilter(
    private val oAuthServiceAdaptors: List<OAuthServiceAdaptor>
) {

    fun getRedirectUri(provider: Registration): String {
        val adaptor = oAuthServiceAdaptors.find { it.support(provider) }
            ?: throw Exception("지원하지 않는 요청입니다.")

        return adaptor.redirectUri()
    }

    fun getAccessToken(code: String, provider: Registration): OAuthToken? {
        val adaptor = oAuthServiceAdaptors.find { it.support(provider) }
            ?: throw Exception("지원하지 않는 요청입니다.")
        return adaptor.getAccessToken(code)
    }

    fun getUserInfo(oAuthToken: OAuthToken): ResponseOAuthUserInfo? {
        val adaptor = oAuthServiceAdaptors.find { it.support(oAuthToken.getProvider()) }
            ?: throw Exception("지원하지 않는 요청입니다.")

        return adaptor.getUserInfo(oAuthToken)
    }

}