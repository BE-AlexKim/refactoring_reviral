package kr.reviral.website.reviral.adapter.`in`.auth.dto

/**
 *packageName    : kr.reviral.website.reviral.adapter.`in`.auth.dto
 * fileName       : RequestLoginByAdmin
 * author         : joy58
 * date           : 2025-03-19
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-19        joy58       최초 생성
 */
data class RequestLoginToAdmin(
    val loginId: String,
    val password: String
): RequestLoginDTO
