package kr.reviral.website.reviral.adapter.`in`.auth.dto.request

/**
 *packageName    : kr.reviral.website.reviral.adapter.`in`.auth.dto
 * fileName       : RequestLogin
 * author         : joy58
 * date           : 2025-03-19
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-19        joy58       최초 생성
 */
data class RequestLoginToUser(
    val loginId: String,
    val password: String,
    val role: String
): RequestLoginDTO
