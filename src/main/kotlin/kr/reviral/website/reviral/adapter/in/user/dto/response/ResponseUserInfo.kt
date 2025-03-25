package kr.reviral.website.reviral.adapter.`in`.user.dto.response

import io.swagger.v3.oas.annotations.media.Schema

/**
 *packageName    : kr.reviral.website.reviral.adapter.`in`.user.dto.request
 * fileName       : ResponseUserInfo
 * author         : joy58
 * date           : 2025-03-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-18        joy58       최초 생성
 */
data class ResponseUserInfo(
    @Schema(description = "사용자 이름")
    val name: String?,
    @Schema(description = "사용자 로그인 아이디")
    val loginId: String,
    @Schema(description = "휴대폰 번호")
    val phoneNumber: String?,
    @Schema(description = "네이버 아이디")
    val nvId: String?,
    @Schema(description = "쿠팡 아이디")
    val cpId: String?,
    @Schema(description = "주소")
    val address: String?,
    @Schema(description = "계좌은행")
    val bankCode: String?,
    @Schema(description = "계좌번호")
    val accountNumber: String?,
    @Schema(description = "프로필 이미지")
    val profileImage: String
)