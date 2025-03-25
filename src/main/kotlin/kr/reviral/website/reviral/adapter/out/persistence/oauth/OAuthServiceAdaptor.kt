package kr.reviral.website.reviral.adapter.out.persistence.oauth

import kr.reviral.website.reviral.adapter.out.persistence.oauth.dto.OAuthToken
import kr.reviral.website.reviral.adapter.out.persistence.oauth.dto.ResponseOAuthUserInfo
import kr.reviral.website.reviral.domain.enums.Registration

/**
 *packageName    : kr.reviral.website.reviral.adapter.out.persistence.oauth
 * fileName       : OAuthServiceAdaptor
 * author         : joy58
 * date           : 2025-03-24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-24        joy58       최초 생성
 */
interface OAuthServiceAdaptor {

    fun redirectUri(): String

    fun getAccessToken(code: String): OAuthToken?

    fun getUserInfo(oAuthToken: OAuthToken): ResponseOAuthUserInfo?

    fun unlink()

    fun support(provider: Registration): Boolean

}