package kr.reviral.website.reviral.adapter.`in`.user.dto.request

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import kr.reviral.website.reviral.domain.model.Gender
import kr.reviral.website.reviral.domain.model.Registration

/**
 *packageName    : kr.reviral.website.reviral.adapter.`in`.user.dto.request
 * fileName       : RequestSaveUser
 * author         : joy58
 * date           : 2025-03-19
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-19        joy58       최초 생성
 */
@Schema(name = "사용자 회원가입 요청 객체")
data class RequestSignUp(
    @Schema(description = "아이디")
    val loginId: String,

    @Schema(description = "비밀번호")
    val loginPw: String,

    @Schema(description = "가입처")
    val registration: Registration,

    @Schema(description = "이름")
    val username: String,

    @Enumerated(EnumType.STRING)
    @Schema(description = "성별")
    val gender: Gender,

    @Schema(description = "휴대폰 번호")
    val phoneNumber: String,

    @Schema(description = "주소")
    val address: String,

    @Schema(description = "N사 아이디", example = "dowpp32")
    val nvId: String? = null,

    @Schema(description = "C사 아이디", example = "eow32@gmail.com")
    val cpId: String? = null,

    @Schema(description = "이벤트 수신 동의", example = "true")
    val isEvent: Boolean = true
)
