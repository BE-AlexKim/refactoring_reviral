package kr.reviral.website.reviral.adapter.out.persistence.oauth.dto

import kr.reviral.website.reviral.domain.enums.Registration

/**
 *packageName    : kr.reviral.website.reviral.adapter.`in`.auth.dto.response
 * fileName       : ResponseOAuthToken
 * author         : joy58
 * date           : 2025-03-24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-24        joy58       최초 생성
 */
sealed interface OAuthToken {
    fun getAccessToken(): String
    fun getRefreshToken(): String?
    fun getGrantType(): String
    fun getProvider(): Registration
}