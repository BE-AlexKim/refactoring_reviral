package kr.reviral.website.reviral.adapter.`in`.user.dto.request

import io.swagger.v3.oas.annotations.media.Schema
import kr.reviral.website.reviral.domain.enums.Gender

/**
 *packageName    : kr.reviral.website.reviral.adapter.`in`.user.dto.request
 * fileName       : RequestBasicUserInfo
 * author         : joy58
 * date           : 2025-03-24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-24        joy58       최초 생성
 */
data class RequestBasicUserInfo(
    @Schema(description = "사용자 일련번호")
    val userId: Long,
    @Schema(description = "사용자 성함")
    val name: String,
    @Schema(description = "사용자 2차 비밀번호")
    val password: String,
    @Schema(description = "휴대폰번호(-없이)")
    val phoneNumber: String,
    @Schema(description = "사용자 성별", example = "MAN, WOMEN")
    val gender: Gender,
    @Schema(description = "이벤트 수신동의")
    val isEvent: Boolean,
)
