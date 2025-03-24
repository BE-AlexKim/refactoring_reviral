package kr.reviral.website.reviral.adapter.out.persistence.oauth.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 *packageName    : kr.reviral.website.reviral.adapter.`in`.auth.dto.response
 * fileName       : ResponseKakaoUserInfo
 * author         : joy58
 * date           : 2025-03-24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-24        joy58       최초 생성
 */
data class ResponseKakaoUserInfo(
    @JsonProperty("id")
    val id: Long?,

    @JsonProperty("connected_at")
    val connectedAt: String?,

    @JsonProperty("synched_at")
    val synchedAt: String?,

    @JsonProperty("properties")
    val properties: UserProperties,

    @JsonProperty("kakao_account")
    val kakaoAccount: KakaoAccount
): ResponseOAuthUserInfo {
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class UserProperties(
        @JsonProperty("nickname")
        val nickname: String?,

        @JsonProperty("profile_image")
        val profileImage: String?,

        @JsonProperty("thumbnail_image")
        val thumbnailImage: String?,
    )

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class KakaoAccount(
        @JsonProperty("profile_nickname_needs_agreement")
        val profileNicknameNeedsAgreement: Boolean?,

        @JsonProperty("profile")
        val profile: KakaoProfile,

        @JsonProperty("name_needs_agreement")
        val nameNeedsAgreement: Boolean?,

        @JsonProperty("name")
        val name: String?,

        @JsonProperty("has_email")
        val hasEmail: Boolean?,

        @JsonProperty("email_needs_agreement")
        val emailNeedsAgreement: Boolean?,

        @JsonProperty("is_email_valid")
        val isEmailValid: Boolean?,

        @JsonProperty("is_email_verified")
        val isEmailVerified: Boolean?,

        @JsonProperty("email")
        val email: String?,

        @JsonProperty("has_phone_number")
        val hasPhoneNumber: Boolean?,

        @JsonProperty("phone_number")
        val phoneNumber: String?,

        @JsonProperty("phone_number_needs_agreement")
        val phoneNumberNeedsAgreement: Boolean?,

        @JsonProperty("has_gender")
        val hasGender: Boolean?,

        @JsonProperty("gender")
        val gender: String?,

        @JsonProperty("gender_needs_agreement")
        val genderNeedsAgreement: Boolean?
    )

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class KakaoProfile(
        @JsonProperty("nickname")
        val nickname: String?,

        @JsonProperty("is_default_nickname")
        val isDefaultNickname: Boolean?
    )

    override fun getUsername(): String? {
        return kakaoAccount.name ?: properties.nickname ?: kakaoAccount.profile.nickname
    }

    override fun getIdentity(): String {
        return id.toString()
    }

    override fun getEmail(): String? {
        return kakaoAccount.email
    }

    override fun getProvider(): String {
        return "KaKao"
    }

    override fun getThumbnail(): String? {
        return properties.profileImage ?: properties.thumbnailImage
    }
}
