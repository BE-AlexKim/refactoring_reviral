package kr.reviral.website.reviral.domain.port.auth.`in`

import kr.reviral.website.reviral.adapter.out.persistence.oauth.dto.OAuthToken
import kr.reviral.website.reviral.adapter.out.persistence.oauth.dto.ResponseOAuthUserInfo
import kr.reviral.website.reviral.domain.model.Registration

/**
 *packageName    : kr.reviral.website.reviral.domain.port.auth.`in`
 * fileName       : OAuthUseCase
 * author         : joy58
 * date           : 2025-03-24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-24        joy58       최초 생성
 */
interface OAuthProvider {

    fun getRedirectUri(provider: Registration): String

    fun getAccessToken(code: String, provider: Registration): OAuthToken?

    fun getUserInfo(oAuthToken: OAuthToken): ResponseOAuthUserInfo?

    fun unlink()

}