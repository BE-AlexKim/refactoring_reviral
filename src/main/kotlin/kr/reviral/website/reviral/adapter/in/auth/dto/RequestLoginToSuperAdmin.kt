package kr.reviral.website.reviral.adapter.`in`.auth.dto

/**
 *packageName    : kr.reviral.website.reviral.adapter.`in`.auth.dto
 * fileName       : RequestLoginToSuperAdmin
 * author         : joy58
 * date           : 2025-03-24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-24        joy58       최초 생성
 */
data class RequestLoginToSuperAdmin(
    val loginId: String,
    val loginPw: String
): RequestLoginDTO
