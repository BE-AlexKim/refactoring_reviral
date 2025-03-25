package kr.reviral.website.reviral.domain.port.auth.`in`

import kr.reviral.website.reviral.adapter.out.persistence.oauth.dto.ResponseOAuthUserInfo
import kr.reviral.website.reviral.domain.enums.Registration

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
interface OAuthService {

    fun getRedirectUri(provider: Registration): String

    fun callback(code: String, provider: Registration): ResponseOAuthUserInfo?

    fun unlink()

}