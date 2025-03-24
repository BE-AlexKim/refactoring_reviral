package kr.reviral.website.reviral.adapter.out.persistence.oauth.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 *packageName    : kr.reviral.website.reviral.adapter.`in`.auth.dto.response
 * fileName       : ResponseNaverUserInfo
 * author         : joy58
 * date           : 2025-03-24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-24        joy58       최초 생성
 */
data class ResponseNaverUserInfo(
    @JsonProperty("resultcode")
    val resultCode: String,

    @JsonProperty("message")
    val message: String,

    @JsonProperty("response")
    val response: NaverAccount
): ResponseOAuthUserInfo {

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class NaverAccount(
        @JsonProperty("id")
        val id: String, // 네이버 고유 ID는 필수 값이므로 nullable 처리하지 않음

        @JsonProperty("email")
        val email: String?, // 이메일은 선택적으로 제공될 수 있음

        @JsonProperty("nickname")
        val nickname: String?, // 닉네임이 없을 수도 있음

        @JsonProperty("profile_image")
        val profileImage: String?, // 프로필 이미지 URL

        @JsonProperty("age")
        val age: String?, // 연령대 (예: "20-29")

        @JsonProperty("gender")
        val gender: String?, // 성별 (M: 남성, F: 여성)

        @JsonProperty("name")
        val name: String?, // 사용자의 실명 (선택적 제공)

        @JsonProperty("birthday")
        val birthday: String?, // 생일 (MM-DD 형식)

        @JsonProperty("birthyear")
        val birthYear: String?, // 출생 연도 (예: "1990")

        @JsonProperty("mobile")
        val mobile: String?, // 휴대전화 번호 (하이픈 포함)

        @JsonProperty("mobile_e164")
        val mobileE164: String? // 국제 표준 형식의 전화번호 (E.164)
    )


    override fun getUsername(): String? {
        TODO("Not yet implemented")
    }

    override fun getIdentity(): String? {
        TODO("Not yet implemented")
    }

    override fun getEmail(): String? {
        TODO("Not yet implemented")
    }

    override fun getProvider(): String? {
        TODO("Not yet implemented")
    }

    override fun getThumbnail(): String? {
        TODO("Not yet implemented")
    }
}
