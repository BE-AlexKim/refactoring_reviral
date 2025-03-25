package kr.reviral.website.reviral.adapter.out.persistence.oauth.dto

import com.fasterxml.jackson.annotation.JsonProperty
import kr.reviral.website.reviral.domain.enums.Registration

/**
 *packageName    : kr.reviral.website.reviral.adapter.`in`.auth.dto.response
 * fileName       : ResponseKakaoToken
 * author         : joy58
 * date           : 2025-03-24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-24        joy58       최초 생성
 */
data class KakaoToken(
    @JsonProperty("access_token")
    val kakaoAccessToken: String,

    @JsonProperty("token_type")
    val kakaoTokenType: String,

    @JsonProperty("refresh_token")
    val kakaoRefreshToken: String?,

    @JsonProperty("expires_in")
    val kakaoExpiresIn: Int,

    @JsonProperty("scope")
    val kakaoScope: String,

    @JsonProperty("refresh_token_expires_in")
    val kakaoRefreshTokenExpiresIn: Int?

): OAuthToken {

    override fun getAccessToken(): String {
        return kakaoAccessToken
    }

    override fun getRefreshToken(): String? {
        return kakaoRefreshToken
    }

    override fun getGrantType(): String {
        return kakaoTokenType
    }

    override fun getProvider(): Registration {
        return Registration.KAKAO
    }
}
