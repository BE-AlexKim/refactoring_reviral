package kr.reviral.website.reviral.adapter.out.persistence.oauth.dto

import com.fasterxml.jackson.annotation.JsonProperty
import kr.reviral.website.reviral.domain.model.Registration

/**
 *packageName    : kr.reviral.website.reviral.adapter.`in`.auth.dto.response
 * fileName       : ResponseNaverToken
 * author         : joy58
 * date           : 2025-03-24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-24        joy58       최초 생성
 */
data class NaverToken(
    @JsonProperty("access_token")
    val naverAccessToken: String,

    @JsonProperty("refresh_token")
    val naverRefreshToken: String,

    @JsonProperty("token_type")
    val naverTokenType: String,

    @JsonProperty("expires_in")
    val naverExpiresIn: Int,
): OAuthToken {

    override fun getAccessToken(): String {
        return naverAccessToken
    }

    override fun getRefreshToken(): String {
        return naverRefreshToken
    }

    override fun getGrantType(): String {
        return naverTokenType
    }

    override fun getProvider(): Registration {
        return Registration.NAVER
    }
}
